package I1;

import A1.e;
import android.view.View;

public final class m extends q {
    public final int k;

    public m(int v) {
        this.k = v;
        super();
    }

    @Override  // I1.q
    public final boolean d(float f, long v, e e0, View view0) {
        switch(this.k) {
            case 0: {
                view0.setAlpha(this.b(f, v, e0, view0));
                return this.h;
            }
            case 1: {
                view0.setElevation(this.b(f, v, e0, view0));
                return this.h;
            }
            case 2: {
                view0.setRotation(this.b(f, v, e0, view0));
                return this.h;
            }
            case 3: {
                view0.setRotationX(this.b(f, v, e0, view0));
                return this.h;
            }
            case 4: {
                view0.setRotationY(this.b(f, v, e0, view0));
                return this.h;
            }
            case 5: {
                view0.setScaleX(this.b(f, v, e0, view0));
                return this.h;
            }
            case 6: {
                view0.setScaleY(this.b(f, v, e0, view0));
                return this.h;
            }
            case 7: {
                view0.setTranslationX(this.b(f, v, e0, view0));
                return this.h;
            }
            case 8: {
                view0.setTranslationY(this.b(f, v, e0, view0));
                return this.h;
            }
            default: {
                view0.setTranslationZ(this.b(f, v, e0, view0));
                return this.h;
            }
        }
    }
}

