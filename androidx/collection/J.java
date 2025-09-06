package androidx.collection;

import je.n;

public abstract class j {
    public static final float[] a;

    static {
        long[] arr_v = S.a;
        int v = S.e(0);
        int v1 = v <= 0 ? 0 : Math.max(7, S.d(v));
        if(v1 != 0) {
            arr_v = new long[(v1 + 15 & -8) >> 3];
            n.e0(arr_v, 0x8080808080808080L);
        }
        arr_v[v1 >> 3] |= 0xFFL << ((v1 & 7) << 3);
        new float[v1];
        j.a = new float[0];
    }
}

