package androidx.appcompat.app;

import E9.w;
import android.view.View;
import android.widget.PopupWindow;
import c2.K;
import d5.v;

public final class r extends w {
    public final int g;
    public final Object h;

    public r(Object object0, int v) {
        this.g = v;
        this.h = object0;
        super();
    }

    @Override  // c2.d0
    public final void onAnimationEnd() {
        Object object0 = this.h;
        switch(this.g) {
            case 0: {
                ((p)object0).b.I.setAlpha(1.0f);
                ((p)object0).b.S.d(null);
                ((p)object0).b.S = null;
                return;
            }
            case 1: {
                ((D)object0).I.setAlpha(1.0f);
                ((D)object0).S.d(null);
                ((D)object0).S = null;
                return;
            }
            default: {
                D d0 = (D)((v)object0).b;
                d0.I.setVisibility(8);
                PopupWindow popupWindow0 = d0.M;
                if(popupWindow0 != null) {
                    popupWindow0.dismiss();
                }
                else if(d0.I.getParent() instanceof View) {
                    K.c(((View)d0.I.getParent()));
                }
                d0.I.e();
                d0.S.d(null);
                d0.S = null;
                K.c(d0.V);
            }
        }
    }

    @Override  // E9.w
    public void onAnimationStart() {
        Object object0 = this.h;
        switch(this.g) {
            case 0: {
                ((p)object0).b.I.setVisibility(0);
                return;
            }
            case 1: {
                ((D)object0).I.setVisibility(0);
                if(((D)object0).I.getParent() instanceof View) {
                    K.c(((View)((D)object0).I.getParent()));
                }
            }
        }
    }
}

