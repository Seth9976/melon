package j3;

import c3.b;
import c3.c;
import c3.e;
import e3.x;
import java.nio.ByteBuffer;

public final class y extends e {
    public int i;
    public int j;
    public boolean k;
    public int l;
    public byte[] m;
    public int n;
    public long o;

    @Override  // c3.e
    public final b b(b b0) {
        if(b0.c != 2) {
            throw new c(b0);
        }
        this.k = true;
        return this.i != 0 || this.j != 0 ? b0 : b.e;
    }

    @Override  // c3.e
    public final void c() {
        if(this.k) {
            this.k = false;
            int v = this.b.d;
            this.m = new byte[this.j * v];
            this.l = this.i * v;
        }
        this.n = 0;
    }

    @Override  // c3.e
    public final void d() {
        if(this.k) {
            int v = this.n;
            if(v > 0) {
                this.o += (long)(v / this.b.d);
            }
            this.n = 0;
        }
    }

    @Override  // c3.e
    public final void e() {
        this.m = x.f;
    }

    @Override  // c3.e
    public final ByteBuffer getOutput() {
        if(super.isEnded()) {
            int v = this.n;
            if(v > 0) {
                this.f(v).put(this.m, 0, this.n).flip();
                this.n = 0;
            }
        }
        return super.getOutput();
    }

    @Override  // c3.e
    public final boolean isEnded() {
        return super.isEnded() && this.n == 0;
    }

    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.position();
        int v1 = byteBuffer0.limit();
        int v2 = v1 - v;
        if(v2 != 0) {
            int v3 = Math.min(v2, this.l);
            this.o += (long)(v3 / this.b.d);
            this.l -= v3;
            byteBuffer0.position(v + v3);
            if(this.l <= 0) {
                int v4 = v2 - v3;
                int v5 = this.n + v4 - this.m.length;
                ByteBuffer byteBuffer1 = this.f(v5);
                int v6 = x.h(v5, 0, this.n);
                byteBuffer1.put(this.m, 0, v6);
                int v7 = x.h(v5 - v6, 0, v4);
                byteBuffer0.limit(byteBuffer0.position() + v7);
                byteBuffer1.put(byteBuffer0);
                byteBuffer0.limit(v1);
                int v8 = v4 - v7;
                int v9 = this.n - v6;
                this.n = v9;
                System.arraycopy(this.m, v6, this.m, 0, v9);
                byteBuffer0.get(this.m, this.n, v8);
                this.n += v8;
                byteBuffer1.flip();
            }
        }
    }
}

