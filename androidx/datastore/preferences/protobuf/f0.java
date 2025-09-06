package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;

public abstract class f0 {
    public static final Class a;
    public static final m0 b;
    public static final m0 c;

    static {
        Class class1;
        Class class0;
        m0 m00 = null;
        try {
            class0 = null;
            class0 = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
        }
        try {
            f0.a = class0;
            class1 = null;
            class1 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
        }
        if(class1 != null) {
            try {
                m00 = (m0)class1.getConstructor(null).newInstance(null);
            }
            catch(Throwable unused_ex) {
            }
        }
        f0.b = m00;
        f0.c = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static int a(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof B) {
            B b0 = (B)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += o.q0(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static int b(int v, List list0) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (o.o0(v) + 4) * v1;
    }

    public static int c(int v, List list0) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (o.o0(v) + 8) * v1;
    }

    public static int d(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof B) {
            B b0 = (B)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += o.q0(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static int e(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof K) {
            K k0 = (K)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += o.q0(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static int f(List list0) {
        int v = list0.size();
        if(v != 0) {
            if(!(list0 instanceof B)) {
                goto label_7;
            }
            B b0 = (B)list0;
            if(v > 0) {
                throw null;
            label_7:
                int v2 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    int v3 = (int)(((Integer)list0.get(v1)));
                    v2 += o.p0(v3 >> 0x1F ^ v3 << 1);
                }
                return v2;
            }
        }
        return 0;
    }

    public static int g(List list0) {
        int v = list0.size();
        if(v != 0) {
            if(!(list0 instanceof K)) {
                goto label_7;
            }
            K k0 = (K)list0;
            if(v > 0) {
                throw null;
            label_7:
                int v2 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    long v3 = (long)(((Long)list0.get(v1)));
                    v2 += o.q0(v3 >> 0x3F ^ v3 << 1);
                }
                return v2;
            }
        }
        return 0;
    }

    public static int h(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof B) {
            B b0 = (B)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += o.p0(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static int i(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof K) {
            K k0 = (K)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += o.q0(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static Object j(Object object0, int v, C c0, Object object1, m0 m00) {
        return object1;
    }

    public static void k(m0 m00, Object object0, Object object1) {
        m00.getClass();
        l0 l00 = ((A)object0).unknownFields;
        l0 l01 = ((A)object1).unknownFields;
        l0 l02 = l0.f;
        if(!l02.equals(l01)) {
            if(l02.equals(l00)) {
                int v = l00.a + l01.a;
                int[] arr_v = Arrays.copyOf(l00.b, v);
                System.arraycopy(l01.b, 0, arr_v, l00.a, l01.a);
                Object[] arr_object = Arrays.copyOf(l00.c, v);
                System.arraycopy(l01.c, 0, arr_object, l00.a, l01.a);
                l00 = new l0(v, arr_v, arr_object, true);
            }
            else {
                l00.getClass();
                if(!l01.equals(l02)) {
                    if(!l00.e) {
                        throw new UnsupportedOperationException();
                    }
                    int v1 = l00.a + l01.a;
                    l00.a(v1);
                    System.arraycopy(l01.b, 0, l00.b, l00.a, l01.a);
                    System.arraycopy(l01.c, 0, l00.c, l00.a, l01.a);
                    l00.a = v1;
                }
            }
        }
        ((A)object0).unknownFields = l00;
    }

    // 去混淆评级： 低(20)
    public static boolean l(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static void m(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof d) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Boolean)list0.get(v2)).getClass();
                    ++v3;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.t0(((byte)((Boolean)list0.get(v1)).booleanValue()));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.v0(v, ((Boolean)list0.get(v1)).booleanValue());
                ++v1;
            }
        }
    }

    public static void n(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof p) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Double)list0.get(v2)).getClass();
                    v3 += 8;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.B0(Double.doubleToRawLongBits(((double)(((Double)list0.get(v1))))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                double f = (double)(((Double)list0.get(v1)));
                o0.getClass();
                o0.A0(v, Double.doubleToRawLongBits(f));
                ++v1;
            }
        }
    }

    public static void o(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof B) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += o.q0(((int)(((Integer)list0.get(v2)))));
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.D0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.C0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void p(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof B) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Integer)list0.get(v2)).getClass();
                    v3 += 4;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.z0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.y0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void q(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof K) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Long)list0.get(v2)).getClass();
                    v3 += 8;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.B0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.A0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void r(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof w) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Float)list0.get(v2)).getClass();
                    v3 += 4;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.z0(Float.floatToRawIntBits(((float)(((Float)list0.get(v1))))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                float f = (float)(((Float)list0.get(v1)));
                o0.getClass();
                o0.y0(v, Float.floatToRawIntBits(f));
                ++v1;
            }
        }
    }

    public static void s(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof B) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += o.q0(((int)(((Integer)list0.get(v2)))));
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.D0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.C0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void t(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof K) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += o.q0(((long)(((Long)list0.get(v2)))));
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.L0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.K0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void u(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof B) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Integer)list0.get(v2)).getClass();
                    v3 += 4;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.z0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.y0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void v(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof K) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Long)list0.get(v2)).getClass();
                    v3 += 8;
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.B0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.A0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void w(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof B) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    int v4 = (int)(((Integer)list0.get(v2)));
                    v3 += o.p0(v4 >> 0x1F ^ v4 << 1);
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    int v5 = (int)(((Integer)list0.get(v1)));
                    o0.J0(v5 >> 0x1F ^ v5 << 1);
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                int v6 = (int)(((Integer)list0.get(v1)));
                o0.I0(v, v6 >> 0x1F ^ v6 << 1);
                ++v1;
            }
        }
    }

    public static void x(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof K) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    long v4 = (long)(((Long)list0.get(v2)));
                    v3 += o.q0(v4 >> 0x3F ^ v4 << 1);
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    long v5 = (long)(((Long)list0.get(v1)));
                    o0.L0(v5 >> 0x3F ^ v5 << 1);
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                long v6 = (long)(((Long)list0.get(v1)));
                o0.K0(v, v6 >> 0x3F ^ v6 << 1);
                ++v1;
            }
        }
    }

    public static void y(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof B) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += o.p0(((int)(((Integer)list0.get(v2)))));
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.J0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.I0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void z(int v, List list0, M m0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            o o0 = (o)m0.a;
            if(list0 instanceof K) {
                throw new ClassCastException();
            }
            if(z) {
                o0.H0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += o.q0(((long)(((Long)list0.get(v2)))));
                }
                o0.J0(v3);
                while(v1 < list0.size()) {
                    o0.L0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                o0.K0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }
}

