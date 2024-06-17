package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes5.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    @Override // androidx.transition.ViewUtilsApi19
    public void transformMatrixToGlobal(View view, Matrix matrix) {
        if (sTryHiddenTransformMatrixToGlobal) {
            try {
                Api29Impl.transformMatrixToGlobal(view, matrix);
            } catch (NoSuchMethodError e) {
                sTryHiddenTransformMatrixToGlobal = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void transformMatrixToLocal(View view, Matrix matrix) {
        if (sTryHiddenTransformMatrixToLocal) {
            try {
                Api29Impl.transformMatrixToLocal(view, matrix);
            } catch (NoSuchMethodError e) {
                sTryHiddenTransformMatrixToLocal = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void setAnimationMatrix(View view, Matrix matrix) {
        if (sTryHiddenSetAnimationMatrix) {
            try {
                Api29Impl.setAnimationMatrix(view, matrix);
            } catch (NoSuchMethodError e) {
                sTryHiddenSetAnimationMatrix = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void transformMatrixToGlobal(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void transformMatrixToLocal(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }

        static void setAnimationMatrix(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }
    }
}
