package o3;

import e3.b;
import h3.e;
import java.nio.ByteBuffer;

public final class f extends e {
    public long j;
    public int k;
    public int l;

    @Override  // h3.e
    public final void o() {
        super.o();
        this.k = 0;
    }

    public final boolean s(e e0) {
        b.c(!e0.i(0x40000000));
        b.c(!e0.i(0x10000000));
        b.c(!e0.i(4));
        if(this.t() && (this.k >= this.l || e0.e != null && (this.e != null && e0.e.remaining() + this.e.position() > 3072000))) {
            return false;
        }
        int v = this.k;
        this.k = v + 1;
        if(v == 0) {
            this.g = e0.g;
            if(e0.i(1)) {
                this.b = 1;
            }
        }
        ByteBuffer byteBuffer0 = e0.e;
        if(byteBuffer0 != null) {
            this.q(byteBuffer0.remaining());
            this.e.put(byteBuffer0);
        }
        this.j = e0.g;
        return true;
    }

    public final boolean t() {
        return this.k > 0;
    }
}

