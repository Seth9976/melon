package i.n.i.b.a.s.e;

import h3.b;
import java.nio.ByteBuffer;

public final class na {
    public final byte[] a;
    public int b;
    public int c;
    public final int[] d;
    public final int[] e;
    public final long f;
    public final int[] g;
    public final int[] h;

    public na(ByteBuffer byteBuffer0, b b0, long v) {
        this.g = new int[1];
        this.h = new int[1];
        byte[] arr_b = new byte[byteBuffer0.limit()];
        this.a = arr_b;
        byteBuffer0.get(arr_b);
        this.b = 0;
        this.f = v;
        this.c = 0;
        int v2 = b0.f;
        this.d = new int[v2];
        this.e = new int[v2];
        for(int v1 = 0; v1 < b0.f; ++v1) {
            this.d[v1] = b0.d[v1];
            this.e[v1] = b0.e[v1];
        }
    }

    public final void a(W7 w70, int v, I8 i80, b b0) {
        int v1 = this.d[this.c] + this.e[this.c];
        byte[] arr_b = new byte[v1];
        System.arraycopy(this.a, this.b, arr_b, 0, v1);
        this.b += v1;
        i80.d.clear();
        i80.d.put(arr_b);
        i80.d.limit(v1);
        i80.d.position(0);
        int v2 = this.c;
        this.g[0] = this.d[v2];
        this.h[0] = this.e[v2];
        b0.a(1, this.g, this.h, b0.b, b0.a, b0.c, b0.g, b0.h);
        w70.k(v, b0, this.f, 0);
        ++this.c;
    }
}

