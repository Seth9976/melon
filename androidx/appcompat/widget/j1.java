package androidx.appcompat.widget;

import E9.w;
import c2.d0;
import j.h;

public final class j1 extends w {
    public final int g;
    public boolean h;
    public int i;
    public final Object j;

    public j1(k1 k10, int v) {
        this.g = 0;
        super();
        this.j = k10;
        this.i = v;
        this.h = false;
    }

    public j1(h h0) {
        this.g = 1;
        super();
        this.j = h0;
        this.h = false;
        this.i = 0;
    }

    @Override  // E9.w
    public void a() {
        if(this.g != 0) {
            return;
        }
        this.h = true;
    }

    @Override  // c2.d0
    public final void onAnimationEnd() {
        if(this.g != 0) {
            int v = this.i + 1;
            this.i = v;
            h h0 = (h)this.j;
            if(v == h0.a.size()) {
                d0 d00 = h0.d;
                if(d00 != null) {
                    d00.onAnimationEnd();
                }
                this.i = 0;
                this.h = false;
                h0.e = false;
            }
            return;
        }
        if(!this.h) {
            ((k1)this.j).a.setVisibility(this.i);
        }
    }

    @Override  // E9.w
    public final void onAnimationStart() {
        if(this.g != 0) {
            if(!this.h) {
                this.h = true;
                d0 d00 = ((h)this.j).d;
                if(d00 != null) {
                    d00.onAnimationStart();
                }
            }
            return;
        }
        ((k1)this.j).a.setVisibility(0);
    }
}

