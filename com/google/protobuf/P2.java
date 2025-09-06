package com.google.protobuf;

import Vd.w;
import java.util.Iterator;
import java.util.Map.Entry;

public final class p2 implements E2 {
    public final l2 a;
    public final T2 b;
    public final boolean c;
    public final h1 d;

    public p2(T2 t20, h1 h10, l2 l20) {
        this.b = t20;
        h10.getClass();
        this.c = l20 instanceof GeneratedMessageLite.ExtendableMessage;
        this.d = h10;
        this.a = l20;
    }

    @Override  // com.google.protobuf.E2
    public final void a(Object object0, Object object1) {
        F2.l(this.b, object0, object1);
        if(this.c) {
            this.d.getClass();
            o1 o10 = ((GeneratedMessageLite.ExtendableMessage)object1).extensions;
            if(!o10.a.isEmpty()) {
                ((GeneratedMessageLite.ExtendableMessage)object0).ensureExtensionsAreMutable().m(o10);
            }
        }
    }

    @Override  // com.google.protobuf.E2
    public final void b(Object object0) {
        this.b.getClass();
        S2 s20 = ((A1)object0).unknownFields;
        if(s20.e) {
            s20.e = false;
        }
        this.d.getClass();
        ((GeneratedMessageLite.ExtendableMessage)object0).extensions.l();
    }

    @Override  // com.google.protobuf.E2
    public final boolean c(Object object0) {
        this.d.getClass();
        return ((GeneratedMessageLite.ExtendableMessage)object0).extensions.i();
    }

    @Override  // com.google.protobuf.E2
    public final Object d() {
        l2 l20 = this.a;
        return l20 instanceof A1 ? ((A1)l20).newMutableInstance() : l20.newBuilderForType().B();
    }

