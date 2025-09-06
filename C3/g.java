package c3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class g implements d {
    public int b;
    public float c;
    public float d;
    public b e;
    public b f;
    public b g;
    public b h;
    public boolean i;
    public f j;
    public ByteBuffer k;
    public ShortBuffer l;
    public ByteBuffer m;
    public long n;
    public long o;
    public boolean p;

    @Override  // c3.d
    public final b a(b b0) {
        if(b0.c != 2) {
            throw new c(b0);
        }
        this.e = b0;
        b b1 = new b((this.b == -1 ? b0.a : this.b), b0.b, 2);
        this.f = b1;
        this.i = true;
        return b1;
    }

    @Override  // c3.d
    public final void flush() {
        if(this.isActive()) {
            b b0 = this.e;
            this.g = b0;
            b b1 = this.f;
            this.h = b1;
            if(this.i) {
                this.j = new f(b0.a, b0.b, this.c, this.d, b1.a);
            }
            else {
                f f0 = this.j;
                if(f0 != null) {
                    f0.k = 0;
                    f0.m = 0;
                    f0.o = 0;
                    f0.p = 0;
                    f0.q = 0;
                    f0.r = 0;
                    f0.s = 0;
                    f0.t = 0;
                    f0.u = 0;
                    f0.v = 0;
                    f0.w = 0.0;
                }
            }
        }
        this.m = d.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override  // c3.d
    public final ByteBuffer getOutput() {
        f f0 = this.j;
        if(f0 != null) {
            int v = f0.b;
            int v1 = f0.m * v * 2;
            if(v1 > 0) {
                if(this.k.capacity() < v1) {
                    ByteBuffer byteBuffer0 = ByteBuffer.allocateDirect(v1).order(ByteOrder.nativeOrder());
                    this.k = byteBuffer0;
                    this.l = byteBuffer0.asShortBuffer();
                }
                else {
                    this.k.clear();
                    this.l.clear();
                }
                ShortBuffer shortBuffer0 = this.l;
                int v2 = Math.min(shortBuffer0.remaining() / v, f0.m);
                int v3 = v2 * v;
                shortBuffer0.put(f0.l, 0, v3);
                int v4 = f0.m - v2;
                f0.m = v4;
                System.arraycopy(f0.l, v3, f0.l, 0, v4 * v);
                this.o += (long)v1;
                this.k.limit(v1);
                this.m = this.k;
            }
        }
        ByteBuffer byteBuffer1 = this.m;
        this.m = d.a;
        return byteBuffer1;
    }

    @Override  // c3.d
    public final boolean isActive() {
        return this.f.a != -1 && (Math.abs(this.c - 1.0f) >= 0.0001f || Math.abs(this.d - 1.0f) >= 0.0001f || this.f.a != this.e.a);
    }

    // 去混淆评级： 低(20)
    @Override  // c3.d
    public final boolean isEnded() {
        return this.p && (this.j == null || this.j.m * this.j.b * 2 == 0);
    }

    @Override  // c3.d
    public final void queueEndOfStream() {
        f f0 = this.j;
        if(f0 != null) {
            int v = f0.k;
            int v1 = f0.m + ((int)((((double)(v - f0.r)) / ((double)(f0.c / f0.d)) + ((double)f0.r) + f0.w + ((double)f0.o)) / ((double)(f0.e * f0.d)) + 0.5));
            f0.w = 0.0;
            int v2 = f0.h * 2;
            f0.j = f0.c(f0.j, v, v2 + v);
            for(int v3 = 0; true; ++v3) {
                int v4 = f0.b;
                if(v3 >= v2 * v4) {
                    break;
                }
                f0.j[v4 * v + v3] = 0;
            }
            f0.k = v2 + f0.k;
            f0.f();
            if(f0.m > v1) {
                f0.m = v1;
            }
            f0.k = 0;
            f0.r = 0;
            f0.o = 0;
        }
        this.p = true;
    }

    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        if(!byteBuffer0.hasRemaining()) {
            return;
        }
        f f0 = this.j;
        f0.getClass();
        ShortBuffer shortBuffer0 = byteBuffer0.asShortBuffer();
        int v = byteBuffer0.remaining();
        this.n += (long)v;
        int v1 = shortBuffer0.remaining() / f0.b;
        short[] arr_v = f0.c(f0.j, f0.k, v1);
        f0.j = arr_v;
        shortBuffer0.get(arr_v, f0.k * f0.b, v1 * f0.b * 2 / 2);
        f0.k += v1;
        f0.f();
        byteBuffer0.position(byteBuffer0.position() + v);
    }

    @Override  // c3.d
    public final void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = b.e;
        this.f = b.e;
        this.g = b.e;
        this.h = b.e;
        this.k = d.a;
        this.l = d.a.asShortBuffer();
        this.m = d.a;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}

