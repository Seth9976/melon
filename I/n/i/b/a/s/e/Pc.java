package i.n.i.b.a.s.e;

import android.net.Uri;

public final class pc extends Kb {
    public final byte[] e;
    public Uri f;
    public int g;
    public int h;
    public boolean i;

    public pc(byte[] arr_b) {
        boolean z = false;
        super(false);
        arr_b.getClass();
        if(arr_b.length > 0) {
            z = true;
        }
        M7.u(z);
        this.e = arr_b;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        long v = w20.g;
        this.f = w20.b;
        this.c(w20);
        long v1 = w20.f;
        byte[] arr_b = this.e;
        if(v1 > ((long)arr_b.length)) {
            throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
        }
        this.g = (int)v1;
        int v2 = arr_b.length - ((int)v1);
        this.h = v2;
        int v3 = Long.compare(v, -1L);
        if(v3 != 0) {
            this.h = (int)Math.min(v2, v);
        }
        this.i = true;
        this.d(w20);
        return v3 == 0 ? ((long)this.h) : v;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.f;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        if(this.i) {
            this.i = false;
            this.h();
        }
        this.f = null;
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        int v2 = this.h;
        if(v2 == 0) {
            return -1;
        }
        int v3 = Math.min(v1, v2);
        System.arraycopy(this.e, this.g, arr_b, v, v3);
        this.g += v3;
        this.h -= v3;
        this.g(v3);
        return v3;
    }
}

