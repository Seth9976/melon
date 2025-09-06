package i.n.i.b.a.s.e;

import I6.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class w1 implements K3 {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final E4 e;
    public final boolean f;
    public final int g;

    public w1() {
        this(10000, 25000, 0.7f, false, -1);
    }

    public w1(int v, int v1, float f, boolean z, int v2) {
        this.a = v;
        this.b = v1;
        this.c = 25000;
        this.d = f;
        this.e = E4.b;
        this.f = z;
        this.g = v2;
    }

    @Override  // i.n.i.b.a.s.e.K3
    public final q2[] c(J3[] arr_j3, bb bb0, e2 e20, i i0) {
        j4 j40;
        c5 c50;
        int v6;
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_j3.length; ++v) {
            J3 j30 = arr_j3[v];
            if(j30 == null || j30.b.length <= 1) {
                arrayList0.add(null);
            }
            else {
                c9 c90 = new c9();
                c90.b(new v1(0L, 0L));
                arrayList0.add(c90);
            }
        }
        int v1 = arr_j3.length;
        long[][] arr2_v = new long[v1][];
        for(int v2 = 0; v2 < arr_j3.length; ++v2) {
            J3 j31 = arr_j3[v2];
            if(j31 == null) {
                arr2_v[v2] = new long[0];
            }
            else {
                int[] arr_v = j31.b;
                arr2_v[v2] = new long[arr_v.length];
                for(int v3 = 0; v3 < arr_v.length; ++v3) {
                    arr2_v[v2][v3] = (long)j31.a.b[arr_v[v3]].h;
                }
                Arrays.sort(arr2_v[v2]);
            }
        }
        int[] arr_v1 = new int[v1];
        long[] arr_v2 = new long[v1];
        for(int v4 = 0; v4 < v1; ++v4) {
            long[] arr_v3 = arr2_v[v4];
            arr_v2[v4] = arr_v3.length == 0 ? 0L : arr_v3[0];
        }
        x1.p(arrayList0, arr_v2);
        Ja.x(2, "expectedValuesPerKey");
        TreeMap treeMap0 = new TreeMap(b3.b);
        T0 t00 = new T0();
        B1 b10 = new B1();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(!treeMap0.isEmpty()) {
            throw new IllegalArgumentException();
        }
        b10.d = treeMap0;
        b10.f = t00;
        int v5 = 0;
        while(v5 < v1) {
            long[] arr_v4 = arr2_v[v5];
            if(arr_v4.length <= 1) {
                v6 = v1;
            }
            else {
                double[] arr_f = new double[arr_v4.length];
                for(int v7 = 0; true; ++v7) {
                    long[] arr_v5 = arr2_v[v5];
                    double f = 0.0;
                    if(v7 >= arr_v5.length) {
                        break;
                    }
                    long v8 = arr_v5[v7];
                    if(v8 != -1L) {
                        f = Math.log(v8);
                    }
                    arr_f[v7] = f;
                }
                v6 = v1;
                int v9 = arr_v4.length - 1;
                double f1 = arr_f[v9] - arr_f[0];
                int v10 = 0;
                while(v10 < v9) {
                    double f2 = arr_f[v10];
                    ++v10;
                    Double double0 = (double)(f1 == 0.0 ? 1.0 : ((f2 + arr_f[v10]) * 0.5 - arr_f[0]) / f1);
                    Integer integer0 = v5;
                    Map map0 = b10.d;
                    Collection collection0 = (Collection)map0.get(double0);
                    if(collection0 == null) {
                        List list0 = (List)b10.f.a();
                        if(!list0.add(integer0)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        ++b10.e;
                        map0.put(double0, list0);
                    }
                    else if(collection0.add(integer0)) {
                        ++b10.e;
                    }
                }
            }
            ++v5;
            v1 = v6;
        }
        Collection collection1 = b10.b;
        if(collection1 == null) {
            collection1 = new s(b10, 4);
            b10.b = collection1;
        }
        h9 h90 = h9.q(collection1);
        for(int v11 = 0; v11 < h90.size(); ++v11) {
            int v12 = (int)(((Integer)h90.get(v11)));
            int v13 = arr_v1[v12] + 1;
            arr_v1[v12] = v13;
            arr_v2[v12] = arr2_v[v12][v13];
            x1.p(arrayList0, arr_v2);
        }
        for(int v14 = 0; v14 < arr_j3.length; ++v14) {
            if(arrayList0.get(v14) != null) {
                arr_v2[v14] *= 2L;
            }
        }
        x1.p(arrayList0, arr_v2);
        Ja.x(4, "initialCapacity");
        Object[] arr_object = new Object[4];
        int v15 = 0;
        int v16;
        for(v16 = 0; v15 < arrayList0.size(); ++v16) {
            c9 c91 = (c9)arrayList0.get(v15);
            if(c91 == null) {
                c50 = c5.e;
            }
            else {
                c91.c = true;
                c50 = h9.r(c91.b, c91.a);
            }
            c50.getClass();
            if(arr_object.length < v16 + 1) {
                arr_object = Arrays.copyOf(arr_object, c9.a(arr_object.length, v16 + 1));
            }
            arr_object[v16] = c50;
            ++v15;
        }
        c5 c51 = h9.r(v16, arr_object);
        q2[] arr_q2 = new q2[arr_j3.length];
        for(int v17 = 0; v17 < arr_j3.length; ++v17) {
            J3 j32 = arr_j3[v17];
            if(j32 != null) {
                int[] arr_v6 = j32.b;
                if(arr_v6.length != 0) {
                    if(arr_v6.length == 1) {
                        j40 = new j4(j32.a, new int[]{arr_v6[0]}, 0);  // 初始化器: Li/n/i/b/a/s/e/q2;-><init>(Li/n/i/b/a/s/e/vc;[II)V
                    }
                    else {
                        Object object0 = c51.get(v17);
                        j40 = new x1(j32.a, arr_v6, bb0, ((long)this.a), ((long)this.b), ((long)this.c), this.d, 0.75f, ((h9)object0), this.e, this.f, this.g);
                    }
                    arr_q2[v17] = j40;
                }
            }
        }
        return arr_q2;
    }
}

