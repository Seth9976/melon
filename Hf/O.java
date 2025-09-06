package hf;

import Sf.b;
import Sf.p;
import d5.c;
import ie.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import jd.e3;
import je.A;
import je.D;

public final class o {
    public final String a;
    public final ArrayList b;
    public m c;

    public o(c c0, String s, String s1) {
        this.a = s1;
        this.b = new ArrayList();
        this.c = new m("V", null);
    }

    public final void a(String s, d[] arr_d) {
        q q0;
        kotlin.jvm.internal.q.g(s, "type");
        if(arr_d.length == 0) {
            q0 = null;
        }
        else {
            p p0 = new p(new e3(arr_d, 1), 2);
            int v = D.N(je.q.Q(10, p0));
            if(v < 16) {
                v = 16;
            }
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
            Iterator iterator0 = p0.iterator();
            while(((b)iterator0).b.hasNext()) {
                A a0 = (A)((b)iterator0).next();
                linkedHashMap0.put(a0.a, ((d)a0.b));
            }
            q0 = new q(linkedHashMap0);
        }
        m m0 = new m(s, q0);
        this.b.add(m0);
    }

    public final void b(String s, d[] arr_d) {
        kotlin.jvm.internal.q.g(s, "type");
        p p0 = new p(new e3(arr_d, 1), 2);
        int v = D.N(je.q.Q(10, p0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        Iterator iterator0 = p0.iterator();
        while(((b)iterator0).b.hasNext()) {
            A a0 = (A)((b)iterator0).next();
            linkedHashMap0.put(a0.a, ((d)a0.b));
        }
        this.c = new m(s, new q(linkedHashMap0));
    }

    public final void c(yf.c c0) {
        kotlin.jvm.internal.q.g(c0, "type");
        String s = c0.c();
        kotlin.jvm.internal.q.f(s, "getDesc(...)");
        this.c = new m(s, null);
    }
}

