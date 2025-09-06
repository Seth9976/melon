package rf;

import i.n.i.b.a.s.e.qb;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class g {
    public final y a;
    public boolean b;
    public static final g c;

    static {
        g.c = new g(0);
    }

    public g() {
        this.a = new y(16);
    }

    public g(int v) {
        this.a = new y(0);
        this.f();
    }

    public final void a(k k0, Object object0) {
        List list0;
        if(!k0.c) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        g.j(k0.b, object0);
        y y0 = this.a;
        Object object1 = y0.get(k0);
        if(object1 == null) {
            list0 = new ArrayList();
            y0.e(k0, list0);
        }
        else {
            list0 = (List)object1;
        }
        list0.add(object0);
    }

    public final g b() {
        g g0 = new g();
        for(int v = 0; true; ++v) {
            y y0 = this.a;
            if(v >= y0.b.size()) {
                break;
            }
            Map.Entry map$Entry0 = (Map.Entry)y0.b.get(v);
            g0.i(((k)map$Entry0.getKey()), map$Entry0.getValue());
        }
        for(Object object0: y0.c()) {
            g0.i(((k)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        return g0;
    }

    public static int c(J j0, Object object0) {
        switch(j0.ordinal()) {
            case 0: {
                ((Double)object0).getClass();
                return 8;
            }
            case 1: {
                ((Float)object0).getClass();
                return 4;
            }
            case 2: {
                return A3.g.i(((long)(((Long)object0))));
            }
            case 3: {
                return A3.g.i(((long)(((Long)object0))));
            }
            case 4: {
                return A3.g.e(((int)(((Integer)object0))));
            }
            case 5: {
                ((Long)object0).getClass();
                return 8;
            }
            case 6: {
                ((Integer)object0).getClass();
                return 4;
            }
            case 7: {
                ((Boolean)object0).getClass();
                return 1;
            }
            case 8: {
                String s = (String)object0;
                try {
                    byte[] arr_b = s.getBytes("UTF-8");
                    return A3.g.h(arr_b.length) + arr_b.length;
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    throw new RuntimeException("UTF-8 not supported.", unsupportedEncodingException0);
                }
            }
            case 9: {
                return ((a)object0).a();
            }
            case 10: {
                return A3.g.g(((a)object0));
            }
            case 11: {
                return object0 instanceof d ? ((d)object0).size() + A3.g.h(((d)object0).size()) : A3.g.h(((byte[])object0).length) + ((byte[])object0).length;
            }
            case 12: {
                return A3.g.h(((int)(((Integer)object0))));
            }
            case 13: {
                return object0 instanceof n ? A3.g.e(((n)object0).a()) : A3.g.e(((int)(((Integer)object0))));
            }
            case 14: {
                ((Integer)object0).getClass();
                return 4;
            }
            case 15: {
                ((Long)object0).getClass();
                return 8;
            }
            case 16: {
                int v = (int)(((Integer)object0));
                return A3.g.h(v >> 0x1F ^ v << 1);
            }
            case 17: {
                long v1 = (long)(((Long)object0));
                return A3.g.i(v1 >> 0x3F ^ v1 << 1);
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    @Override
    public final Object clone() {
        return this.b();
    }

    public static int d(k k0, Object object0) {
        J j0 = k0.b;
        int v = k0.a;
        if(k0.c) {
            int v1 = 0;
            for(Object object1: ((List)object0)) {
                v1 += g.c(j0, object1) + (j0 == J.e ? A3.g.j(v) * 2 : A3.g.j(v));
            }
            return v1;
        }
        return g.c(j0, object0) + (j0 == J.e ? A3.g.j(v) * 2 : A3.g.j(v));
    }

    public static boolean e(Map.Entry map$Entry0) {
        k k0 = (k)map$Entry0.getKey();
        if(k0.b.a == K.j) {
            if(k0.c) {
                Iterator iterator0 = ((List)map$Entry0.getValue()).iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        return true;
                    }
                    Object object0 = iterator0.next();
                    if(((a)object0).isInitialized()) {
                        continue;
                    }
                    return false;
                }
            }
            Object object1 = map$Entry0.getValue();
            if(!(object1 instanceof a)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            return ((a)object1).isInitialized();
        }
        return true;
    }

    public final void f() {
        if(this.b) {
            return;
        }
        y y0 = this.a;
        if(!y0.d) {
            for(int v = 0; v < y0.b.size(); ++v) {
                Map.Entry map$Entry0 = (Map.Entry)y0.b.get(v);
                if(((k)map$Entry0.getKey()).c) {
                    map$Entry0.setValue(Collections.unmodifiableList(((List)map$Entry0.getValue())));
                }
            }
            for(Object object0: y0.c()) {
                Map.Entry map$Entry1 = (Map.Entry)object0;
                if(((k)map$Entry1.getKey()).c) {
                    map$Entry1.setValue(Collections.unmodifiableList(((List)map$Entry1.getValue())));
                }
            }
        }
        if(!y0.d) {
            y0.c = y0.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(y0.c);
            y0.d = true;
        }
        this.b = true;
    }

    public final void g(Map.Entry map$Entry0) {
        k k0 = (k)map$Entry0.getKey();
        byte[] arr_b = map$Entry0.getValue();
        y y0 = this.a;
        if(k0.c) {
            ArrayList arrayList0 = y0.get(k0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
            }
            for(byte[] arr_b1: ((List)arr_b)) {
                if(arr_b1 instanceof byte[]) {
                    byte[] arr_b2 = new byte[arr_b1.length];
                    System.arraycopy(arr_b1, 0, arr_b2, 0, arr_b1.length);
                    arr_b1 = arr_b2;
                }
                arrayList0.add(arr_b1);
            }
            y0.e(k0, arrayList0);
            return;
        }
        if(k0.b.a == K.j) {
            Object object0 = y0.get(k0);
            if(object0 == null) {
                if(arr_b instanceof byte[]) {
                    byte[] arr_b3 = new byte[arr_b.length];
                    System.arraycopy(arr_b, 0, arr_b3, 0, arr_b.length);
                    arr_b = arr_b3;
                }
                y0.e(k0, arr_b);
                return;
            }
            y0.e(k0, ((a)object0).c().c(((m)(((a)arr_b)))).a());
            return;
        }
        if(arr_b instanceof byte[]) {
            byte[] arr_b4 = new byte[arr_b.length];
            System.arraycopy(arr_b, 0, arr_b4, 0, arr_b.length);
            arr_b = arr_b4;
        }
        y0.e(k0, arr_b);
    }

    public static Object h(qb qb0, J j0) {
        boolean z = true;
        switch(j0.ordinal()) {
            case 0: {
                return Double.longBitsToDouble(qb0.m());
            }
            case 1: {
                return Float.intBitsToFloat(qb0.l());
            }
            case 2: {
                return qb0.o();
            }
            case 3: {
                return qb0.o();
            }
            case 4: {
                return qb0.n();
            }
            case 5: {
                return qb0.m();
            }
            case 6: {
                return qb0.l();
            }
            case 7: {
                if(qb0.o() == 0L) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            case 8: {
                int v = qb0.n();
                int v1 = qb0.c;
                if(v <= qb0.a - v1 && v > 0) {
                    String s = new String(((byte[])qb0.h), v1, v, "UTF-8");
                    qb0.c += v;
                    return s;
                }
                return v == 0 ? "" : new String(qb0.k(v), "UTF-8");
            }
            case 9: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            }
            case 10: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            }
            case 11: {
                return qb0.h();
            }
            case 12: {
                return qb0.n();
            }
            case 13: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            }
            case 14: {
                return qb0.l();
            }
            case 15: {
                return qb0.m();
            }
            case 16: {
                int v2 = qb0.n();
                return (int)(-(v2 & 1) ^ v2 >>> 1);
            }
            case 17: {
                long v3 = qb0.o();
                return (long)(-(v3 & 1L) ^ v3 >>> 1);
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    public final void i(k k0, Object object0) {
        J j0 = k0.b;
        if(k0.c) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(((List)object0));
            for(Object object1: arrayList0) {
                g.j(j0, object1);
            }
            object0 = arrayList0;
        }
        else {
            g.j(j0, object0);
        }
        this.a.e(k0, object0);
    }

    public static void j(J j0, Object object0) {
        object0.getClass();
        boolean z = true;
        boolean z1 = false;
        switch(j0.a.ordinal()) {
            case 0: {
                z1 = object0 instanceof Integer;
                break;
            }
            case 1: {
                z1 = object0 instanceof Long;
                break;
            }
            case 2: {
                z1 = object0 instanceof Float;
                break;
            }
            case 3: {
                z1 = object0 instanceof Double;
                break;
            }
            case 4: {
                z1 = object0 instanceof Boolean;
                break;
            }
            case 5: {
                z1 = object0 instanceof String;
                break;
            }
            case 6: {
                if(!(object0 instanceof d) && !(object0 instanceof byte[])) {
                    z = false;
                }
                z1 = z;
                break;
            }
            case 7: {
                if(!(object0 instanceof Integer) && !(object0 instanceof n)) {
                    z = false;
                }
                z1 = z;
                break;
            }
            case 8: {
                z1 = object0 instanceof a;
            }
        }
        if(!z1) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static void k(A3.g g0, J j0, Object object0) {
        switch(j0.ordinal()) {
            case 0: {
                g0.getClass();
                g0.L(Double.doubleToRawLongBits(((double)(((Double)object0)))));
                return;
            }
            case 1: {
                g0.getClass();
                g0.K(Float.floatToRawIntBits(((float)(((Float)object0)))));
                return;
            }
            case 2: {
                g0.N(((long)(((Long)object0))));
                return;
            }
            case 3: {
                g0.N(((long)(((Long)object0))));
                return;
            }
            case 4: {
                g0.E(((int)(((Integer)object0))));
                return;
            }
            case 5: {
                g0.L(((long)(((Long)object0))));
                return;
            }
            case 6: {
                g0.K(((int)(((Integer)object0))));
                return;
            }
            case 7: {
                g0.H(((int)((Boolean)object0).booleanValue()));
                return;
            }
            case 8: {
                g0.getClass();
                byte[] arr_b = ((String)object0).getBytes("UTF-8");
                g0.M(arr_b.length);
                g0.J(arr_b);
                return;
            }
            case 9: {
                g0.getClass();
                ((a)object0).d(g0);
                return;
            }
            case 10: {
                g0.G(((a)object0));
                return;
            }
            case 11: {
                if(object0 instanceof d) {
                    g0.getClass();
                    g0.M(((d)object0).size());
                    g0.I(((d)object0));
                    return;
                }
                g0.getClass();
                g0.M(((byte[])object0).length);
                g0.J(((byte[])object0));
                return;
            }
            case 12: {
                g0.M(((int)(((Integer)object0))));
                return;
            }
            case 13: {
                if(object0 instanceof n) {
                    g0.E(((n)object0).a());
                    return;
                }
                g0.E(((int)(((Integer)object0))));
                return;
            }
            case 14: {
                g0.K(((int)(((Integer)object0))));
                return;
            }
            case 15: {
                g0.L(((long)(((Long)object0))));
                return;
            }
            case 16: {
                int v = (int)(((Integer)object0));
                g0.M(v >> 0x1F ^ v << 1);
                return;
            }
            case 17: {
                long v1 = (long)(((Long)object0));
                g0.N(v1 >> 0x3F ^ v1 << 1);
            }
        }
    }
}

