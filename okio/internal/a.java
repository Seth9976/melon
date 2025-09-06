package okio.internal;

import kotlin.jvm.internal.H;
import okio.BufferedSource;
import we.n;

public final class a implements n {
    public final int a;
    public final H b;
    public final BufferedSource c;
    public final H d;
    public final H e;

    public a(H h0, BufferedSource bufferedSource0, H h1, H h2) {
        this.a = 1;
        super();
        this.b = h0;
        this.c = bufferedSource0;
        this.d = h1;
        this.e = h2;
    }

    public a(BufferedSource bufferedSource0, H h0, H h1, H h2) {
        this.a = 0;
        super();
        this.c = bufferedSource0;
        this.b = h0;
        this.d = h1;
        this.e = h2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object0));
        long v1 = (long)(((Long)object1));
        return this.a == 0 ? ZipFilesKt.b(this.b, this.c, this.d, this.e, v, v1) : ZipFilesKt.readCentralDirectoryZipEntry$lambda$8$lambda$7(this.b, this.c, this.d, this.e, v, v1);
    }
}

