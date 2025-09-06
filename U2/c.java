package u2;

import android.view.View;
import e1.b;
import v6.j;

public final class c extends b {
    public final int d;

    public c(int v) {
        this.d = v;
        super();
    }

    @Override  // e1.b
    public final float C(j j0) {
        switch(this.d) {
            case 0: {
                return ((View)j0).getAlpha();
            }
            case 1: {
                return ((View)j0).getScaleX();
            }
            case 2: {
                return ((View)j0).getScaleY();
            }
            case 3: {
                return ((View)j0).getRotation();
            }
            case 4: {
                return ((View)j0).getRotationX();
            }
            default: {
                return ((View)j0).getRotationY();
            }
        }
    }

    @Override  // e1.b
    public final void K(j j0, float f) {
        switch(this.d) {
            case 0: {
                ((View)j0).setAlpha(f);
                return;
            }
            case 1: {
                ((View)j0).setScaleX(f);
                return;
            }
            case 2: {
                ((View)j0).setScaleY(f);
                return;
            }
            case 3: {
                ((View)j0).setRotation(f);
                return;
            }
            case 4: {
                ((View)j0).setRotationX(f);
                return;
            }
            default: {
                ((View)j0).setRotationY(f);
            }
        }
    }
}

