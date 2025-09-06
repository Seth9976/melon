package N4;

import android.graphics.Matrix;
import android.view.View;

public abstract class g0 {
    public static void a(View view0, Matrix matrix0) {
        view0.setAnimationMatrix(matrix0);
    }

    public static void b(View view0, Matrix matrix0) {
        view0.transformMatrixToGlobal(matrix0);
    }

    public static void c(View view0, Matrix matrix0) {
        view0.transformMatrixToLocal(matrix0);
    }
}

