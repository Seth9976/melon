package t3;

import androidx.media3.common.b;
import g3.f;
import g3.j;
import g3.w;
import s3.q;
import w3.h;

public abstract class a implements h {
    public final long a;
    public final j b;
    public final int c;
    public final b d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    public final w i;

    public a(f f0, j j0, int v, b b0, int v1, Object object0, long v2, long v3) {
        this.i = new w(f0);
        this.b = j0;
        this.c = v;
        this.d = b0;
        this.e = v1;
        this.f = object0;
        this.g = v2;
        this.h = v3;
        this.a = q.c.getAndIncrement();
    }
}

