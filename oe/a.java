package Oe;

import Ff.u;
import Me.e;
import java.util.Collection;
import je.w;
import kotlin.jvm.internal.q;

public final class a implements b, d {
    public final int a;
    public static final a b;
    public static final a c;
    public static final a d;

    static {
        a.b = new a(0);
        a.c = new a(1);
        a.d = new a(2);
    }

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // Oe.b
    public Collection a(e e0) {
        return w.a;
    }

    @Override  // Oe.d
    public boolean b(e e0, u u0) {
        if(this.a != 1) {
            q.g(e0, "classDescriptor");
            return !u0.getAnnotations().c(Oe.e.a);
        }
        q.g(e0, "classDescriptor");
        return true;
    }

    @Override  // Oe.b
    public Collection c(qf.e e0, e e1) {
        q.g(e0, "name");
        q.g(e1, "classDescriptor");
        return w.a;
    }

    @Override  // Oe.b
    public Collection d(e e0) {
        q.g(e0, "classDescriptor");
        return w.a;
    }

    @Override  // Oe.b
    public Collection e(e e0) {
        return w.a;
    }
}

