package I6;

import B7.b;
import java.util.Arrays;
import java.util.Objects;
import y5.a;

public final class u0 extends Y {
    public final transient Object d;
    public final transient Object[] e;
    public final transient int f;
    public static final u0 g;
    private static final long serialVersionUID;

    static {
        u0.g = new u0(null, new Object[0], 0);
    }

    public u0(Object object0, Object[] arr_object, int v) {
        this.d = object0;
        this.e = arr_object;
        this.f = v;
    }

    @Override  // I6.Y
    public final r0 b() {
        return new r0(this, this.e, 0, this.f);
    }

    @Override  // I6.Y
    public final s0 c() {
        return new s0(this, new t0(this.e, 0, this.f));
    }

    @Override  // I6.Y
    public final O d() {
        return new t0(this.e, 1, this.f);
    }

    public static u0 g(int v, Object[] arr_object, b b0) {
        if(v == 0) {
            return u0.g;
        }
        if(v == 1) {
            Objects.requireNonNull(arr_object[0]);
            Objects.requireNonNull(arr_object[1]);
            return new u0(null, arr_object, 1);
        }
        a.p(v, arr_object.length >> 1);
        Object object0 = u0.h(arr_object, v, b0.l(v), 0);
        if(object0 instanceof Object[]) {
            W w0 = (W)((Object[])object0)[2];
            if(b0 == null) {
                throw w0.a();
            }
            b0.c = w0;
            Object object1 = ((Object[])object0)[0];
            int v1 = (int)(((Integer)((Object[])object0)[1]));
            return new u0(object1, Arrays.copyOf(arr_object, v1 * 2), v1);
        }
        return new u0(object0, arr_object, v);
    }

    @Override  // I6.Y
    public final Object get(Object object0) {
        Object object1 = u0.i(this.d, this.e, this.f, 0, object0);
        return object1 == null ? null : object1;
    }

    public static Object h(Object[] arr_object, int v, int v1, int v2) {
        int v3 = 0;
        W w0 = null;
        if(v == 1) {
            Objects.requireNonNull(arr_object[v2]);
            Objects.requireNonNull(arr_object[v2 ^ 1]);
            return null;
        }
        if(v1 <= 0x80) {
            byte[] arr_b = new byte[v1];
            Arrays.fill(arr_b, -1);
            int v4 = 0;
            while(v3 < v) {
                int v5 = v3 * 2 + v2;
                int v6 = v4 * 2 + v2;
                Object object0 = arr_object[v5];
                Objects.requireNonNull(object0);
                Object object1 = arr_object[v5 ^ 1];
                Objects.requireNonNull(object1);
                for(int v7 = w.r(object0.hashCode()); true; v7 = v8 + 1) {
                    int v8 = v7 & v1 - 1;
                    int v9 = arr_b[v8] & 0xFF;
                    if(v9 == 0xFF) {
                        arr_b[v8] = (byte)v6;
                        if(v4 < v3) {
                            arr_object[v6] = object0;
                            arr_object[v6 ^ 1] = object1;
                        }
                        ++v4;
                        break;
                    }
                    if(object0.equals(arr_object[v9])) {
                        Object object2 = arr_object[v9 ^ 1];
                        Objects.requireNonNull(object2);
                        w0 = new W(object0, object1, object2);
                        arr_object[v9 ^ 1] = object1;
                        break;
                    }
                }
                ++v3;
            }
            return v4 == v ? arr_b : new Object[]{arr_b, v4, w0};
        }
        if(v1 <= 0x8000) {
            short[] arr_v = new short[v1];
            Arrays.fill(arr_v, -1);
            int v10 = 0;
            while(v3 < v) {
                int v11 = v3 * 2 + v2;
                int v12 = v10 * 2 + v2;
                Object object3 = arr_object[v11];
                Objects.requireNonNull(object3);
                Object object4 = arr_object[v11 ^ 1];
                Objects.requireNonNull(object4);
                for(int v13 = w.r(object3.hashCode()); true; v13 = v14 + 1) {
                    int v14 = v13 & v1 - 1;
                    int v15 = arr_v[v14] & 0xFFFF;
                    if(v15 == 0xFFFF) {
                        arr_v[v14] = (short)v12;
                        if(v10 < v3) {
                            arr_object[v12] = object3;
                            arr_object[v12 ^ 1] = object4;
                        }
                        ++v10;
                        break;
                    }
                    if(object3.equals(arr_object[v15])) {
                        Object object5 = arr_object[v15 ^ 1];
                        Objects.requireNonNull(object5);
                        w0 = new W(object3, object4, object5);
                        arr_object[v15 ^ 1] = object4;
                        break;
                    }
                }
                ++v3;
            }
            return v10 == v ? arr_v : new Object[]{arr_v, v10, w0};
        }
        int[] arr_v1 = new int[v1];
        Arrays.fill(arr_v1, -1);
        int v16 = 0;
        while(v3 < v) {
            int v17 = v3 * 2 + v2;
            int v18 = v16 * 2 + v2;
            Object object6 = arr_object[v17];
            Objects.requireNonNull(object6);
            Object object7 = arr_object[v17 ^ 1];
            Objects.requireNonNull(object7);
            for(int v19 = w.r(object6.hashCode()); true; v19 = v20 + 1) {
                int v20 = v19 & v1 - 1;
                int v21 = arr_v1[v20];
                if(v21 == -1) {
                    arr_v1[v20] = v18;
                    if(v16 < v3) {
                        arr_object[v18] = object6;
                        arr_object[v18 ^ 1] = object7;
                    }
                    ++v16;
                    break;
                }
                if(object6.equals(arr_object[v21])) {
                    Object object8 = arr_object[v21 ^ 1];
                    Objects.requireNonNull(object8);
                    w0 = new W(object6, object7, object8);
                    arr_object[v21 ^ 1] = object7;
                    break;
                }
            }
            ++v3;
        }
        return v16 == v ? arr_v1 : new Object[]{arr_v1, v16, w0};
    }

