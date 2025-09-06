package sf;

import Me.E;
import Me.S;
import Me.h;
import Me.k;
import Pe.C;
import e1.u;
import java.util.ArrayList;
import je.F;
import kotlin.jvm.internal.q;
import qf.d;
import qf.e;

public final class b implements c {
    public final int a;
    public static final b b;
    public static final b c;
    public static final b d;

    static {
        b.b = new b(0);
        b.c = new b(1);
        b.d = new b(2);
    }

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // sf.c
    public final String a(h h0, g g0) {
        switch(this.a) {
            case 0: {
                if(h0 instanceof S) {
                    e e0 = ((S)h0).getName();
                    q.f(e0, "getName(...)");
                    return g0.O(e0, false);
                }
                d d0 = tf.e.g(h0);
                q.f(d0, "getFqName(...)");
                return g0.o(u.O(d.e(d0)));
            }
            case 1: {
                if(h0 instanceof S) {
                    e e1 = ((S)h0).getName();
                    q.f(e1, "getName(...)");
                    return g0.O(e1, false);
                }
                ArrayList arrayList0 = new ArrayList();
                do {
                    arrayList0.add(h0.getName());
                    h0 = h0.e();
                }
                while(h0 instanceof Me.e);
                return u.O(new F(arrayList0));
            }
            default: {
                return b.b(h0);
            }
        }
    }

    public static String b(h h0) {
        String s1;
        e e0 = h0.getName();
        q.f(e0, "getName(...)");
        String s = u.N(e0);
        if(!(h0 instanceof S)) {
            k k0 = h0.e();
            q.f(k0, "getContainingDeclaration(...)");
            if(k0 instanceof Me.e) {
                s1 = b.b(((h)k0));
                return s1 == null || s1.equals("") ? s : s1 + '.' + s;
            }
            if(!(k0 instanceof E)) {
                throw new NullPointerException();
            }
            d d0 = ((C)(((E)k0))).e.a;
            q.g(d0, "<this>");
            s1 = u.O(d.e(d0));
            return s1 == null || s1.equals("") ? s : s1 + '.' + s;
        }
        return s;
    }
}

