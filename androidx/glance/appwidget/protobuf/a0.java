package androidx.glance.appwidget.protobuf;

import java.util.Arrays;
import java.util.List;

public abstract class a0 {
    public static final Class a;
    public static final d0 b;
    public static final d0 c;

    static {
        Class class1;
        Class class0;
        d0 d00 = null;
        try {
            class0 = null;
            class0 = Class.forName("androidx.glance.appwidget.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
        }
        try {
            a0.a = class0;
            class1 = null;
            class1 = Class.forName("androidx.glance.appwidget.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
        }
        if(class1 != null) {
            try {
                d00 = (d0)class1.getConstructor(null).newInstance(null);
            }
            catch(Throwable unused_ex) {
            }
        }
        a0.b = d00;
        a0.c = new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static int a(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof y) {
            y y0 = (y)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += m.V(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static int b(int v, List list0) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (m.T(v) + 4) * v1;
    }

    public static int c(int v, List list0) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (m.T(v) + 8) * v1;
    }

    public static int d(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof y) {
            y y0 = (y)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += m.V(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static int e(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof I) {
            I i0 = (I)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += m.V(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static int f(List list0) {
        int v = list0.size();
        if(v != 0) {
            if(!(list0 instanceof y)) {
                goto label_7;
            }
            y y0 = (y)list0;
            if(v > 0) {
                throw null;
            label_7:
                int v2 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    int v3 = (int)(((Integer)list0.get(v1)));
                    v2 += m.U(v3 >> 0x1F ^ v3 << 1);
                }
                return v2;
            }
        }
        return 0;
    }

    public static int g(List list0) {
        int v = list0.size();
        if(v != 0) {
            if(!(list0 instanceof I)) {
                goto label_7;
            }
            I i0 = (I)list0;
            if(v > 0) {
                throw null;
            label_7:
                int v2 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    long v3 = (long)(((Long)list0.get(v1)));
                    v2 += m.V(v3 >> 0x3F ^ v3 << 1);
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
        if(list0 instanceof y) {
            y y0 = (y)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += m.U(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static int i(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof I) {
            I i0 = (I)list0;
            if(v > 0) {
                throw null;
            }
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += m.V(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static Object j(Object object0, int v, A a0, Object object1, d0 d00) {
        return object1;
    }

    public static void k(d0 d00, Object object0, Object object1) {
        d00.getClass();
        c0 c00 = ((x)object0).unknownFields;
        c0 c01 = ((x)object1).unknownFields;
        c0 c02 = c0.f;
        if(!c02.equals(c01)) {
            if(c02.equals(c00)) {
                int v = c00.a + c01.a;
                int[] arr_v = Arrays.copyOf(c00.b, v);
                System.arraycopy(c01.b, 0, arr_v, c00.a, c01.a);
                Object[] arr_object = Arrays.copyOf(c00.c, v);
                System.arraycopy(c01.c, 0, arr_object, c00.a, c01.a);
                c00 = new c0(v, arr_v, arr_object, true);
            }
            else {
                c00.getClass();
                if(!c01.equals(c02)) {
                    if(!c00.e) {
                        throw new UnsupportedOperationException();
                    }
                    int v1 = c00.a + c01.a;
                    c00.a(v1);
                    System.arraycopy(c01.b, 0, c00.b, c00.a, c01.a);
                    System.arraycopy(c01.c, 0, c00.c, c00.a, c01.a);
                    c00.a = v1;
                }
            }
        }
        ((x)object0).unknownFields = c00;
    }

    // 去混淆评级： 低(20)
    public static boolean l(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static void m(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof d) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Boolean)list0.get(v2)).getClass();
                    ++v3;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    byte b = (byte)((Boolean)list0.get(v1)).booleanValue();
                    if(m0.q == m0.p) {
                        m0.W();
                    }
                    int v4 = m0.q;
                    m0.q = v4 + 1;
                    m0.o[v4] = b;
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.Z(v, ((Boolean)list0.get(v1)).booleanValue());
                ++v1;
            }
        }
    }

    public static void n(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof n) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Double)list0.get(v2)).getClass();
                    v3 += 8;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.e0(Double.doubleToRawLongBits(((double)(((Double)list0.get(v1))))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                double f = (double)(((Double)list0.get(v1)));
                m0.getClass();
                m0.d0(v, Double.doubleToRawLongBits(f));
                ++v1;
            }
        }
    }

    public static void o(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof y) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += m.V(((int)(((Integer)list0.get(v2)))));
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.g0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.f0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void p(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof y) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Integer)list0.get(v2)).getClass();
                    v3 += 4;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.c0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.b0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void q(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof I) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Long)list0.get(v2)).getClass();
                    v3 += 8;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.e0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.d0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void r(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof t) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Float)list0.get(v2)).getClass();
                    v3 += 4;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.c0(Float.floatToRawIntBits(((float)(((Float)list0.get(v1))))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                float f = (float)(((Float)list0.get(v1)));
                m0.getClass();
                m0.b0(v, Float.floatToRawIntBits(f));
                ++v1;
            }
        }
    }

    public static void s(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof y) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += m.V(((int)(((Integer)list0.get(v2)))));
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.g0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.f0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void t(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof I) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += m.V(((long)(((Long)list0.get(v2)))));
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.n0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.m0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void u(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof y) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Integer)list0.get(v2)).getClass();
                    v3 += 4;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.c0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.b0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void v(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof I) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ((Long)list0.get(v2)).getClass();
                    v3 += 8;
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.e0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.d0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void w(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof y) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    int v4 = (int)(((Integer)list0.get(v2)));
                    v3 += m.U(v4 >> 0x1F ^ v4 << 1);
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    int v5 = (int)(((Integer)list0.get(v1)));
                    m0.l0(v5 >> 0x1F ^ v5 << 1);
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                int v6 = (int)(((Integer)list0.get(v1)));
                m0.k0(v, v6 >> 0x1F ^ v6 << 1);
                ++v1;
            }
        }
    }

    public static void x(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof I) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    long v4 = (long)(((Long)list0.get(v2)));
                    v3 += m.V(v4 >> 0x3F ^ v4 << 1);
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    long v5 = (long)(((Long)list0.get(v1)));
                    m0.n0(v5 >> 0x3F ^ v5 << 1);
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                long v6 = (long)(((Long)list0.get(v1)));
                m0.m0(v, v6 >> 0x3F ^ v6 << 1);
                ++v1;
            }
        }
    }

    public static void y(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof y) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += m.U(((int)(((Integer)list0.get(v2)))));
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.l0(((int)(((Integer)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.k0(v, ((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
        }
    }

    public static void z(int v, List list0, K k0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            int v1 = 0;
            m m0 = (m)k0.a;
            if(list0 instanceof I) {
                throw new ClassCastException();
            }
            if(z) {
                m0.j0(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    v3 += m.V(((long)(((Long)list0.get(v2)))));
                }
                m0.l0(v3);
                while(v1 < list0.size()) {
                    m0.n0(((long)(((Long)list0.get(v1)))));
                    ++v1;
                }
                return;
            }
            while(v1 < list0.size()) {
                m0.m0(v, ((long)(((Long)list0.get(v1)))));
                ++v1;
            }
        }
    }
}

