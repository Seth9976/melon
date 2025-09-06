package Q;

import B7.b;
import M.m;
import androidx.compose.foundation.lazy.layout.j;
import androidx.compose.foundation.lazy.layout.v;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import m0.c;

public final class x implements v {
    public final K a;
    public final j b;
    public final b c;

    public x(K k0, w w0, b b0) {
        this.a = k0;
        this.b = w0;
        this.c = b0;
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final int b(Object object0) {
        return this.c.n(object0);
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final Object c(int v) {
        Object object0 = this.c.o(v);
        return object0 == null ? this.b.o(v) : object0;
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final void d(int v, Object object0, p p0) {
        p0.a0(-1201380429);
        m0.b b0 = c.e(1142237095, p0, new m(this, v, 3));
        j.e(object0, v, this.a.C, b0, p0, 0xC00);
        p0.p(false);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x ? q.b(this.b, ((x)object0).b) : false;
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final int getItemCount() {
        return this.b.n().a;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode();
    }
}

