package l4;

import android.content.Intent;
import android.os.Bundle;
import k8.Y;

public final class h0 extends z implements d0 {
    public final String a;
    public final String b;
    public final A c;
    public boolean d;
    public int e;
    public int f;
    public c0 g;
    public int h;
    public final i0 i;

    public h0(i0 i00, String s, String s1, A a0) {
        this.i = i00;
        this.e = -1;
        this.a = s;
        this.b = s1;
        this.c = a0;
    }

    @Override  // l4.d0
    public final void a(c0 c00) {
        this.g = c00;
        int v = c00.e;
        c00.e = v + 1;
        Bundle bundle0 = Y.c("routeId", this.a, "routeGroupId", this.b);
        bundle0.putParcelable("routeControllerOptions", this.c.a);
        int v1 = c00.d;
        c00.d = v1 + 1;
        c00.b(3, v1, v, null, bundle0);
        this.h = v;
        if(this.d) {
            c00.a(v);
            int v2 = this.e;
            if(v2 >= 0) {
                c00.c(this.h, v2);
                this.e = -1;
            }
            int v3 = this.f;
            if(v3 != 0) {
                c00.d(this.h, v3);
                this.f = 0;
            }
        }
    }

    @Override  // l4.d0
    public final int b() {
        return this.h;
    }

    @Override  // l4.d0
    public final void c() {
        c0 c00 = this.g;
        if(c00 != null) {
            int v = c00.d;
            c00.d = v + 1;
            c00.b(4, v, this.h, null, null);
            this.g = null;
            this.h = 0;
        }
    }

    @Override  // l4.z
    public final boolean d(Intent intent0, J j0) {
        c0 c00 = this.g;
        if(c00 != null) {
            int v = c00.d;
            c00.d = v + 1;
            if(c00.b(9, v, this.h, intent0, null)) {
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
        this.i.k.remove(this);
        this.c();
        this.i.l();
    }

    @Override  // l4.z
    public final void f() {
        this.d = true;
        c0 c00 = this.g;
        if(c00 != null) {
            c00.a(this.h);
        }
    }

    @Override  // l4.z
    public final void g(int v) {
        c0 c00 = this.g;
        if(c00 != null) {
            c00.c(this.h, v);
            return;
        }
        this.e = v;
        this.f = 0;
    }

    @Override  // l4.z
    public final void h() {
        this.i(0);
    }

    @Override  // l4.z
    public final void i(int v) {
        this.d = false;
        c0 c00 = this.g;
        if(c00 != null) {
            int v1 = this.h;
            Bundle bundle0 = new Bundle();
            bundle0.putInt("unselectReason", v);
            int v2 = c00.d;
            c00.d = v2 + 1;
            c00.b(6, v2, v1, null, bundle0);
        }
    }

    @Override  // l4.z
    public final void j(int v) {
        c0 c00 = this.g;
        if(c00 != null) {
            c00.d(this.h, v);
            return;
        }
        this.f += v;
    }
}

