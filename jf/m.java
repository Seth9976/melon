package Jf;

import Af.f;
import Me.h;
import Ue.a;
import Ue.c;
import androidx.appcompat.app.o;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class m extends g {
    @Override  // Jf.g
    public final Set a() {
        throw new IllegalStateException();
    }

    @Override  // Jf.g
    public final Collection b(e e0, c c0) {
        this.i(e0, c0);
        throw null;
    }

    @Override  // Jf.g
    public final h c(e e0, a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        throw new IllegalStateException(this.b + ", required name: " + e0);
    }

    @Override  // Jf.g
    public final Set d() {
        throw new IllegalStateException();
    }

    @Override  // Jf.g
    public final Collection e(f f0, k k0) {
        q.g(f0, "kindFilter");
        throw new IllegalStateException(this.b);
    }

    @Override  // Jf.g
    public final Collection f(e e0, a a0) {
        this.h(e0, ((c)a0));
        throw null;
    }

    @Override  // Jf.g
    public final Set g() {
        throw new IllegalStateException();
    }

    @Override  // Jf.g
    public final Set h(e e0, c c0) {
        q.g(e0, "name");
        throw new IllegalStateException(this.b + ", required name: " + e0);
    }

    @Override  // Jf.g
    public final Set i(e e0, c c0) {
        q.g(e0, "name");
        throw new IllegalStateException(this.b + ", required name: " + e0);
    }

    @Override  // Jf.g
    public final String toString() {
        return o.r(new StringBuilder("ThrowingScope{"), this.b, '}');
    }
}