    @Override  // com.google.protobuf.E2
    public final void e(Object object0, e2 e20) {
        this.d.getClass();
        Iterator iterator0 = ((GeneratedMessageLite.ExtendableMessage)object0).extensions.k();
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            x1 x10 = (x1)((Map.Entry)object1).getKey();
            if(x10.b.a != k3.j || x10.c || x10.d) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            int v = x10.a;
            Object object2 = ((Map.Entry)object1).getValue();
            x x0 = (x)e20.a;
            if(object2 instanceof o) {
                x0.g0(v, ((o)object2));
            }
            else {
                x0.f0(v, ((l2)object2));
            }
        }
        this.b.getClass();
        S2 s20 = ((A1)object0).unknownFields;
        s20.getClass();
        e20.getClass();
        for(int v1 = 0; v1 < s20.a; ++v1) {
            int v2 = s20.b[v1] >>> 3;
            Object object3 = s20.c[v1];
            x x1 = (x)e20.a;
            if(object3 instanceof o) {
                x1.g0(v2, ((o)object3));
            }
            else {
                x1.f0(v2, ((l2)object3));
            }
        }
    }

    @Override  // com.google.protobuf.E2
    public final void f(Object object0, w w0, g1 g10) {
        T2 t20 = this.b;
        S2 s20 = t20.a(object0);
        h1 h10 = this.d;
        h10.getClass();
        o1 o10 = ((GeneratedMessageLite.ExtendableMessage)object0).ensureExtensionsAreMutable();
        try {
            while(w0.h() != 0x7FFFFFFF && this.k(w0, g10, h10, o10, t20, s20)) {
            }
        }
        finally {
            ((A1)object0).unknownFields = s20;
        }
    }

    @Override  // com.google.protobuf.E2
    public final void g(Object object0, byte[] arr_b, int v, int v1, g g0) {
        S2 s20 = ((A1)object0).unknownFields;
        if(s20 == S2.f) {
            s20 = new S2();
            ((A1)object0).unknownFields = s20;
        }
        o1 o10 = ((GeneratedMessageLite.ExtendableMessage)object0).ensureExtensionsAreMutable();
        int v2 = v;
        y1 y10 = null;
        while(v2 < v1) {
            y1 y11 = y10;
            int v3 = h.x(arr_b, v2, g0);
            int v4 = g0.a;
            g1 g10 = g0.d;
            l2 l20 = this.a;
            h1 h10 = this.d;
            if(v4 == 11) {
                int v5 = 0;
                o o0 = null;
                while(v3 < v1) {
                    v3 = h.x(arr_b, v3, g0);
                    int v6 = g0.a;
                    int v7 = v6 & 7;
                    switch(v6 >>> 3) {
                        case 2: {
                            if(v7 == 0) {
                                v3 = h.x(arr_b, v3, g0);
                                v5 = g0.a;
                                h10.getClass();
                                y11 = g10.a(v5, l20);
                                continue;
                            }
                            break;
                        }
                        case 3: {
                            if(y11 != null) {
                                Class class1 = y11.c.getClass();
                                v3 = h.h(B2.c.a(class1), arr_b, v3, v1, g0);
                                o10.o(y11.d, g0.c);
                                continue;
                            }
                            else if(v7 == 2) {
                                v3 = h.d(arr_b, v3, g0);
                                o0 = (o)g0.c;
                                continue;
                            }
                        }
                    }
                    if(v6 == 12) {
                        break;
                    }
                    v3 = h.H(v6, arr_b, v3, v1, g0);
                }
                if(o0 != null) {
                    s20.f(v5 << 3 | 2, o0);
                }
                v2 = v3;
            }
            else if((v4 & 7) == 2) {
                h10.getClass();
                y11 = g10.a(v4 >>> 3, l20);
                if(y11 == null) {
                    v2 = h.s(v4, arr_b, v3, v1, s20, g0);
                }
                else {
                    Class class0 = y11.c.getClass();
                    v2 = h.h(B2.c.a(class0), arr_b, v3, v1, g0);
                    o10.o(y11.d, g0.c);
                }
            }
            else {
                v2 = h.H(v4, arr_b, v3, v1, g0);
            }
            y10 = y11;
        }
        if(v2 != v1) {
            throw R1.g();
        }
    }

    @Override  // com.google.protobuf.E2
    public final int h(A1 a10) {
        this.b.getClass();
        int v = a10.unknownFields.hashCode();
        if(this.c) {
            this.d.getClass();
            return ((GeneratedMessageLite.ExtendableMessage)a10).extensions.a.hashCode() + v * 53;
        }
        return v;
    }

    @Override  // com.google.protobuf.E2
    public final int i(A1 a10) {
        this.b.getClass();
        S2 s20 = a10.unknownFields;
        int v = s20.d;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < s20.a; ++v1) {
                v2 += x.J(3, ((o)s20.c[v1])) + (x.P(s20.b[v1] >>> 3) + 3);
            }
            s20.d = v2;
            v = v2;
        }
        if(this.c) {
            this.d.getClass();
            return ((GeneratedMessageLite.ExtendableMessage)a10).extensions.f() + v;
        }
        return v;
    }

    @Override  // com.google.protobuf.E2
    public final boolean j(A1 a10, A1 a11) {
        this.b.getClass();
        S2 s20 = a10.unknownFields;
        this.b.getClass();
        if(!s20.equals(a11.unknownFields)) {
            return false;
        }
        if(this.c) {
            this.d.getClass();
            o1 o10 = ((GeneratedMessageLite.ExtendableMessage)a10).extensions;
            this.d.getClass();
            return o10.equals(((GeneratedMessageLite.ExtendableMessage)a11).extensions);
        }
        return true;
    }

    public final boolean k(w w0, g1 g10, h1 h10, o1 o10, T2 t20, S2 s20) {
        int v = w0.b;
        l2 l20 = this.a;
        if(v != 11) {
            if((v & 7) == 2) {
                h10.getClass();
                y1 y10 = g10.a(v >>> 3, l20);
                if(y10 != null) {
                    h10.getClass();
                    Object object0 = w0.X(y10.c.getClass(), g10);
                    o10.o(y10.d, object0);
                    return true;
                }
                return t20.b(0, w0, s20);
            }
            return w0.x0();
        }
        y1 y11 = null;
        o o0 = null;
        int v1 = 0;
        while(w0.h() != 0x7FFFFFFF) {
            int v2 = w0.b;
            if(v2 == 16) {
                w0.v0(0);
                v1 = ((t)w0.e).F();
                h10.getClass();
                y11 = g10.a(v1, l20);
            }
            else if(v2 == 26) {
                if(y11 == null) {
                    o0 = w0.w();
                }
                else {
                    h10.getClass();
                    Object object1 = w0.X(y11.c.getClass(), g10);
                    o10.o(y11.d, object1);
                }
            }
            else if(v2 == 12 || !w0.x0()) {
                break;
            }
        }
        if(w0.b != 12) {
            throw R1.a();
        }
        if(o0 != null) {
            if(y11 != null) {
                h10.getClass();
                k2 k20 = y11.c.newBuilderForType();
                t t0 = o0.i();
                ((t1)k20).g(t0, g10);
                l2 l21 = k20.B();
                o10.o(y11.d, l21);
                t0.a(0);
                return true;
            }
            t20.getClass();
            s20.f(v1 << 3 | 2, o0);
        }
        return true;
    }
}

