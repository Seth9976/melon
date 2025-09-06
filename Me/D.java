package me;

import androidx.appcompat.app.o;
import gd.M6;
import gd.T7;
import ie.H;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import we.n;

public final class d implements Serializable, i {
    public final i a;
    public final g b;

    public d(i i0, g g0) {
        q.g(i0, "left");
        q.g(g0, "element");
        super();
        this.a = i0;
        this.b = g0;
    }

    public final int a() {
        int v = 2;
        d d0 = this;
        while(true) {
            d0 = d0.a instanceof d ? ((d)d0.a) : null;
            if(d0 == null) {
                break;
            }
            ++v;
        }
        return v;
    }

    @Override
    public final boolean equals(Object object0) {
        i i0;
        if(this != object0) {
            if(object0 instanceof d && ((d)object0).a() == this.a()) {
                for(d d0 = this; true; d0 = (d)i0) {
                    if(!q.b(((d)object0).get(d0.b.getKey()), d0.b)) {
                        return false;
                    }
                    i0 = d0.a;
                    if(!(i0 instanceof d)) {
                        break;
                    }
                }
                q.e(i0, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return q.b(((d)object0).get(((g)i0).getKey()), ((g)i0));
            }
            return false;
        }
        return true;
    }

    @Override  // me.i
    public final Object fold(Object object0, n n0) {
        q.g(n0, "operation");
        return n0.invoke(this.a.fold(object0, n0), this.b);
    }

    @Override  // me.i
    public final g get(h h0) {
        i i0;
        q.g(h0, "key");
        for(d d0 = this; true; d0 = (d)i0) {
            g g0 = d0.b.get(h0);
            if(g0 != null) {
                return g0;
            }
            i0 = d0.a;
            if(!(i0 instanceof d)) {
                break;
            }
        }
        return i0.get(h0);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode();
    }

    @Override  // me.i
    public final i minusKey(h h0) {
        q.g(h0, "key");
        i i0 = this.b;
        g g0 = i0.get(h0);
        i i1 = this.a;
        if(g0 != null) {
            return i1;
        }
        i i2 = i1.minusKey(h0);
        if(i2 == i1) {
            return this;
        }
        return i2 == j.a ? i0 : new d(i2, ((g)i0));
    }

    @Override  // me.i
    public final i plus(i i0) {
        q.g(i0, "context");
        return i0 == j.a ? this : ((i)i0.fold(this, new M6(19)));
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("["), ((String)this.fold("", new M6(18))), ']');
    }

    private final Object writeReplace() {
        int v = this.a();
        i[] arr_i = new i[v];
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        T7 t70 = new T7(25, arr_i, f0);
        this.fold(H.a, t70);
        if(f0.a != v) {
            throw new IllegalStateException("Check failed.");
        }
        return new c(arr_i);
    }
}

