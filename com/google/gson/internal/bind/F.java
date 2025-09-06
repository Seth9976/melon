package com.google.gson.internal.bind;

import T7.j;
import T7.k;
import T7.l;
import T7.m;
import T7.n;
import U4.x;
import W7.a;
import com.google.gson.E;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.s;
import com.google.gson.t;
import com.google.gson.v;
import e0.b;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

public class f extends E {
    public static final f a;

    static {
        f.a = new f();
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        q q1;
        Object object0;
        if(a0 instanceof h) {
            int v = ((h)a0).Z();
            if(v == 2 || v == 5 || (v == 4 || v == 10)) {
                throw new IllegalStateException("Unexpected " + x.B(v) + " when reading a JsonElement.");
            }
            q q0 = (q)((h)a0).s0();
            ((h)a0).i0();
            return q0;
        }
        int v1 = a0.Z();
        switch(b.b(v1)) {
            case 0: {
                a0.h();
                object0 = new p();
                break;
            }
            case 2: {
                a0.m();
                object0 = new t();
                break;
            }
            default: {
                object0 = null;
            }
        }
        if(object0 == null) {
            return f.d(a0, v1);
        }
        ArrayDeque arrayDeque0 = new ArrayDeque();
        while(true) {
            if(a0.E()) {
                String s = object0 instanceof t ? a0.P() : null;
                int v2 = a0.Z();
                switch(b.b(v2)) {
                    case 0: {
                        a0.h();
                        q1 = new p();
                        break;
                    }
                    case 2: {
                        a0.m();
                        q1 = new t();
                        break;
                    }
                    default: {
                        q1 = null;
                    }
                }
                boolean z = q1 != null;
                if(q1 == null) {
                    q1 = f.d(a0, v2);
                }
                if(object0 instanceof p) {
                    ((p)object0).a.add(q1);
                }
                else {
                    ((t)object0).d(s, q1);
                }
                if(!z) {
                    continue;
                }
                arrayDeque0.addLast(object0);
                object0 = q1;
            }
            else {
                if(object0 instanceof p) {
                    a0.q();
                }
                else {
                    a0.r();
                }
                if(arrayDeque0.isEmpty()) {
                    break;
                }
                object0 = (q)arrayDeque0.removeLast();
            }
        }
        return object0;
    }

    @Override  // com.google.gson.E
    public final void c(W7.b b0, Object object0) {
        f.e(b0, ((q)object0));
    }

    public static q d(a a0, int v) {
        switch(b.b(v)) {
            case 5: {
                return new v(a0.W());
            }
            case 6: {
                return new v(new j(a0.W()));
            }
            case 7: {
                return new v(Boolean.valueOf(a0.H()));
            }
            case 8: {
                a0.T();
                return s.a;
            }
            default: {
                throw new IllegalStateException("Unexpected token: " + x.B(v));
            }
        }
    }

    public static void e(W7.b b0, q q0) {
        if(q0 != null && !(q0 instanceof s)) {
            if(q0 instanceof v) {
                Serializable serializable0 = ((v)q0).a;
                if(serializable0 instanceof Number) {
                    b0.N(((v)q0).g());
                    return;
                }
                if(serializable0 instanceof Boolean) {
                    b0.Q(((v)q0).e());
                    return;
                }
                b0.P(((v)q0).b());
                return;
            }
            if(q0 instanceof p) {
                b0.m();
                if(!(q0 instanceof p)) {
                    throw new IllegalStateException("Not a JSON Array: " + q0);
                }
                for(Object object0: ((p)q0).a) {
                    f.e(b0, ((q)object0));
                }
                b0.q();
                return;
            }
            if(!(q0 instanceof t)) {
                throw new IllegalArgumentException("Couldn\'t write " + q0.getClass());
            }
            b0.o();
            if(!(q0 instanceof t)) {
                throw new IllegalStateException("Not a JSON Object: " + q0);
            }
            Iterator iterator1 = ((l)((t)q0).a.entrySet()).iterator();
            while(((m)iterator1).hasNext()) {
                n n0 = ((k)iterator1).a();
                b0.s(((String)n0.getKey()));
                f.e(b0, ((q)n0.getValue()));
            }
            b0.r();
            return;
        }
        b0.B();
    }
}

