package vf;

import Hf.x;
import Me.z;
import kotlin.jvm.internal.q;

public abstract class g {
    public final Object a;

    public g(Object object0) {
        this.a = object0;
    }

    public abstract x a(z arg1);

    public Object b() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            Object object1 = this.b();
            Object object2 = null;
            g g0 = object0 instanceof g ? ((g)object0) : null;
            if(g0 != null) {
                object2 = g0.b();
            }
            return q.b(object1, object2);
        }
        return true;
    }

    @Override
    public final int hashCode() {
        Object object0 = this.b();
        return object0 == null ? 0 : object0.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(this.b());
    }
}

