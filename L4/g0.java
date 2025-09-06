package l4;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import k8.Y;

public final class g0 extends y implements d0 {
    public final String f;
    public final A g;
    public String h;
    public String i;
    public boolean j;
    public int k;
    public int l;
    public c0 m;
    public int n;
    public final i0 o;

    public g0(i0 i00, String s, A a0) {
        this.o = i00;
        super();
        this.k = -1;
        this.n = -1;
        this.f = s;
        this.g = a0;
    }

    @Override  // l4.d0
    public final void a(c0 c00) {
        f0 f00 = new f0(this);
        this.m = c00;
        int v = c00.e;
        c00.e = v + 1;
        int v1 = c00.d;
        c00.d = v1 + 1;
        Bundle bundle0 = Y.b("memberRouteId", this.f);
        bundle0.putParcelable("routeControllerOptions", this.g.a);
        c00.b(11, v1, v, null, bundle0);
        c00.h.put(v1, f00);
        this.n = v;
        if(this.j) {
            c00.a(v);
            int v2 = this.k;
            if(v2 >= 0) {
                c00.c(this.n, v2);
                this.k = -1;
            }
            int v3 = this.l;
            if(v3 != 0) {
                c00.d(this.n, v3);
                this.l = 0;
            }
        }
    }

    @Override  // l4.d0
    public final int b() {
        return this.n;
    }

    @Override  // l4.d0
    public final void c() {
        c0 c00 = this.m;
        if(c00 != null) {
            int v = c00.d;
            c00.d = v + 1;
            c00.b(4, v, this.n, null, null);
            this.m = null;
            this.n = 0;
        }
    }

    @Override  // l4.z
    public final boolean d(Intent intent0, J j0) {
        c0 c00 = this.m;
        if(c00 != null) {
            int v = c00.d;
            c00.d = v + 1;
            if(c00.b(9, v, this.n, intent0, null)) {
                if(j0 != null) {
                    c00.h.put(v, j0);
                }
                return true;
            }
        }
        return false;
    }

    @Override  // l4.z
    public final void e() {
        this.o.k.remove(this);
        this.c();
        this.o.l();
    }

    @Override  // l4.z
    public final void f() {
        this.j = true;
        c0 c00 = this.m;
        if(c00 != null) {
            c00.a(this.n);
        }
    }

    @Override  // l4.z
    public final void g(int v) {
        c0 c00 = this.m;
        if(c00 != null) {
            c00.c(this.n, v);
            return;
        }
        this.k = v;
        this.l = 0;
    }

    @Override  // l4.z
    public final void h() {
        this.i(0);
    }

    @Override  // l4.z
    public final void i(int v) {
        this.j = false;
        c0 c00 = this.m;
        if(c00 != null) {
            int v1 = this.n;
            Bundle bundle0 = new Bundle();
            bundle0.putInt("unselectReason", v);
            int v2 = c00.d;
            c00.d = v2 + 1;
            c00.b(6, v2, v1, null, bundle0);
        }
    }

    @Override  // l4.z
    public final void j(int v) {
        c0 c00 = this.m;
        if(c00 != null) {
            c00.d(this.n, v);
            return;
        }
        this.l += v;
    }

    @Override  // l4.y
    public final String k() {
        return this.h;
    }

    @Override  // l4.y
    public final String l() {
        return this.i;
    }

    @Override  // l4.y
    public final void n(String s) {
        c0 c00 = this.m;
        if(c00 != null) {
            int v = this.n;
            c00.getClass();
            Bundle bundle0 = new Bundle();
            bundle0.putString("memberRouteId", s);
            int v1 = c00.d;
            c00.d = v1 + 1;
            c00.b(12, v1, v, null, bundle0);
        }
    }

    @Override  // l4.y
    public final void o(String s) {
        c0 c00 = this.m;
        if(c00 != null) {
            int v = this.n;
            c00.getClass();
            Bundle bundle0 = new Bundle();
            bundle0.putString("memberRouteId", s);
            int v1 = c00.d;
            c00.d = v1 + 1;
            c00.b(13, v1, v, null, bundle0);
        }
    }

    @Override  // l4.y
    public final void p(List list0) {
        c0 c00 = this.m;
        if(c00 != null) {
            int v = this.n;
            c00.getClass();
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("memberRouteIds", new ArrayList(list0));
            int v1 = c00.d;
            c00.d = v1 + 1;
            c00.b(14, v1, v, null, bundle0);
        }
    }
}

