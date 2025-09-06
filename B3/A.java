package b3;

import android.net.Uri;
import e3.b;
import java.util.Arrays;

public final class a {
    public final long a;
    public final int b;
    public final int c;
    public final Uri[] d;
    public final E[] e;
    public final int[] f;
    public final long[] g;
    public final long h;
    public final boolean i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    static {
        a.j = "0";
        a.k = "1";
        a.l = "2";
        a.m = "3";
        a.n = "4";
        a.o = "5";
        a.p = "6";
        a.q = "7";
        a.r = "8";
    }

    public a(long v, int v1, int v2, int[] arr_v, E[] arr_e, long[] arr_v1, long v3, boolean z) {
        b.c(arr_v.length == arr_e.length);
        Uri uri0;
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.f = arr_v;
        this.e = arr_e;
        this.g = arr_v1;
        this.h = v3;
        this.i = z;
        this.d = new Uri[arr_e.length];
        for(int v4 = 0; true; ++v4) {
            Uri[] arr_uri = this.d;
            if(v4 >= arr_uri.length) {
                break;
            }
            E e0 = arr_e[v4];
            if(e0 == null) {
                uri0 = null;
            }
            else {
                e0.b.getClass();
                uri0 = e0.b.a;
            }
            arr_uri[v4] = uri0;
        }
    }

    public final int a(int v) {
        int v1 = v + 1;
    alab1:
        while(true) {
            int[] arr_v = this.f;
            if(v1 >= arr_v.length || this.i) {
                break;
            }
            switch(arr_v[v1]) {
                case 0: 
                case 1: {
                    break alab1;
                }
                default: {
                    ++v1;
                }
            }
        }
        return v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return a.class == class0 && this.a == ((a)object0).a && this.b == ((a)object0).b && this.c == ((a)object0).c && Arrays.equals(this.e, ((a)object0).e) && Arrays.equals(this.f, ((a)object0).f) && Arrays.equals(this.g, ((a)object0).g) && this.h == ((a)object0).h && this.i == ((a)object0).i;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.e);
        int v1 = Arrays.hashCode(this.f);
        return ((Arrays.hashCode(this.g) + (v1 + (v + ((this.b * 0x1F + this.c) * 0x1F + ((int)(this.a ^ this.a >>> 0x20))) * 0x1F) * 0x1F) * 0x1F) * 0x1F + ((int)(this.h >>> 0x20 ^ this.h))) * 0x1F + this.i;
    }
}

