package i.n.i.b.a.s.e;

import I6.s;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public final class b5 extends AbstractMap implements Serializable {
    public transient int[] a;
    public transient long[] b;
    public transient Object[] c;
    public transient Object[] d;
    public transient float e;
    public transient int f;
    public transient int g;
    public transient int h;
    public transient Z4 i;
    public transient Z4 j;
    public transient s k;
    public static final int l;

    public final int a(Object object0) {
        int v = Ja.L((object0 == null ? 0 : object0.hashCode()));
        for(int v1 = this.a[this.a.length - 1 & v]; v1 != -1; v1 = (int)v2) {
            long v2 = this.b[v1];
            if(((int)(v2 >>> 0x20)) == v && M7.v(object0, this.c[v1])) {
                return v1;
            }
        }
        return -1;
    }

    public static b5 b() {
        b5 b50 = new b5();  // 初始化器: Ljava/util/AbstractMap;-><init>()V
        b50.d(3);
        return b50;
    }

    public final Object c(int v, Object object0) {
        long v8;
        long[] arr_v2;
        int v1 = this.a.length - 1 & v;
        int v2 = this.a[v1];
        if(v2 != -1) {
            int v3 = -1;
            while(true) {
                if(((int)(this.b[v2] >>> 0x20)) == v && M7.v(object0, this.c[v2])) {
                    Object[] arr_object = this.d;
                    Object object1 = arr_object[v2];
                    if(v3 == -1) {
                        this.a[v1] = (int)this.b[v2];
                    }
                    else {
                        this.b[v3] = ((long)(((int)this.b[v2]))) & 0xFFFFFFFFL | this.b[v3] & 0xFFFFFFFF00000000L;
                    }
                    int v4 = this.h - 1;
                    if(v2 < v4) {
                        Object[] arr_object1 = this.c;
                        arr_object1[v2] = arr_object1[v4];
                        arr_object[v2] = arr_object[v4];
                        arr_object1[v4] = null;
                        arr_object[v4] = null;
                        long[] arr_v = this.b;
                        long v5 = arr_v[v4];
                        arr_v[v2] = v5;
                        arr_v[v4] = -1L;
                        int[] arr_v1 = this.a;
                        int v6 = ((int)(v5 >>> 0x20)) & arr_v1.length - 1;
                        int v7 = arr_v1[v6];
                        if(v7 == v4) {
                            arr_v1[v6] = v2;
                        }
                        else {
                            while(true) {
                                arr_v2 = this.b;
                                v8 = arr_v2[v7];
                                if(((int)v8) == v4) {
                                    break;
                                }
                                v7 = (int)v8;
                            }
                            arr_v2[v7] = v8 & 0xFFFFFFFF00000000L | ((long)v2) & 0xFFFFFFFFL;
                        }
                    }
                    else {
                        this.c[v2] = null;
                        arr_object[v2] = null;
                        this.b[v2] = -1L;
                    }
                    --this.h;
                    ++this.f;
                    return object1;
                }
                int v9 = (int)this.b[v2];
                if(v9 == -1) {
                    break;
                }
                v3 = v2;
                v2 = v9;
            }
        }
        return null;
    }

    @Override
    public final void clear() {
        ++this.f;
        Arrays.fill(this.c, 0, this.h, null);
        Arrays.fill(this.d, 0, this.h, null);
        Arrays.fill(this.a, -1);
        Arrays.fill(this.b, -1L);
        this.h = 0;
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.a(object0) != -1;
    }

    @Override
    public final boolean containsValue(Object object0) {
        for(int v = 0; v < this.h; ++v) {
            if(M7.v(object0, this.d[v])) {
                return true;
            }
        }
        return false;
    }

    public final void d(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("Initial capacity must be non-negative");
        }
        int v1 = Math.max(v, 2);
        int v2 = Integer.highestOneBit(v1);
        if(v1 > ((int)(1.0 * ((double)v2)))) {
            v2 <<= 1;
            if(v2 <= 0) {
                v2 = 0x40000000;
            }
        }
        int[] arr_v = new int[v2];
        Arrays.fill(arr_v, -1);
        this.a = arr_v;
        this.e = 1.0f;
        this.c = new Object[v];
        this.d = new Object[v];
        long[] arr_v1 = new long[v];
        Arrays.fill(arr_v1, -1L);
        this.b = arr_v1;
        this.g = Math.max(1, ((int)(((float)v2) * 1.0f)));
    }

    public static void e(b5 b50, int v) {
        b50.c(((int)(b50.b[v] >>> 0x20)), b50.c[v]);
    }

    @Override
    public final Set entrySet() {
        Z4 z40 = this.j;
        if(z40 == null) {
            z40 = new Z4(this, 0);
            this.j = z40;
        }
        return z40;
    }

    public static b5 g() {
        b5 b50 = new b5();  // 初始化器: Ljava/util/AbstractMap;-><init>()V
        b50.d(8);
        return b50;
    }

    @Override
    public final Object get(Object object0) {
        int v = this.a(object0);
        return v == -1 ? null : this.d[v];
    }

    @Override
    public final boolean isEmpty() {
        return this.h == 0;
    }

    @Override
    public final Set keySet() {
        Z4 z40 = this.i;
        if(z40 == null) {
            z40 = new Z4(this, 1);
            this.i = z40;
        }
        return z40;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        long[] arr_v = this.b;
        Object[] arr_object = this.c;
        Object[] arr_object1 = this.d;
        int v1 = Ja.L((object0 == null ? 0 : object0.hashCode()));
        int[] arr_v1 = this.a;
        int v2 = arr_v1.length - 1 & v1;
        int v3 = this.h;
        int v4 = arr_v1[v2];
        if(v4 == -1) {
            arr_v1[v2] = v3;
            goto label_19;
        }
        while(true) {
            long v5 = arr_v[v4];
            if(((int)(v5 >>> 0x20)) == v1 && M7.v(object0, arr_object[v4])) {
                Object object2 = arr_object1[v4];
                arr_object1[v4] = object1;
                return object2;
            }
            if(((int)v5) == -1) {
                arr_v[v4] = 0xFFFFFFFF00000000L & v5 | ((long)v3) & 0xFFFFFFFFL;
            label_19:
                if(v3 == 0x7FFFFFFF) {
                    throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
                }
                int v6 = this.b.length;
                if(v3 + 1 > v6) {
                    int v7 = Math.max(1, v6 >>> 1) + v6 >= 0 ? Math.max(1, v6 >>> 1) + v6 : 0x7FFFFFFF;
                    if(v7 != v6) {
                        this.c = Arrays.copyOf(this.c, v7);
                        this.d = Arrays.copyOf(this.d, v7);
                        int v8 = this.b.length;
                        long[] arr_v2 = Arrays.copyOf(this.b, v7);
                        if(v7 > v8) {
                            Arrays.fill(arr_v2, v8, v7, -1L);
                        }
                        this.b = arr_v2;
                    }
                }
                this.b[v3] = ((long)v1) << 0x20 | 0xFFFFFFFFL;
                this.c[v3] = object0;
                this.d[v3] = object1;
                this.h = v3 + 1;
                if(v3 >= this.g) {
                    int v9 = this.a.length * 2;
                    if(this.a.length >= 0x40000000) {
                        this.g = 0x7FFFFFFF;
                    }
                    else {
                        int v10 = ((int)(((float)v9) * this.e)) + 1;
                        int[] arr_v3 = new int[v9];
                        Arrays.fill(arr_v3, -1);
                        long[] arr_v4 = this.b;
                        for(int v = 0; v < this.h; ++v) {
                            int v11 = (int)(arr_v4[v] >>> 0x20);
                            int v12 = v11 & v9 - 1;
                            int v13 = arr_v3[v12];
                            arr_v3[v12] = v;
                            arr_v4[v] = ((long)v11) << 0x20 | ((long)v13) & 0xFFFFFFFFL;
                        }
                        this.g = v10;
                        this.a = arr_v3;
                    }
                }
                ++this.f;
                return null;
            }
            v4 = (int)v5;
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public final Object remove(Object object0) {
        return object0 == null ? this.c(0, null) : this.c(Ja.L(object0.hashCode()), object0);
    }

    @Override
    public final int size() {
        return this.h;
    }

    @Override
    public final Collection values() {
        s s0 = this.k;
        if(s0 == null) {
            s0 = new s(this, 5);
            this.k = s0;
        }
        return s0;
    }
}

