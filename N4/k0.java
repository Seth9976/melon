package N4;

import android.graphics.Matrix;
import android.view.View;

public final class k0 extends j0 {
    @Override  // N4.L
    public final float g(View view0) {
        return view0.getTransitionAlpha();
    }

    @Override  // N4.L
    public final void j(View view0, float f) {
        view0.setTransitionAlpha(f);
    }

    @Override  // N4.j0
    public final void k(View view0, int v) {
        view0.setTransitionVisibility(v);
    }

    @Override  // N4.j0
    public final void m(View view0, Matrix matrix0) {
        view0.setAnimationMatrix(matrix0);
    }

    @Override  // N4.j0
    public final void n(View view0, int v, int v1, int v2, int v3) {
        view0.setLeftTopRightBottom(v, v1, v2, v3);
    }

    @Override  // N4.j0
    public final void o(View view0, Matrix matrix0) {
        view0.transformMatrixToGlobal(matrix0);
    }

    @Override  // N4.j0
    public final void p(View view0, Matrix matrix0) {
        view0.transformMatrixToLocal(matrix0);
    }
}

