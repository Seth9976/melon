package vf;

import Hf.I;
import Hf.M;
import Hf.c;
import Je.i;
import Jf.h;
import Jf.l;
import d3.g;
import ie.r;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import je.w;
import kotlin.jvm.internal.q;

public final class p implements M {
    public final Set a;
    public final r b;

    public p(Set set0) {
        I.b.getClass();
        q.g(I.c, "attributes");
        c.v(l.a(h.c, true, new String[]{"unknown integer literal type"}), I.c, this, w.a, false);
        this.b = g.Q(new m());  // 初始化器: Ljava/lang/Object;-><init>()V
        this.a = set0;
    }

    @Override  // Hf.M
    public final i d() {
        throw null;
    }

    @Override  // Hf.M
    public final Me.h e() {
        return null;
    }

    @Override  // Hf.M
    public final Collection f() {
        return (List)this.b.getValue();
    }

    @Override  // Hf.M
    public final boolean g() {
        return false;
    }

    @Override  // Hf.M
    public final List getParameters() {
        return w.a;
    }

    @Override
    public final String toString() {
        return "IntegerLiteralType" + ("[" + je.p.q0(this.a, ",", null, null, n.a, 30) + ']');
    }
}

