package s3;

import B7.b;
import H7.c;
import androidx.media3.session.H0;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.k;
import k3.l;

public final class i implements l, D {
    public final Object a;
    public b b;
    public k c;
    public final s3.k d;

    public i(s3.k k0, Object object0) {
        this.d = k0;
        this.b = new b(0, ((CopyOnWriteArrayList)k0.c.c), null);
        this.c = new k(k0.d.c, 0, null);
        this.a = object0;
    }

    @Override  // k3.l
    public final void a(int v, z z0, int v1) {
        if(this.l(v, z0)) {
            this.c.c(v1);
        }
    }

    @Override  // s3.D
    public final void b(int v, z z0, v v1) {
        if(this.l(v, z0)) {
            b b0 = this.b;
            v v2 = this.m(v1, z0);
            z z1 = (z)b0.b;
            z1.getClass();
            b0.k(new c(b0, z1, v2, 21));
        }
    }

    @Override  // s3.D
    public final void c(int v, z z0, q q0, v v1, IOException iOException0, boolean z1) {
        if(this.l(v, z0)) {
            b b0 = this.b;
            v v2 = this.m(v1, z0);
            b0.getClass();
            b0.k(new com.iloen.melon.fragments.comments.i(b0, q0, v2, iOException0, z1));
        }
    }

    @Override  // k3.l
    public final void d(int v, z z0) {
        if(this.l(v, z0)) {
            this.c.a();
        }
    }

    @Override  // k3.l
    public final void e(int v, z z0) {
        if(this.l(v, z0)) {
            this.c.b();
        }
    }

    @Override  // s3.D
    public final void f(int v, z z0, v v1) {
        if(this.l(v, z0)) {
            b b0 = this.b;
            v v2 = this.m(v1, z0);
            b0.getClass();
            b0.k(new H0(27, b0, v2));
        }
    }

    @Override  // k3.l
    public final void g(int v, z z0) {
        if(this.l(v, z0)) {
            this.c.e();
        }
    }

    @Override  // s3.D
    public final void h(int v, z z0, q q0, v v1) {
        if(this.l(v, z0)) {
            b b0 = this.b;
            v v2 = this.m(v1, z0);
            b0.getClass();
            b0.k(new B(b0, q0, v2, 0));
        }
    }

    @Override  // s3.D
    public final void i(int v, z z0, q q0, v v1) {
        if(this.l(v, z0)) {
            b b0 = this.b;
            v v2 = this.m(v1, z0);
            b0.getClass();
            b0.k(new B(b0, q0, v2, 2));
        }
    }

    @Override  // s3.D
    public final void j(int v, z z0, q q0, v v1) {
        if(this.l(v, z0)) {
            b b0 = this.b;
            v v2 = this.m(v1, z0);
            b0.getClass();
            b0.k(new B(b0, q0, v2, 1));
        }
    }

    @Override  // k3.l
    public final void k(int v, z z0, Exception exception0) {
        if(this.l(v, z0)) {
            this.c.d(exception0);
        }
    }

    public final boolean l(int v, z z0) {
        z z1;
        Object object0 = this.a;
        s3.k k0 = this.d;
        if(z0 == null) {
            z1 = null;
        }
        else {
            z1 = k0.t(object0, z0);
            if(z1 == null) {
                return false;
            }
        }
        int v1 = k0.v(object0, v);
        if(this.b.a != v1 || !Objects.equals(((z)this.b.b), z1)) {
            this.b = new b(v1, ((CopyOnWriteArrayList)k0.c.c), z1);
        }
        if(this.c.a != v1 || !Objects.equals(this.c.b, z1)) {
            this.c = new k(k0.d.c, v1, z1);
        }
        return true;
    }

    public final v m(v v0, z z0) {
        long v1 = this.d.u(this.a, v0.f);
        long v2 = this.d.u(this.a, v0.g);
        return v1 != v0.f || v2 != v0.g ? new v(v0.a, v0.b, v0.c, v0.d, v0.e, v1, v2) : v0;
    }
}

