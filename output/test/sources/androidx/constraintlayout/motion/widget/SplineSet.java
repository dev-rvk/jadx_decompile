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
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    public abstract void setProperty(View view, float f);

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

    public float get(float t) {
        return (float) this.mCurveFit.getPos(t, 0);
    }

    public float getSlope(float t) {
        return (float) this.mCurveFit.getSlope(t, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SplineSet makeSpline(String str) {
        char c;
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
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c = 6;
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
                    c = 7;
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\n';
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
                return new AlphaSet();
            case 1:
                return new ElevationSet();
            case 2:
                return new RotationSet();
            case 3:
                return new RotationXset();
            case 4:
                return new RotationYset();
            case 5:
                return new PivotXset();
            case 6:
                return new PivotYset();
            case 7:
                return new PathRotate();
            case '\b':
                return new ScaleXset();
            case '\t':
                return new ScaleYset();
            case '\n':
                return new AlphaSet();
            case 11:
                return new AlphaSet();
            case '\f':
                return new TranslationXset();
            case '\r':
                return new TranslationYset();
            case 14:
                return new TranslationZset();
            case 15:
                return new ProgressSet();
            default:
                return null;
        }
    }

    public void setPoint(int position, float value) {
        if (this.mTimePoints.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(this.mTimePoints, this.mTimePoints.length * 2);
            this.mValues = Arrays.copyOf(this.mValues, this.mValues.length * 2);
        }
        this.mTimePoints[this.count] = position;
        this.mValues[this.count] = value;
        this.count++;
    }

    public void setup(int curveType) {
        if (this.count == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, this.count - 1);
        int unique = 1;
        for (int i = 1; i < this.count; i++) {
            if (this.mTimePoints[i - 1] != this.mTimePoints[i]) {
                unique++;
            }
        }
        double[] time = new double[unique];
        double[][] values = (double[][]) Array.newInstance((Class<?>) Double.TYPE, unique, 1);
        int k = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            if (i2 <= 0 || this.mTimePoints[i2] != this.mTimePoints[i2 - 1]) {
                time[k] = this.mTimePoints[i2] * 0.01d;
                values[k][0] = this.mValues[i2];
                k++;
            }
        }
        this.mCurveFit = CurveFit.get(curveType, time, values);
    }

    /* loaded from: classes.dex */
    static class ElevationSet extends SplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setElevation(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class AlphaSet extends SplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setAlpha(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class RotationSet extends SplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setRotation(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class RotationXset extends SplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setRotationX(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class RotationYset extends SplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setRotationY(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class PivotXset extends SplineSet {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setPivotX(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class PivotYset extends SplineSet {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setPivotY(get(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PathRotate extends SplineSet {
        PathRotate() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
        }

        public void setPathRotate(View view, float t, double dx, double dy) {
            view.setRotation(get(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    /* loaded from: classes.dex */
    static class ScaleXset extends SplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setScaleX(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class ScaleYset extends SplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setScaleY(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class TranslationXset extends SplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationX(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class TranslationYset extends SplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationY(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class TranslationZset extends SplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationZ(get(t));
        }
    }

    /* loaded from: classes.dex */
    static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int dimensionality = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] time = new double[size];
            this.mTempValues = new float[dimensionality];
            double[][] values = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, dimensionality);
            for (int i = 0; i < size; i++) {
                int key = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute ca = this.mConstraintAttributeList.valueAt(i);
                time[i] = key * 0.01d;
                ca.getValuesToInterpolate(this.mTempValues);
                for (int k = 0; k < this.mTempValues.length; k++) {
                    values[i][k] = this.mTempValues[k];
                }
            }
            this.mCurveFit = CurveFit.get(curveType, time, values);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int position, ConstraintAttribute value) {
            this.mConstraintAttributeList.append(position, value);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            this.mCurveFit.getPos(t, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }
    }

    /* loaded from: classes.dex */
    static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float t) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException e) {
                this.mNoMethod = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(t)));
                } catch (IllegalAccessException e2) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e2);
                } catch (InvocationTargetException e3) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] key, float[] value, int low, int hi) {
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

        private static int partition(int[] array, float[] value, int low, int hi) {
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

        private static void swap(int[] array, float[] value, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
            float tmpv = value[a];
            value[a] = value[b];
            value[b] = tmpv;
        }
    }
}
