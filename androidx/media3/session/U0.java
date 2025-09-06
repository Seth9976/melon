package androidx.media3.session;

import I6.V;
import I6.p0;
import android.util.SparseBooleanArray;
import b3.M;
import b3.N;
import b3.m;
import e3.b;
import java.util.HashSet;

public final class u0 {
    public final t1 a;
    public final N b;
    public final V c;
    public final V d;
    public static final t1 e;
    public static final N f;

    static {
        HashSet hashSet0 = new HashSet();
        p0 p00 = s1.d;
        for(int v = 0; v < p00.d; ++v) {
            hashSet0.add(new s1(((int)(((Integer)p00.get(v))))));
        }
        new t1(hashSet0);
        HashSet hashSet1 = new HashSet();
        p0 p01 = s1.e;
        for(int v1 = 0; v1 < p01.d; ++v1) {
            hashSet1.add(new s1(((int)(((Integer)p01.get(v1))))));
        }
        for(int v2 = 0; v2 < p00.d; ++v2) {
            hashSet1.add(new s1(((int)(((Integer)p00.get(v2))))));
        }
        u0.e = new t1(hashSet1);
        SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
        int[] arr_v = M.b;
        for(int v3 = 0; v3 < arr_v.length; ++v3) {
            int v4 = arr_v[v3];
            b.j(((boolean)1));
            sparseBooleanArray0.append(v4, true);
        }
        b.j(((boolean)1));
        u0.f = new N(new m(sparseBooleanArray0));
    }

    public u0(t1 t10, N n0, V v0, V v1) {
        this.a = t10;
        this.b = n0;
        this.c = v0;
        this.d = v1;
    }
}

