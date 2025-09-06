package okio.internal;

import kotlin.jvm.internal.C;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.H;
import okio.BufferedSource;
import we.n;

public final class b implements n {
    public final C a;
    public final long b;
    public final G c;
    public final BufferedSource d;
    public final G e;
    public final G f;
    public final H g;
    public final H h;
    public final H i;

    public b(C c0, long v, G g0, BufferedSource bufferedSource0, G g1, G g2, H h0, H h1, H h2) {
        this.a = c0;
        this.b = v;
        this.c = g0;
        this.d = bufferedSource0;
        this.e = g1;
        this.f = g2;
        this.g = h0;
        this.h = h1;
        this.i = h2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ZipFilesKt.readCentralDirectoryZipEntry$lambda$8(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, ((int)(((Integer)object0))), ((long)(((Long)object1))));
    }
}

