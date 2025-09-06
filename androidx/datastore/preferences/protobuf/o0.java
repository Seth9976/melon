package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

public final class o0 extends q0 {
    public final int b;

    public o0(Unsafe unsafe0, int v) {
        this.b = v;
        super(unsafe0);
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final boolean c(long v, Object object0) {
        if(this.b != 0) {
            return r0.g ? r0.b(v, object0) : r0.c(v, object0);
        }
        return r0.g ? r0.b(v, object0) : r0.c(v, object0);
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final double d(long v, Object object0) {
        return Double.longBitsToDouble(this.g(object0, v));
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final float e(long v, Object object0) {
        return Float.intBitsToFloat(this.f(object0, v));
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final void j(Object object0, long v, boolean z) {
        if(this.b != 0) {
            if(r0.g) {
                r0.k(object0, v, ((byte)z));
                return;
            }
            r0.l(object0, v, ((byte)z));
            return;
        }
        if(r0.g) {
            r0.k(object0, v, ((byte)z));
            return;
        }
        r0.l(object0, v, ((byte)z));
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final void k(Object object0, long v, byte b) {
        if(this.b != 0) {
            if(r0.g) {
                r0.k(object0, v, b);
                return;
            }
            r0.l(object0, v, b);
            return;
        }
        if(r0.g) {
            r0.k(object0, v, b);
            return;
        }
        r0.l(object0, v, b);
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final void l(Object object0, long v, double f) {
        if(this.b != 0) {
            this.o(object0, v, Double.doubleToLongBits(f));
            return;
        }
        this.o(object0, v, Double.doubleToLongBits(f));
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final void m(Object object0, long v, float f) {
        if(this.b != 0) {
            this.n(Float.floatToIntBits(f), v, object0);
            return;
        }
        this.n(Float.floatToIntBits(f), v, object0);
    }

    @Override  // androidx.datastore.preferences.protobuf.q0
    public final boolean r() {
        return false;
    }
}

