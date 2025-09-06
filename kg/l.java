package kg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import je.q;
import je.v;
import jg.c;
import jg.h;
import mg.d;

public final class l {
    public h a;
    public String b;
    public final ArrayList c;
    public final boolean d;
    public final ArrayList e;
    public final j f;
    public final l g;
    public final LinkedHashSet h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final Map q;
    public final List r;

    public l(j j0, l l0, LinkedHashSet linkedHashSet0, h h0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, LinkedHashMap linkedHashMap0, ArrayList arrayList0, ArrayList arrayList1, List list0) {
        this.f = j0;
        this.g = l0;
        this.h = linkedHashSet0;
        this.i = s1;
        this.j = s2;
        this.k = s3;
        this.l = s4;
        this.m = s5;
        this.n = s6;
        this.o = s7;
        this.p = s8;
        this.q = linkedHashMap0;
        this.r = arrayList0;
        this.a = h0;
        this.b = s;
        ArrayList arrayList2 = new ArrayList(q.Q(10, arrayList1));
        for(Object object0: arrayList1) {
            ((n)object0).getClass();
            String s9 = ((n)object0).a;
            if(s9 == null) {
                throw new IllegalStateException("serviceType must be set.");
            }
            String s10 = ((n)object0).b;
            if(s10 == null) {
                throw new IllegalStateException("serviceId must be set.");
            }
            String s11 = ((n)object0).c;
            if(s11 == null) {
                throw new IllegalStateException("SCPDURL must be set.");
            }
            String s12 = ((n)object0).d;
            if(s12 == null) {
                throw new IllegalStateException("controlURL must be set.");
            }
            String s13 = ((n)object0).e;
            if(s13 == null) {
                throw new IllegalStateException("eventSubURL must be set.");
            }
            String s14 = ((n)object0).f;
            if(s14 == null) {
                s14 = "";
            }
            arrayList2.add(new p(this, s14, s9, s10, s11, s12, s13, ((n)object0).g, ((n)object0).h));
        }
        this.c = arrayList2;
        this.d = this.g != null;
        ArrayList arrayList3 = new ArrayList(q.Q(10, list0));
        for(Object object1: list0) {
            arrayList3.add(((k)object1).a(this));
        }
        this.e = arrayList3;
    }

    public final p a(String s) {
        kotlin.jvm.internal.q.g(s, "id");
        for(Object object0: this.c) {
            if(kotlin.jvm.internal.q.b(((p)object0).i, s)) {
                return (p)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final void b(Gf.l l0) {
        if(!this.r.isEmpty()) {
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                v v0 = v.a;
                if(!v0.hasNext()) {
                    break;
                }
                Object object0 = v0.next();
                m m0 = (m)object0;
                if(m0 == null) {
                    m0 = null;
                }
                if(m0 != null) {
                    arrayList0.add(m0);
                }
            }
            for(Object object1: arrayList0) {
                m m1 = (m)object1;
                try {
                    String s = this.p == null ? this.b : this.p;
                    int v1 = this.a.f();
                    m1.getClass();
                    kotlin.jvm.internal.q.g(s, "baseUrl");
                    kotlin.jvm.internal.q.d(((d)l0.e(c.a(v1, s, m1.a)).c).c);
                }
                catch(IOException unused_ex) {
                }
            }
        }
    }

    public final void c(h h0) {
        kotlin.jvm.internal.q.g(h0, "message");
        this.a.a();
        if(!this.d) {
            String s = h0.e();
            LinkedHashSet linkedHashSet0 = this.h;
            if(!linkedHashSet0.contains(s)) {
                throw new IllegalArgumentException(("uuid and udn does not match! uuid=" + h0.e() + " udn=" + linkedHashSet0).toString());
            }
        }
        String s1 = h0.g();
        if(s1 == null) {
            throw new IllegalArgumentException();
        }
        this.b = s1;
        this.a = h0;
        for(Object object0: this.e) {
            ((l)object0).c(h0);
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof l ? kotlin.jvm.internal.q.b(this.j, ((l)object0).j) : false;
    }

    @Override
    public final int hashCode() {
        return this.j.hashCode();
    }

    @Override
    public final String toString() {
        return this.l;
    }
}

