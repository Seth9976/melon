package G;

public final class j0 implements k {
    public final A0 a;
    public final y0 b;
    public final Object c;
    public final Object d;
    public final u e;
    public final u f;
    public final u g;
    public long h;
    public u i;

    public j0(o o0, y0 y00, Object object0, Object object1, u u0) {
        A0 a00 = o0.a(y00);
        super();
        this.a = a00;
        this.b = y00;
        this.c = object1;
        this.d = object0;
        this.e = (u)y00.a.invoke(object0);
        this.f = (u)y00.a.invoke(object1);
        this.g = u0 == null ? ((u)y00.a.invoke(object0)).c() : f.j(u0);
        this.h = -1L;
    }

    @Override  // G.k
    public final boolean b() {
        return this.a.b();
    }

    @Override  // G.k
    public final u c(long v) {
        if(!this.d(v)) {
            return this.a.c(v, this.e, this.f, this.g);
        }
        u u0 = this.i;
        if(u0 == null) {
            u0 = this.a.l(this.e, this.f, this.g);
            this.i = u0;
        }
        return u0;
    }

    @Override  // G.k
    public final long e() {
        if(this.h < 0L) {
            this.h = this.a.a(this.e, this.f, this.g);
        }
        return this.h;
    }

    @Override  // G.k
    public final y0 f() {
        return this.b;
    }

    @Override  // G.k
    public final Object g(long v) {
        if(!this.d(v)) {
            u u0 = this.a.h(v, this.e, this.f, this.g);
            int v1 = u0.b();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(Float.isNaN(u0.a(v2))) {
                    W.b(("AnimationVector cannot contain a NaN. " + u0 + ". Animation: " + this + ", playTimeNanos: " + v));
                }
            }
            return this.b.b.invoke(u0);
        }
        return this.c;
    }

    @Override  // G.k
    public final Object h() {
        return this.c;
    }

    @Override
    public final String toString() {
        return "TargetBasedAnimation: " + this.d + " -> " + this.c + ",initial velocity: " + this.g + ", duration: " + this.e() / 1000000L + " ms,animationSpec: " + this.a;
    }
}

