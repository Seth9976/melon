package m3;

import androidx.media3.common.DrmInitData;

public abstract class g implements Comparable {
    public final String a;
    public final f b;
    public final long c;
    public final int d;
    public final long e;
    public final DrmInitData f;
    public final String g;
    public final String h;
    public final long i;
    public final long j;
    public final boolean k;

    public g(String s, f f0, long v, int v1, long v2, DrmInitData drmInitData0, String s1, String s2, long v3, long v4, boolean z) {
        this.a = s;
        this.b = f0;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = drmInitData0;
        this.g = s1;
        this.h = s2;
        this.i = v3;
        this.j = v4;
        this.k = z;
    }

    @Override
    public final int compareTo(Object object0) {
        long v = this.e;
        if(v > ((long)(((Long)object0)))) {
            return 1;
        }
        return v >= ((long)(((Long)object0))) ? 0 : -1;
    }
}