    public static Object i(Object object0, Object[] arr_object, int v, int v1, Object object1) {
        if(object1 != null) {
            if(v == 1) {
                Object object2 = arr_object[v1];
                Objects.requireNonNull(object2);
                if(object2.equals(object1)) {
                    Object object3 = arr_object[v1 ^ 1];
                    Objects.requireNonNull(object3);
                    return object3;
                }
            }
            else if(object0 != null) {
                if(object0 instanceof byte[]) {
                    int v2 = ((byte[])object0).length - 1;
                    for(int v3 = w.r(object1.hashCode()); true; v3 = v4 + 1) {
                        int v4 = v3 & v2;
                        int v5 = ((byte[])object0)[v4] & 0xFF;
                        if(v5 == 0xFF) {
                            break;
                        }
                        if(object1.equals(arr_object[v5])) {
                            return arr_object[v5 ^ 1];
                        }
                    }
                }
                else if(object0 instanceof short[]) {
                    int v6 = ((short[])object0).length - 1;
                    for(int v7 = w.r(object1.hashCode()); true; v7 = v8 + 1) {
                        int v8 = v7 & v6;
                        int v9 = ((short[])object0)[v8] & 0xFFFF;
                        if(v9 == 0xFFFF) {
                            break;
                        }
                        if(object1.equals(arr_object[v9])) {
                            return arr_object[v9 ^ 1];
                        }
                    }
                }
                else {
                    int v10 = ((int[])object0).length - 1;
                    for(int v11 = w.r(object1.hashCode()); true; v11 = v12 + 1) {
                        int v12 = v11 & v10;
                        int v13 = ((int[])object0)[v12];
                        if(v13 == -1) {
                            break;
                        }
                        if(object1.equals(arr_object[v13])) {
                            return arr_object[v13 ^ 1];
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public final int size() {
        return this.f;
    }

    @Override  // I6.Y
    public Object writeReplace() {
        return super.writeReplace();
    }
}

