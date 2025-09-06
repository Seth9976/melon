package O;

import B7.b;
import M.m;
import androidx.compose.foundation.lazy.layout.v;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import m0.c;

public final class k implements v {
    public final F a;
    public final j b;
    public final d c;
    public final b d;

    public k(F f0, j j0, d d0, b b0) {
        this.a = f0;
        this.b = j0;
        this.c = d0;
        this.d = b0;
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final Object a(int v) {
        return this.b.m(v);
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final int b(Object object0) {
        return this.d.n(object0);
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final Object c(int v) {
        Object object0 = this.d.o(v);
        return object0 == null ? this.b.o(v) : object0;
    }

    @Override  // androidx.compose.foundation.lazy.layout.v
    public final void d(int v, Object object0, p p0) {
        p0.a0(0xE46FF536);
        m0.b b0 = c.e(0xCED7AFC2, p0, new m(this, v, 1));
        androidx.compose.foundation.lazy.layout.j.e(object0, v, this.a.q, b0, p0, 0xC00);
        p0.p(false);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k ? q.b(this.b, ((k)object0).b) : false;
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

