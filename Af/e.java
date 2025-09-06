package af;

import Je.o;
import Ne.n;
import Se.s;
import ie.m;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import je.C;
import je.q;
import je.u;
import je.y;
import vf.b;
import vf.j;

public abstract class e {
    public static final Object a;
    public static final Object b;

    static {
        e.a = C.S(new m[]{new m("PACKAGE", EnumSet.noneOf(n.class)), new m("TYPE", EnumSet.of(n.B, n.Y)), new m("ANNOTATION_TYPE", EnumSet.of(n.D)), new m("TYPE_PARAMETER", EnumSet.of(n.E)), new m("FIELD", EnumSet.of(n.I)), new m("LOCAL_VARIABLE", EnumSet.of(n.M)), new m("PARAMETER", EnumSet.of(n.N)), new m("CONSTRUCTOR", EnumSet.of(n.S)), new m("METHOD", EnumSet.of(n.T, n.V, n.W)), new m("TYPE_USE", EnumSet.of(n.X))});
        e.b = C.S(new m[]{new m("RUNTIME", Ne.m.a), new m("CLASS", Ne.m.b), new m("SOURCE", Ne.m.c)});
    }

    public static b a(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(object0 instanceof s) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            String s = qf.e.e(((s)object1).b.name()).b();
            EnumSet enumSet0 = (EnumSet)((Map)e.a).get(s);
            if(enumSet0 == null) {
                enumSet0 = y.a;
            }
            u.U(arrayList1, enumSet0);
        }
        ArrayList arrayList2 = new ArrayList(q.Q(10, arrayList1));
        for(Object object2: arrayList1) {
            kotlin.jvm.internal.q.g(o.u, "topLevelFqName");
            arrayList2.add(new j(new qf.b(o.u.b(), o.u.a.f()), qf.e.e(((n)object2).name())));
        }
        return new b(arrayList2, d.a);
    }
}

