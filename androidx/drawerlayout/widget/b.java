package androidx.drawerlayout.widget;

import E9.t;
import android.view.View;
import e.k;
import j2.c;

public final class b extends k {
    public final int f;
    public c g;
    public final t h;
    public final DrawerLayout i;

    public b(DrawerLayout drawerLayout0, int v) {
        this.i = drawerLayout0;
        this.h = new t(this, 25);
        this.f = v;
    }

    @Override  // e.k
    public final void D(int v, int v1) {
        View view0 = (v & 1) == 1 ? this.i.d(3) : this.i.d(5);
        if(view0 != null && this.i.f(view0) == 0) {
            this.g.c(view0, v1);
        }
    }

    @Override  // e.k
    public final void E() {
        this.i.postDelayed(this.h, 0xA0L);
    }

    @Override  // e.k
    public final void F(View view0, int v) {
        ((LayoutParams)view0.getLayoutParams()).c = false;
        DrawerLayout drawerLayout0 = this.i;
        View view1 = drawerLayout0.d((this.f == 3 ? 5 : 3));
        if(view1 != null) {
            drawerLayout0.b(view1, true);
        }
    }

    @Override  // e.k
    public final void G(int v) {
        this.i.q(this.g.t, v);
    }

    @Override  // e.k
    public final void H(View view0, int v, int v1) {
        int v2 = view0.getWidth();
        float f = (this.i.a(view0, 3) ? ((float)(v + v2)) : ((float)(this.i.getWidth() - v))) / ((float)v2);
        this.i.n(view0, f);
        view0.setVisibility((f == 0.0f ? 4 : 0));
        this.i.invalidate();
    }

    @Override  // e.k
    public final void I(View view0, float f, float f1) {
        int v2;
        float f2 = ((LayoutParams)view0.getLayoutParams()).b;
        int v = view0.getWidth();
        DrawerLayout drawerLayout0 = this.i;
        if(drawerLayout0.a(view0, 3)) {
            int v1 = Float.compare(f, 0.0f);
            v2 = v1 > 0 || v1 == 0 && f2 > 0.5f ? 0 : -v;
        }
        else {
            int v3 = drawerLayout0.getWidth();
            if(f < 0.0f || f == 0.0f && f2 > 0.5f) {
                v3 -= v;
            }
            v2 = v3;
        }
        this.g.s(v2, view0.getTop());
        drawerLayout0.invalidate();
    }

    // 去混淆评级： 低(20)
    @Override  // e.k
    public final boolean P(View view0, int v) {
        return DrawerLayout.k(view0) && (this.i.a(view0, this.f) && this.i.f(view0) == 0);
    }

    @Override  // e.k
    public final int j(View view0, int v) {
        DrawerLayout drawerLayout0 = this.i;
        if(drawerLayout0.a(view0, 3)) {
            return Math.max(-view0.getWidth(), Math.min(v, 0));
        }
        int v1 = drawerLayout0.getWidth();
        return Math.max(v1 - view0.getWidth(), Math.min(v, v1));
    }

    @Override  // e.k
    public final int k(View view0, int v) {
        return view0.getTop();
    }

    // 去混淆评级： 低(20)
    @Override  // e.k
    public final int v(View view0) {
        return DrawerLayout.k(view0) ? view0.getWidth() : 0;
    }
}

