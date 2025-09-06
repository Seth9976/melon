package Pe;

import Ff.v;
import Hf.M;
import Je.i;
import Me.h;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import xf.d;

public final class e implements M {
    public final f a;

    public e(f f0) {
        this.a = f0;
    }

    @Override  // Hf.M
    public final i d() {
        return d.e(this.a);
    }

    @Override  // Hf.M
    public final h e() {
        return this.a;
    }

    @Override  // Hf.M
    public final Collection f() {
        Collection collection0 = ((v)this.a).v1().w().f();
        q.f(collection0, "getSupertypes(...)");
        return collection0;
    }

    @Override  // Hf.M
    public final boolean g() {
        return true;
    }

    @Override  // Hf.M
    public final List getParameters() {
        List list0 = ((v)this.a).r;
        if(list0 != null) {
            return list0;
        }
        q.m("typeConstructorParameters");
        throw null;
    }

    @Override
    public final String toString() {
        return "[typealias " + this.a.getName().b() + ']';
    }
}

