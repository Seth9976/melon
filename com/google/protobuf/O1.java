package com.google.protobuf;

import androidx.datastore.preferences.protobuf.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class o1 {
    public final G2 a;
    public boolean b;
    public static final o1 c;

    static {
        o1.c = new o1(0);
    }

    public o1() {
        this.a = G2.g();
    }

    public o1(int v) {
        G2 g20 = G2.g();
        super();
        this.a = g20;
        this.l();
        this.l();
    }

    public final void a(x1 x10, Object object0) {
        List list0;
        if(!x10.c) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        o1.p(x10, object0);
        G2 g20 = this.a;
        Object object1 = g20.get(x10);
        if(object1 == null) {
            list0 = new ArrayList();
            g20.h(x10, list0);
        }
        else {
            list0 = (List)object1;
        }
        list0.add(object0);
    }

    public final o1 b() {
        o1 o10 = new o1();
        G2 g20 = this.a;
        int v = g20.b;
        for(int v1 = 0; v1 < v; ++v1) {
            H2 h20 = g20.c(v1);
            o10.o(((x1)h20.a), h20.b);
        }
        for(Object object0: g20.d()) {
            o10.o(((x1)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        return o10;
    }

    public static int c(j3 j30, int v, Object object0) {
        return o1.d(j30, object0) + (j30 == j3.e ? x.O(v) * 2 : x.O(v));
    }

    @Override
    public final Object clone() {
        return this.b();
    }

    public static int d(j3 j30, Object object0) {
        switch(j30.ordinal()) {
            case 0: {
                ((Double)object0).getClass();
                return 8;
            }
            case 1: {
                ((Float)object0).getClass();
                return 4;
            }
            case 2: {
                return x.Q(((long)(((Long)object0))));
            }
            case 3: {
                return x.Q(((long)(((Long)object0))));
            }
            case 4: {
                return x.Q(((int)(((Integer)object0))));
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
                return object0 instanceof o ? x.K(((o)object0)) : x.N(((String)object0));
            }
            case 9: {
                return ((l2)object0).getSerializedSize();
            }
            case 10: {
                int v = ((l2)object0).getSerializedSize();
                return x.P(v) + v;
            }
            case 11: {
                return object0 instanceof o ? x.K(((o)object0)) : x.P(((byte[])object0).length) + ((byte[])object0).length;
            }
            case 12: {
                return x.P(((int)(((Integer)object0))));
            }
            case 13: {
                return object0 instanceof G1 ? x.Q(((G1)object0).a()) : x.Q(((int)(((Integer)object0))));
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
                return x.L(((int)(((Integer)object0))));
            }
            case 17: {
                return x.M(((long)(((Long)object0))));
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    public static int e(x1 x10, Object object0) {
        j3 j30 = x10.b;
        int v = x10.a;
        if(x10.c) {
            int v1 = ((List)object0).size();
            int v2 = 0;
            if(x10.d) {
                if(((List)object0).isEmpty()) {
                    return 0;
                }
                int v3 = 0;
                while(v2 < v1) {
                    v3 += o1.d(j30, ((List)object0).get(v2));
                    ++v2;
                }
                return x.P(v3) + (x.O(v) + v3);
            }
            int v4 = 0;
            while(v2 < v1) {
                v4 += o1.c(j30, v, ((List)object0).get(v2));
                ++v2;
            }
            return v4;
        }
        return o1.c(j30, v, object0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof o1 ? this.a.equals(((o1)object0).a) : false;
    }

    public final int f() {
        G2 g20 = this.a;
        int v = g20.b;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += o1.g(g20.c(v1));
        }
        for(Object object0: g20.d()) {
            v2 += o1.g(((Map.Entry)object0));
        }
        return v2;
    }

    public static int g(Map.Entry map$Entry0) {
        x1 x10 = (x1)map$Entry0.getKey();
        Object object0 = map$Entry0.getValue();
        if(x10.b.a == k3.j && !x10.c && !x10.d) {
            int v = x.P(((x1)map$Entry0.getKey()).a);
            int v1 = ((l2)object0).getSerializedSize();
            return x.P(v1) + v + v1 + 4;
        }
        return o1.e(x10, object0);
    }

    public final int h() {
        G2 g20 = this.a;
        int v = g20.b;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            H2 h20 = g20.c(v1);
            v2 += o1.e(((x1)h20.a), h20.b);
        }
        for(Object object0: g20.d()) {
            v2 += o1.e(((x1)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        return v2;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean i() {
        G2 g20 = this.a;
        int v = g20.b;
        for(int v1 = 0; v1 < v; ++v1) {
            if(!o1.j(g20.c(v1))) {
                return false;
            }
        }
        for(Object object0: g20.d()) {
            if(o1.j(((Map.Entry)object0))) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean j(Map.Entry map$Entry0) {
        x1 x10 = (x1)map$Entry0.getKey();
        if(x10.b.a == k3.j) {
            if(x10.c) {
                List list0 = (List)map$Entry0.getValue();
                int v = list0.size();
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= v) {
                        return true;
                    }
                    Object object0 = list0.get(v1);
                    if(!(object0 instanceof m2)) {
                        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    }
                    if(!((m2)object0).isInitialized()) {
                        return false;
                    }
                }
            }
            Object object1 = map$Entry0.getValue();
            if(!(object1 instanceof m2)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            return ((m2)object1).isInitialized();
        }
        return true;
    }

    // 去混淆评级： 低(20)
    public final Iterator k() {
        return this.a.isEmpty() ? Collections.emptyIterator() : ((j0)this.a.entrySet()).iterator();
    }

    public final void l() {
        if(this.b) {
            return;
        }
        G2 g20 = this.a;
        int v = g20.b;
        for(int v2 = 0; v2 < v; ++v2) {
            Object object0 = g20.c(v2).b;
            if(object0 instanceof A1) {
                ((A1)object0).makeImmutable();
            }
        }
        for(Object object1: g20.d()) {
            Object object2 = ((Map.Entry)object1).getValue();
            if(object2 instanceof A1) {
                ((A1)object2).makeImmutable();
            }
        }
        if(!g20.d) {
            for(int v1 = 0; v1 < g20.b; ++v1) {
                H2 h20 = g20.c(v1);
                if(((x1)h20.a).c) {
                    h20.setValue(Collections.unmodifiableList(((List)h20.b)));
                }
            }
            for(Object object3: g20.d()) {
                Map.Entry map$Entry0 = (Map.Entry)object3;
                if(((x1)map$Entry0.getKey()).c) {
                    map$Entry0.setValue(Collections.unmodifiableList(((List)map$Entry0.getValue())));
                }
            }
        }
        if(!g20.d) {
            g20.c = g20.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(g20.c);
            g20.f = g20.f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(g20.f);
            g20.d = true;
        }
        this.b = true;
    }

    public final void m(o1 o10) {
        G2 g20 = o10.a;
        int v = g20.b;
        for(int v1 = 0; v1 < v; ++v1) {
            this.n(g20.c(v1));
        }
        for(Object object0: g20.d()) {
            this.n(((Map.Entry)object0));
        }
    }

    public final void n(Map.Entry map$Entry0) {
        x1 x10 = (x1)map$Entry0.getKey();
        byte[] arr_b = map$Entry0.getValue();
        G2 g20 = this.a;
        if(x10.c) {
            ArrayList arrayList0 = g20.get(x10);
            int v = ((List)arr_b).size();
            if(arrayList0 == null) {
                arrayList0 = new ArrayList(v);
            }
            for(int v1 = 0; v1 < v; ++v1) {
                byte[] arr_b1 = ((List)arr_b).get(v1);
                if(arr_b1 instanceof byte[]) {
                    byte[] arr_b2 = new byte[arr_b1.length];
                    System.arraycopy(arr_b1, 0, arr_b2, 0, arr_b1.length);
                    arr_b1 = arr_b2;
                }
                arrayList0.add(arr_b1);
            }
            g20.h(x10, arrayList0);
            return;
        }
        if(x10.b.a == k3.j) {
            Object object0 = g20.get(x10);
            if(object0 == null) {
                if(arr_b instanceof byte[]) {
                    byte[] arr_b3 = new byte[arr_b.length];
                    System.arraycopy(arr_b, 0, arr_b3, 0, arr_b.length);
                    arr_b = arr_b3;
                }
                g20.h(x10, arr_b);
                return;
            }
            k2 k20 = ((l2)object0).toBuilder();
            ((t1)k20).f(((A1)(((l2)arr_b))));
            g20.h(x10, ((t1)k20).a());
            return;
        }
        if(arr_b instanceof byte[]) {
            byte[] arr_b4 = new byte[arr_b.length];
            System.arraycopy(arr_b, 0, arr_b4, 0, arr_b.length);
            arr_b = arr_b4;
        }
        g20.h(x10, arr_b);
    }

    public final void o(x1 x10, Object object0) {
        if(x10.c) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list0 = (List)object0;
            int v = list0.size();
            ArrayList arrayList0 = new ArrayList(v);
            for(int v1 = 0; v1 < v; ++v1) {
                Object object1 = list0.get(v1);
                o1.p(x10, object1);
                arrayList0.add(object1);
            }
            object0 = arrayList0;
        }
        else {
            o1.p(x10, object0);
        }
        this.a.h(x10, object0);
    }

    public static void p(x1 x10, Object object0) {
        object0.getClass();
        boolean z = true;
        switch(x10.b.a.ordinal()) {
            case 0: {
                z = object0 instanceof Integer;
                break;
            }
            case 1: {
                z = object0 instanceof Long;
                break;
            }
            case 2: {
                z = object0 instanceof Float;
                break;
            }
            case 3: {
                z = object0 instanceof Double;
                break;
            }
            case 4: {
                z = object0 instanceof Boolean;
                break;
            }
            case 5: {
                z = object0 instanceof String;
                break;
            }
            case 6: {
                if(!(object0 instanceof o) && !(object0 instanceof byte[])) {
                    z = false;
                }
                break;
            }
            case 7: {
                if(!(object0 instanceof Integer) && !(object0 instanceof G1)) {
                    z = false;
                }
                break;
            }
            case 8: {
                if(!(object0 instanceof l2)) {
                    z = false;
                }
                break;
            }
            default: {
                z = false;
            }
        }
        if(z) {
            return;
        }
        String s = object0.getClass().getName();
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", x10.a, x10.b.a, s));
    }

    public static void q(x x0, j3 j30, int v, Object object0) {
        if(j30 == j3.e) {
            x0.j0(v, 3);
            ((l2)object0).writeTo(x0);
            x0.j0(v, 4);
            return;
        }
        x0.j0(v, j30.b);
        switch(j30.ordinal()) {
            case 0: {
                x0.a0(Double.doubleToRawLongBits(((double)(((Double)object0)))));
                return;
            }
            case 1: {
                x0.Y(Float.floatToRawIntBits(((float)(((Float)object0)))));
                return;
            }
            case 2: {
                x0.n0(((long)(((Long)object0))));
                return;
            }
            case 3: {
                x0.n0(((long)(((Long)object0))));
                return;
            }
            case 4: {
                x0.c0(((int)(((Integer)object0))));
                return;
            }
            case 5: {
                x0.a0(((long)(((Long)object0))));
                return;
            }
            case 6: {
                x0.Y(((int)(((Integer)object0))));
                return;
            }
            case 7: {
                x0.S(((byte)((Boolean)object0).booleanValue()));
                return;
            }
            case 8: {
                if(object0 instanceof o) {
                    x0.W(((o)object0));
                    return;
                }
                x0.i0(((String)object0));
                return;
            }
            case 9: {
                ((l2)object0).writeTo(x0);
                return;
            }
            case 10: {
                x0.e0(((l2)object0));
                return;
            }
            case 11: {
                if(object0 instanceof o) {
                    x0.W(((o)object0));
                    return;
                }
                x0.U(((byte[])object0).length, ((byte[])object0));
                return;
            }
            case 12: {
                x0.l0(((int)(((Integer)object0))));
                return;
            }
            case 13: {
                if(object0 instanceof G1) {
                    x0.c0(((G1)object0).a());
                    return;
                }
                x0.c0(((int)(((Integer)object0))));
                return;
            }
            case 14: {
                x0.Y(((int)(((Integer)object0))));
                return;
            }
            case 15: {
                x0.a0(((long)(((Long)object0))));
                return;
            }
            case 16: {
                int v1 = (int)(((Integer)object0));
                x0.l0(v1 >> 0x1F ^ v1 << 1);
                return;
            }
            case 17: {
                long v2 = (long)(((Long)object0));
                x0.n0(v2 >> 0x3F ^ v2 << 1);
            }
        }
    }
}

