package androidx.datastore.preferences.protobuf;

public abstract class y implements Cloneable {
    public final A a;
    public A b;

    public y(A a0) {
        this.a = a0;
        if(a0.f()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = a0.h();
    }

    public final A a() {
        A a0 = this.b();
        a0.getClass();
        if(!A.e(a0, true)) {
            throw new k0();
        }
        return a0;
    }

    public final A b() {
        if(!this.b.f()) {
            return this.b;
        }
        A a0 = this.b;
        a0.getClass();
        b0.c.getClass();
        Class class0 = a0.getClass();
        b0.c.a(class0).b(a0);
        a0.g();
        return this.b;
    }

    public final void c() {
        if(!this.b.f()) {
            A a0 = this.a.h();
            A a1 = this.b;
            b0.c.getClass();
            Class class0 = a0.getClass();
            b0.c.a(class0).a(a0, a1);
            this.b = a0;
        }
    }

    @Override
    public final Object clone() {
        y y0 = (y)this.a.b(5);
        y0.b = this.b();
        return y0;
    }
}

