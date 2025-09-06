package g6;

import M6.u;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import e.k;

public final class a extends k {
    public int f;
    public int g;
    public final SwipeDismissBehavior h;

    public a(SwipeDismissBehavior swipeDismissBehavior0) {
        this.h = swipeDismissBehavior0;
        this.g = -1;
    }

    @Override  // e.k
    public final void F(View view0, int v) {
        this.g = v;
        this.f = view0.getLeft();
        ViewParent viewParent0 = view0.getParent();
        if(viewParent0 != null) {
            this.h.c = true;
            viewParent0.requestDisallowInterceptTouchEvent(true);
            this.h.c = false;
        }
    }

    @Override  // e.k
    public final void G(int v) {
    }

    @Override  // e.k
    public final void H(View view0, int v, int v1) {
        float f = ((float)view0.getWidth()) * this.h.e;
        float f1 = ((float)view0.getWidth()) * this.h.f;
        float f2 = (float)Math.abs(v - this.f);
        if(Float.compare(f2, f) <= 0) {
            view0.setAlpha(1.0f);
            return;
        }
        if(Float.compare(f2, f1) >= 0) {
            view0.setAlpha(0.0f);
            return;
        }
        view0.setAlpha(Math.min(Math.max(0.0f, 1.0f - (f2 - f) / (f1 - f)), 1.0f));
    }

    @Override  // e.k
    public final void I(View view0, float f, float f1) {
        int v2;
        this.g = -1;
        int v = view0.getWidth();
        int v1 = Float.compare(f, 0.0f);
        boolean z = false;
        SwipeDismissBehavior swipeDismissBehavior0 = this.h;
        if(v1 != 0) {
            boolean z1 = view0.getLayoutDirection() == 1;
            switch(swipeDismissBehavior0.d) {
                case 0: {
                    if(!z1) {
                        if(v1 <= 0) {
                            v2 = this.f;
                        }
                        else {
                            goto label_25;
                        }
                    }
                    else if(f >= 0.0f) {
                        v2 = this.f;
                    }
                    else {
                        goto label_25;
                    }
                    break;
                }
                case 1: {
                    if(!z1) {
                        if(f >= 0.0f) {
                            v2 = this.f;
                        }
                        else {
                            goto label_25;
                        }
                    }
                    else if(v1 <= 0) {
                        v2 = this.f;
                    }
                    else {
                        goto label_25;
                    }
                    break;
                }
                case 2: {
                    goto label_25;
                }
                default: {
                    v2 = this.f;
                }
            }
        }
        else if(Math.abs(view0.getLeft() - this.f) >= Math.round(((float)view0.getWidth()) * 0.5f)) {
        label_25:
            if(f >= 0.0f) {
                int v3 = view0.getLeft();
                int v4 = this.f;
                v2 = v3 >= v4 ? v4 + v : this.f - v;
            }
            else {
                v2 = this.f - v;
            }
            z = true;
        }
        else {
            v2 = this.f;
        }
        if(swipeDismissBehavior0.a.s(v2, view0.getTop())) {
            view0.postOnAnimation(new u(swipeDismissBehavior0, view0, z));
        }
    }

    // 去混淆评级： 低(20)
    @Override  // e.k
    public final boolean P(View view0, int v) {
        return (this.g == -1 || this.g == v) && this.h.w(view0);
    }

    @Override  // e.k
    public final int j(View view0, int v) {
        int v2;
        boolean z = view0.getLayoutDirection() == 1;
        int v1 = this.h.d;
        if(v1 == 0) {
            if(z) {
                return Math.min(Math.max(this.f - view0.getWidth(), v), this.f);
            }
            v2 = this.f;
            return Math.min(Math.max(v2, v), view0.getWidth() + v2);
        }
        if(v1 == 1) {
            if(z) {
                v2 = this.f;
                return Math.min(Math.max(v2, v), view0.getWidth() + v2);
            }
            return Math.min(Math.max(this.f - view0.getWidth(), v), this.f);
        }
        v2 = this.f - view0.getWidth();
        int v3 = this.f;
        return Math.min(Math.max(v2, v), view0.getWidth() + v3);
    }

    @Override  // e.k
    public final int k(View view0, int v) {
        return view0.getTop();
    }

    @Override  // e.k
    public final int v(View view0) {
        return view0.getWidth();
    }
}

