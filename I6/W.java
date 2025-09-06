package I6;

import H6.e;
import H6.g;
import H6.h;
import b3.Z;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import y5.a;

public abstract class w {
    public final int a;

    public w() {
        this.a = 2;
        super();
    }

    public static void a(int v, Object[] arr_object) {
        for(int v1 = 0; v1 < v; ++v1) {
            if(arr_object[v1] == null) {
                throw new NullPointerException("at index " + v1);
            }
        }
    }

    public static void b(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException("null key in entry: null=" + object1);
        }
        if(object1 == null) {
            throw new NullPointerException("null value in entry: " + object0 + "=null");
        }
    }

    public static void c(int v, String s) {
        if(v < 0) {
            throw new IllegalArgumentException(s + " cannot be negative but was: " + v);
        }
    }

    public static Object d(int v) {
        if(v < 2 || v > 0x40000000 || Integer.highestOneBit(v) != v) {
            throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + v);
        }
        if(v <= 0x100) {
            return new byte[v];
        }
        return v <= 0x10000 ? new short[v] : new int[v];
    }

    public abstract Object e();

    public static boolean g(Object object0, Map map0) {
        if(map0 == object0) {
            return true;
        }
        return object0 instanceof Map ? map0.entrySet().equals(((Map)object0).entrySet()) : false;
    }

    public static boolean h(Set set0, Object object0) {
        if(set0 != object0) {
            if(!(object0 instanceof Set)) {
                return false;
            }
            Set set1 = (Set)object0;
            try {
                if(set0.size() != set1.size() || !set0.containsAll(set1)) {
                    return false;
                }
            }
            catch(NullPointerException | ClassCastException unused_ex) {
                return false;
            }
        }
        return true;
    }

    public static B0 i(Set set0, g g0) {
        if(set0 instanceof SortedSet) {
            if(((SortedSet)set0) instanceof B0) {
                ((B0)(((SortedSet)set0))).b.getClass();
                h h0 = new h(Arrays.asList(new g[]{((B0)(((SortedSet)set0))).b, g0}));
                return new C0(((SortedSet)((B0)(((SortedSet)set0))).a), h0);  // 初始化器: LI6/B0;-><init>(Ljava/util/Set;LH6/g;)V
            }
            ((SortedSet)set0).getClass();
            return new C0(((SortedSet)set0), g0);  // 初始化器: LI6/B0;-><init>(Ljava/util/Set;LH6/g;)V
        }
        if(set0 instanceof B0) {
            ((B0)set0).b.getClass();
            h h1 = new h(Arrays.asList(new g[]{((B0)set0).b, g0}));
            return new B0(((B0)set0).a, h1);
        }
        set0.getClass();
        return new B0(set0, g0);
    }

    public static Object j(Iterable iterable0) {
        Object object0;
        if(iterable0 instanceof List) {
            if(((List)iterable0).isEmpty()) {
                throw new NoSuchElementException();
            }
            return Z.h(1, ((List)iterable0));
        }
        Iterator iterator0 = iterable0.iterator();
        do {
            object0 = iterator0.next();
        }
        while(iterator0.hasNext());
        return object0;
    }

    public static int k(Set set0) {
        int v = 0;
        for(Object object0: set0) {
            v += (object0 == null ? 0 : object0.hashCode());
        }
        return v;
    }

    public static z0 l(Set set0, b0 b00) {
        a.o(set0, "set1");
        a.o(b00, "set2");
        return new z0(set0, b00, 1);
    }

    public static int m(int v, int v1, int v2) [...] // Inlined contents

    public static int n(int v) {
        return v >= 0x20 ? (v + 1) * 2 : (v + 1) * 4;
    }

    public static int o(Object object0, Object object1, int v, Object object2, int[] arr_v, Object[] arr_object, Object[] arr_object1) {
        int v1 = w.s(object0);
        int v2 = v1 & v;
        int v3 = w.t(v2, object2);
        if(v3 != 0) {
            int v4 = -1;
            while(true) {
                int v5 = arr_v[v3 - 1];
                if((v5 & ~v) == (v1 & ~v) && x1.a.w(object0, arr_object[v3 - 1]) && (arr_object1 == null || x1.a.w(object1, arr_object1[v3 - 1]))) {
                    int v6 = v5 & v;
                    if(v4 == -1) {
                        w.u(v2, v6, object2);
                        return v3 - 1;
                    }
                    arr_v[v4] = w.m(arr_v[v4], v6, v);
                    return v3 - 1;
                }
                int v7 = v5 & v;
                if(v7 == 0) {
                    break;
                }
                v4 = v3 - 1;
                v3 = v7;
            }
        }
        return -1;
    }

    public static boolean p(Set set0, Collection collection0) {
        collection0.getClass();
        if(collection0 instanceof l0) {
            collection0 = ((l0)collection0).F();
        }
        boolean z = false;
        if(collection0 instanceof Set && collection0.size() > set0.size()) {
            Iterator iterator0 = set0.iterator();
            collection0.getClass();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(collection0.contains(object0)) {
                    iterator0.remove();
                    z = true;
                }
            }
            return z;
        }
        for(Object object1: collection0) {
            z |= set0.remove(object1);
        }
        return z;
    }

    public static void q(List list0, g g0, int v, int v1) {
        for(int v2 = list0.size() - 1; v2 > v1; --v2) {
            if(g0.apply(list0.get(v2))) {
                list0.remove(v2);
            }
        }
        for(int v3 = v1 - 1; v3 >= v; --v3) {
            list0.remove(v3);
        }
    }

    public static int r(int v) [...] // 潜在的解密器

    // 去混淆评级： 低(30)
    public static int s(Object object0) {
        return object0 == null ? 0 : w.r(object0.hashCode());
    }

    public static int t(int v, Object object0) {
        if(object0 instanceof byte[]) {
            return ((byte[])object0)[v] & 0xFF;
        }
        return object0 instanceof short[] ? ((short[])object0)[v] & 0xFFFF : ((int[])object0)[v];
    }

    @Override
    public String toString() {
        return this.a == 2 ? this.e().toString() : super.toString();
    }

    public static void u(int v, int v1, Object object0) {
        if(object0 instanceof byte[]) {
            ((byte[])object0)[v] = (byte)v1;
            return;
        }
        if(object0 instanceof short[]) {
            ((short[])object0)[v] = (short)v1;
            return;
        }
        ((int[])object0)[v] = v1;
    }

    public static int v(int v) {
        int v1 = Math.max(v + 1, 2);
        int v2 = Integer.highestOneBit(v1);
        if(v1 > ((int)(1.0 * ((double)v2)))) {
            v2 <<= 1;
            if(v2 <= 0) {
                v2 = 0x40000000;
            }
        }
        return Math.max(4, v2);
    }

    public static AbstractList w(e e0, List list0) {
        return list0 != null ? new g0(e0, list0) : new h0(e0, null);
    }
}

