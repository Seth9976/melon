package kg;

import ie.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import je.C;
import je.w;
import jg.h;
import kotlin.jvm.internal.q;

public final class k {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public final ArrayList j;
    public final ArrayList k;
    public Object l;
    public final LinkedHashMap m;
    public final j n;
    public h o;

    public k(j j0, h h0) {
        q.g(h0, "ssdpMessage");
        super();
        this.n = j0;
        this.o = h0;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = w.a;
        String s = this.o.g();
        if(s == null) {
            throw new IllegalArgumentException();
        }
        this.a = s;
        this.m = C.T(new m[]{new m("", new LinkedHashMap())});
    }

    public final l a(l l0) {
        String s = this.b;
        if(s == null) {
            throw new IllegalStateException("description must be set.");
        }
        String s1 = this.d;
        if(s1 == null) {
            throw new IllegalStateException("deviceType must be set.");
        }
        String s2 = this.e;
        if(s2 == null) {
            throw new IllegalStateException("friendlyName must be set.");
        }
        String s3 = this.f;
        if(s3 == null) {
            throw new IllegalStateException("manufacturer must be set.");
        }
        String s4 = this.g;
        if(s4 == null) {
            throw new IllegalStateException("modelName must be set.");
        }
        String s5 = this.c;
        if(s5 == null) {
            throw new IllegalStateException("UDN must be set.");
        }
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        k.b(this, linkedHashSet0);
        if(l0 == null) {
            String s6 = this.o.e();
            s6.getClass();
            if(!linkedHashSet0.contains(s6)) {
                throw new IllegalStateException(("uuid and udn does not match! uuid=" + s6 + " udn=" + linkedHashSet0).toString());
            }
        }
        return new l(this.n, l0, linkedHashSet0, this.o, this.a, s, s5, s1, s2, s3, s4, this.h, this.i, this.m, this.j, this.k, ((List)this.l));
    }

    public static void b(k k0, LinkedHashSet linkedHashSet0) {
        String s = k0.c;
        if(s != null) {
            linkedHashSet0.add(s);
        }
        for(Object object0: ((Iterable)k0.l)) {
            k.b(((k)object0), linkedHashSet0);
        }
    }

    public final void c(h h0) {
        q.g(h0, "message");
        this.o.a();
        String s = h0.g();
        if(s == null) {
            throw new IllegalArgumentException();
        }
        this.a = s;
        this.o = h0;
        for(Object object0: ((Iterable)this.l)) {
            ((k)object0).c(h0);
        }
    }
}

