package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);

    public String toString() {
        String str = this.mType;
        DecimalFormat df = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            str = str + "[" + this.mTimePoints[i] + " , " + df.format(this.mValues[i]) + "] ";
        }
        return str;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public float get(float pos, long time, View view, KeyCache cache) {
        this.mCurveFit.getPos(pos, this.mCache);
        float period = this.mCache[1];
        if (period == 0.0f) {
            this.mContinue = false;
            return this.mCache[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            this.last_cycle = cache.getFloatValue(view, this.mType, 0);
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = 0.0f;
            }
        }
        long delta_time = time - this.last_time;
        this.last_cycle = (float) ((this.last_cycle + ((delta_time * 1.0E-9d) * period)) % 1.0d);
        cache.setFloatValue(view, this.mType, 0, this.last_cycle);
        this.last_time = time;
        float v = this.mCache[0];
        float wave = calcWave(this.last_cycle);
        float offset = this.mCache[2];
        float value = (v * wave) + offset;
        this.mContinue = (v == 0.0f && period == 0.0f) ? false : true;
        return value;
    }

    protected float calcWave(float period) {
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(VAL_2PI * period);
            case 2:
                return 1.0f - Math.abs(period);
            case 3:
                return (((period * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((period * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(VAL_2PI * period);
            case 6:
                float x = 1.0f - Math.abs(((period * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (x * x);
            default:
                return (float) Math.sin(VAL_2PI * period);
        }
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0092. Please report as an issue. */
    public static TimeCycleSplineSet makeSpline(String str, long currentTime) {
        char c;
        TimeCycleSplineSet timeCycle;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                timeCycle = new AlphaSet();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 1:
                timeCycle = new ElevationSet();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 2:
                timeCycle = new RotationSet();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 3:
                timeCycle = new RotationXset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 4:
                timeCycle = new RotationYset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 5:
                timeCycle = new PathRotate();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 6:
                timeCycle = new ScaleXset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 7:
                timeCycle = new ScaleYset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case '\b':
                timeCycle = new TranslationXset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case '\t':
                timeCycle = new TranslationYset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case '\n':
                timeCycle = new TranslationZset();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            case 11:
                timeCycle = new ProgressSet();
                timeCycle.setStartTime(currentTime);
                return timeCycle;
            default:
                return null;
        }
    }

    protected void setStartTime(long currentTime) {
        this.last_time = currentTime;
    }

    public void setPoint(int position, float value, float period, int shape, float offset) {
        this.mTimePoints[this.count] = position;
        this.mValues[this.count][0] = value;
        this.mValues[this.count][1] = period;
        this.mValues[this.count][2] = offset;
        this.mWaveShape = Math.max(this.mWaveShape, shape);
        this.count++;
    }

    public void setup(int curveType) {
        if (this.count == 0) {
            Log.e(TAG, "Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, this.count - 1);
        int unique = 0;
        for (int i = 1; i < this.mTimePoints.length; i++) {
            if (this.mTimePoints[i] != this.mTimePoints[i - 1]) {
                unique++;
            }
        }
        if (unique == 0) {
            unique = 1;
        }
        double[] time = new double[unique];
        double[][] values = (double[][]) Array.newInstance((Class<?>) Double.TYPE, unique, 3);
        int k = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            if (i2 <= 0 || this.mTimePoints[i2] != this.mTimePoints[i2 - 1]) {
                time[k] = this.mTimePoints[i2] * 0.01d;
                values[k][0] = this.mValues[i2][0];
                values[k][1] = this.mValues[i2][1];
                values[k][2] = this.mValues[i2][2];
                k++;
            }
        }
        this.mCurveFit = CurveFit.get(curveType, time, values);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ElevationSet extends TimeCycleSplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setElevation(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setAlpha(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RotationSet extends TimeCycleSplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotation(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RotationXset extends TimeCycleSplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RotationYset extends TimeCycleSplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PathRotate extends TimeCycleSplineSet {
        PathRotate() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            return this.mContinue;
        }

        public boolean setPathRotate(View view, KeyCache cache, float t, long time, double dx, double dy) {
            view.setRotation(get(t, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ScaleXset extends TimeCycleSplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ScaleYset extends TimeCycleSplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TranslationXset extends TimeCycleSplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TranslationYset extends TimeCycleSplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TranslationZset extends TimeCycleSplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationZ(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int dimensionality = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] time = new double[size];
            this.mTempValues = new float[dimensionality + 2];
            this.mCache = new float[dimensionality];
            double[][] values = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, dimensionality + 2);
            for (int i = 0; i < size; i++) {
                int key = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute ca = this.mConstraintAttributeList.valueAt(i);
                float[] waveProp = this.mWaveProperties.valueAt(i);
                time[i] = key * 0.01d;
                ca.getValuesToInterpolate(this.mTempValues);
                for (int k = 0; k < this.mTempValues.length; k++) {
                    values[i][k] = this.mTempValues[k];
                }
                values[i][dimensionality] = waveProp[0];
                values[i][dimensionality + 1] = waveProp[1];
            }
            this.mCurveFit = CurveFit.get(curveType, time, values);
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int position, float value, float period, int shape, float offset) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int position, ConstraintAttribute value, float period, int shape, float offset) {
            this.mConstraintAttributeList.append(position, value);
            this.mWaveProperties.append(position, new float[]{period, offset});
            this.mWaveShape = Math.max(this.mWaveShape, shape);
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            this.mCurveFit.getPos(t, this.mTempValues);
            float period = this.mTempValues[this.mTempValues.length - 2];
            float offset = this.mTempValues[this.mTempValues.length - 1];
            long delta_time = time - this.last_time;
            this.last_cycle = (float) ((this.last_cycle + ((delta_time * 1.0E-9d) * period)) % 1.0d);
            this.last_time = time;
            float wave = calcWave(this.last_cycle);
            this.mContinue = false;
            for (int i = 0; i < this.mCache.length; i++) {
                this.mContinue |= ((double) this.mTempValues[i]) != 0.0d;
                this.mCache[i] = (this.mTempValues[i] * wave) + offset;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (period != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t, time, view, cache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException e) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(t, time, view, cache)));
                    } catch (IllegalAccessException e2) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e3);
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] key, float[][] value, int low, int hi) {
            int[] stack = new int[key.length + 10];
            int count = 0 + 1;
            stack[0] = hi;
            int count2 = count + 1;
            stack[count] = low;
            while (count2 > 0) {
                int count3 = count2 - 1;
                int low2 = stack[count3];
                count2 = count3 - 1;
                int hi2 = stack[count2];
                if (low2 < hi2) {
                    int p = partition(key, value, low2, hi2);
                    int count4 = count2 + 1;
                    stack[count2] = p - 1;
                    int count5 = count4 + 1;
                    stack[count4] = low2;
                    int count6 = count5 + 1;
                    stack[count5] = hi2;
                    count2 = count6 + 1;
                    stack[count6] = p + 1;
                }
            }
        }

        private static int partition(int[] array, float[][] value, int low, int hi) {
            int pivot = array[hi];
            int i = low;
            for (int j = low; j < hi; j++) {
                if (array[j] <= pivot) {
                    swap(array, value, i, j);
                    i++;
                }
            }
            swap(array, value, i, hi);
            return i;
        }

        private static void swap(int[] array, float[][] value, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
            float[] tmpv = value[a];
            value[a] = value[b];
            value[b] = tmpv;
        }
    }
}
