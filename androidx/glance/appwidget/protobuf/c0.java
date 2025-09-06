package androidx.glance.appwidget.protobuf;

import java.util.Arrays;

public final class c0 {
    public int a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;
    public static final c0 f;

    static {
        c0.f = new c0(0, new int[0], new Object[0], false);
    }

    public c0(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.d = -1;
        this.a = v;
        this.b = arr_v;
        this.c = arr_object;
        this.e = z;
    }

    public final void a(int v) {
        int[] arr_v = this.b;
        if(v > arr_v.length) {
            int v1 = this.a / 2 + this.a;
            if(v1 >= v) {
                v = v1;
            }
            if(v < 8) {
                v = 8;
            }
            this.b = Arrays.copyOf(arr_v, v);
            this.c = Arrays.copyOf(this.c, v);
        }
    }

    public final int b() {
        int v = this.d;
        if(v != -1) {
            return v;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < this.a; ++v1) {
            int v3 = this.b[v1];
            int v4 = v3 >>> 3;
            switch(v3 & 7) {
                case 0: {
                    v2 = m.V(((long)(((Long)this.c[v1])))) + m.T(v4) + v2;
                    break;
                }
                case 1: {
                    ((Long)this.c[v1]).getClass();
                    v2 = m.T(v4) + 8 + v2;
                    break;
                }
                case 2: {
                    v2 = m.Q(v4, ((i)this.c[v1])) + v2;
                    break;
                }
                case 3: {
                    v2 = ((c0)this.c[v1]).b() + m.T(v4) * 2 + v2;
                    break;
                }
                case 5: {
                    ((Integer)this.c[v1]).getClass();
                    v2 = m.T(v4) + 4 + v2;
                    break;
                }
                default: {
                    throw new IllegalStateException(D.b());
                }
            }
        }
        this.d = v2;
        return v2;
    }

    public final void c(int v, Object object0) {
        if(!this.e) {
            throw new UnsupportedOperationException();
        }
        this.a(this.a + 1);
        int v1 = this.a;
        this.b[v1] = v;
        this.c[v1] = object0;
        this.a = v1 + 1;
    }

    public final void d(K k0) {
        if(this.a != 0) {
            k0.getClass();
            m m0 = (m)k0.a;
            for(int v = 0; v < this.a; ++v) {
                int v1 = this.b[v];
                Object object0 = this.c[v];
                int v2 = v1 >>> 3;
                switch(v1 & 7) {
                    case 0: {
                        m0.m0(v2, ((long)(((Long)object0))));
                        break;
                    }
                    case 1: {
                        m0.d0(v2, ((long)(((Long)object0))));
                        break;
                    }
                    case 2: {
                        m0.a0(v2, ((i)object0));
                        break;
                    }
                    case 3: {
                        m0.j0(v2, 3);
                        ((c0)object0).d(k0);
                        m0.j0(v2, 4);
                        break;
                    }
                    case 5: {
                        m0.b0(v2, ((int)(((Integer)object0))));
                        break;
                    }
                    default: {
                        throw new RuntimeException(D.b());
                    }
                }
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c0)) {
            return false;
        }
        int v = this.a;
        if(v == ((c0)object0).a) {
            int[] arr_v = this.b;
            int[] arr_v1 = ((c0)object0).b;
            for(int v1 = 0; v1 < v; ++v1) {
                if(arr_v[v1] != arr_v1[v1]) {
                    return false;
                }
            }
            Object[] arr_object = this.c;
            Object[] arr_object1 = ((c0)object0).c;
            int v2 = this.a;
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!arr_object[v3].equals(arr_object1[v3])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.a;
        int[] arr_v = this.b;
        int v1 = 17;
        int v3 = 17;
        for(int v4 = 0; v4 < v; ++v4) {
            v3 = v3 * 0x1F + arr_v[v4];
        }
        Object[] arr_object = this.c;
        int v5 = this.a;
        for(int v2 = 0; v2 < v5; ++v2) {
            v1 = v1 * 0x1F + arr_object[v2].hashCode();
        }
        return ((v + 0x20F) * 0x1F + v3) * 0x1F + v1;
    }
}

