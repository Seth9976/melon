package G;

import kotlin.jvm.internal.q;

public final class n0 implements m0 {
    public final Object a;
    public final Object b;

    public n0(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
    }

    @Override  // G.m0
    public final Object b() {
        return this.b;
    }

    @Override  // G.m0
    public final Object c() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof m0) {
            Object object1 = ((m0)object0).c();
            if(q.b(this.a, object1)) {
                Object object2 = ((m0)object0).b();
                return q.b(this.b, object2);
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 * 0x1F + v;
    }
}

