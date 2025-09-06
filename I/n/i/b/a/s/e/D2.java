package i.n.i.b.a.s.e;

import ea.b;

public abstract class d2 implements q7 {
    public final int a;
    public final b b;
    public Ha c;
    public int d;
    public int e;
    public B7 f;
    public u[] g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public L9 l;

    public d2(int v) {
        this.a = v;
        this.b = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.i = 0x8000000000000000L;
    }

    @Override  // i.n.i.b.a.s.e.q7
    public void a(int v, Object object0) {
    }

    public abstract void b();

    public void c() {
    }

    public void d() {
    }

    public final int f(b b0, I8 i80, int v) {
        B7 b70 = this.f;
        b70.getClass();
        int v1 = b70.b(b0, i80, v);
        if(v1 == -4) {
            if(i80.f(4)) {
                this.i = 0x8000000000000000L;
                return this.j ? -4 : -3;
            }
            long v2 = i80.f + this.h;
            i80.f = v2;
            this.i = Math.max(this.i, v2);
            return -4;
        }
        if(v1 == -5) {
            u u0 = (u)b0.b;
            u0.getClass();
            long v3 = u0.r;
            if(v3 != 0x7FFFFFFFFFFFFFFFL) {
                ob ob0 = u0.a();
                ob0.o = v3 + this.h;
                b0.b = new u(ob0);
            }
        }
        return v1;
    }

    public abstract int g(u arg1);

    public final y7 h(Exception exception0, u u0, boolean z) {
        int v;
        if(u0 == null || this.k) {
            v = 4;
        }
        else {
            try {
                this.k = true;
                v = this.g(u0) & 7;
                this.k = false;
            }
            catch(y7 unused_ex) {
                this.k = false;
                v = 4;
            }
            catch(Throwable throwable0) {
                this.k = false;
                throw throwable0;
            }
        }
        String s = this.r();
        int v1 = this.d;
        return u0 == null ? new y7(1, exception0, s, v1, null, 4, z) : new y7(1, exception0, s, v1, u0, v, z);
    }

    public void i(float f, float f1) {
    }

    public abstract void j(long arg1, long arg2);

    public abstract void k(long arg1, boolean arg2);

    public void l(boolean z, boolean z1) {
    }

    public abstract void m(u[] arg1, long arg2, long arg3);

    public final void n() {
        M7.J(this.e == 0);
        this.b.d();
        this.c();
    }

    public void o(boolean z) {
    }

    public abstract boolean p();

    public abstract boolean q();

    public abstract String r();

    public final boolean s() {
        return this.i == 0x8000000000000000L;
    }

    public S9 u() {
        return null;
    }

    public int v() {
        return 0;
    }

    public boolean w() {
        return this.q();
    }

    public final boolean x() {
        if(this.s()) {
            return this.j;
        }
        B7 b70 = this.f;
        b70.getClass();
        return b70.d();
    }
}

