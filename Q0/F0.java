package Q0;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import org.jetbrains.annotations.NotNull;
import y0.M;

public final class f0 implements e0 {
    public final Matrix a;
    public final int[] b;

    public f0() {
        this.a = new Matrix();
        this.b = new int[2];
    }

    @Override  // Q0.e0
    public void c(@NotNull View view0, @NotNull float[] arr_f) {
        Matrix matrix0 = this.a;
        matrix0.reset();
        view0.transformMatrixToGlobal(matrix0);
        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof View; viewParent0 = view0.getParent()) {
            view0 = (View)viewParent0;
        }
        view0.getLocationOnScreen(this.b);
        int v = this.b[0];
        int v1 = this.b[1];
        view0.getLocationInWindow(this.b);
        matrix0.postTranslate(((float)(this.b[0] - v)), ((float)(this.b[1] - v1)));
        M.s(matrix0, arr_f);
    }
}

