package V3;

import e3.b;
import e3.x;

public final class v {
    public final s a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public v(s s0, long[] arr_v, int[] arr_v1, int v, long[] arr_v2, int[] arr_v3, long v1) {
        boolean z = false;
        b.c(arr_v1.length == arr_v2.length);
        b.c(arr_v.length == arr_v2.length);
        if(arr_v3.length == arr_v2.length) {
            z = true;
        }
        b.c(z);
        this.a = s0;
        this.c = arr_v;
        this.d = arr_v1;
        this.e = v;
        this.f = arr_v2;
        this.g = arr_v3;
        this.h = v1;
        this.b = arr_v.length;
        if(arr_v3.length > 0) {
            arr_v3[arr_v3.length - 1] |= 0x20000000;
        }
    }

    public final int a(long v) {
        long[] arr_v = this.f;
        for(int v1 = x.a(arr_v, v, true); v1 < arr_v.length; ++v1) {
            if((this.g[v1] & 1) != 0) {
                return v1;
            }
        }
        return -1;
    }
}

