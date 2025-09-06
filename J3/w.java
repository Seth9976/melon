package j3;

import c3.b;
import c3.c;
import c3.e;
import e3.x;
import java.nio.ByteBuffer;

public final class w extends e {
    public final float i;
    public final short j;
    public final int k;
    public final long l;
    public final long m;
    public int n;
    public boolean o;
    public int p;
    public long q;
    public int r;
    public byte[] s;
    public int t;
    public int u;
    public byte[] v;

    public w() {
        this.r = 0;
        this.t = 0;
        this.u = 0;
        this.l = 100000L;
        this.i = 0.2f;
        this.m = 2000000L;
        this.k = 10;
        this.j = 0x400;
        this.s = x.f;
        this.v = x.f;
    }

    @Override  // c3.e
    public final b b(b b0) {
        if(b0.c != 2) {
            throw new c(b0);
        }
        return b0.a == -1 ? b.e : b0;
    }

    @Override  // c3.e
    public final void c() {
        if(this.isActive()) {
            int v = this.b.b * 2;
            this.n = v;
            int v1 = ((int)(this.l * ((long)this.b.a) / 1000000L)) / 2 / v * v * 2;
            if(this.s.length != v1) {
                this.s = new byte[v1];
                this.v = new byte[v1];
            }
        }
        this.p = 0;
        this.q = 0L;
        this.r = 0;
        this.t = 0;
        this.u = 0;
    }

    @Override  // c3.e
    public final void d() {
        if(this.u > 0) {
            this.h(true);
            this.r = 0;
        }
    }

    @Override  // c3.e
    public final void e() {
        this.o = false;
        this.s = x.f;
        this.v = x.f;
    }

    public final int g(int v) {
        int v1 = (((int)(this.m * ((long)this.b.a) / 1000000L)) - this.r) * this.n - this.s.length / 2;
        e3.b.j(v1 >= 0);
        return ((int)Math.min(((float)v) * this.i + 0.5f, v1)) / this.n * this.n;
    }

    public final void h(boolean z) {
        int v2;
        int v1;
        boolean z1 = false;
        int v = this.u;
        byte[] arr_b = this.s;
        if(v != arr_b.length && !z) {
            return;
        }
        if(this.r == 0) {
            if(z) {
                this.i(v, 3);
                v1 = v;
            }
            else {
                e3.b.j(v >= arr_b.length / 2);
                v1 = this.s.length / 2;
                this.i(v1, 0);
            }
            v2 = v1;
        }
        else if(z) {
            int v3 = v - arr_b.length / 2;
            int v4 = this.g(v3) + this.s.length / 2;
            this.i(v4, 2);
            v2 = v4;
            v1 = arr_b.length / 2 + v3;
        }
        else {
            v1 = v - arr_b.length / 2;
            v2 = this.g(v1);
            this.i(v2, 1);
        }
        e3.b.i(("bytesConsumed is not aligned to frame size: %s" + v1), v1 % this.n == 0);
        if(v >= v2) {
            z1 = true;
        }
        e3.b.j(z1);
        this.u -= v1;
        this.t = (this.t + v1) % this.s.length;
        int v5 = this.n;
        this.r = v2 / v5 + this.r;
        this.q += (long)((v1 - v2) / v5);
    }

    public final void i(int v, int v1) {
        boolean z = true;
        if(v == 0) {
            return;
        }
        e3.b.c(this.u >= v);
        if(v1 == 2) {
            int v2 = this.t;
            int v3 = this.u;
            int v4 = v2 + v3;
            byte[] arr_b = this.s;
            if(v4 <= arr_b.length) {
                System.arraycopy(arr_b, v4 - v, this.v, 0, v);
            }
            else {
                int v5 = v3 - (arr_b.length - v2);
                if(v5 >= v) {
                    System.arraycopy(arr_b, v5 - v, this.v, 0, v);
                }
                else {
                    int v6 = v - v5;
                    System.arraycopy(arr_b, arr_b.length - v6, this.v, 0, v6);
                    System.arraycopy(this.s, 0, this.v, v6, v5);
                }
            }
        }
        else {
            int v7 = this.t;
            byte[] arr_b1 = this.s;
            if(v7 + v <= arr_b1.length) {
                System.arraycopy(arr_b1, v7, this.v, 0, v);
            }
            else {
                int v8 = arr_b1.length - v7;
                System.arraycopy(arr_b1, v7, this.v, 0, v8);
                System.arraycopy(this.s, 0, this.v, v8, v - v8);
            }
        }
        e3.b.d(v % this.n == 0, "sizeToOutput is not aligned to frame size: " + v);
        e3.b.j(this.t < this.s.length);
        byte[] arr_b2 = this.v;
        if(v % this.n != 0) {
            z = false;
        }
        e3.b.d(z, "byteOutput size is not aligned to frame size " + v);
        if(v1 != 3) {
            for(int v9 = 0; v9 < v; v9 += 2) {
                int v10 = arr_b2[v9 + 1] << 8 | arr_b2[v9] & 0xFF;
                int v11 = this.k;
                if(v1 == 0) {
                    v11 = v9 * 1000 / (v - 1) * (v11 - 100) / 1000 + 100;
                }
                else if(v1 == 2) {
                    v11 += v9 * 1000 * (100 - v11) / (v - 1) / 1000;
                }
                int v12 = v10 * v11 / 100;
                if(v12 >= 0x7FFF) {
                    arr_b2[v9] = -1;
                    arr_b2[v9 + 1] = 0x7F;
                }
                else if(v12 <= 0xFFFF8000) {
                    arr_b2[v9] = 0;
                    arr_b2[v9 + 1] = (byte)0x80;
                }
                else {
                    arr_b2[v9] = (byte)(v12 & 0xFF);
                    arr_b2[v9 + 1] = (byte)(v12 >> 8);
                }
            }
        }
        this.f(v).put(arr_b2, 0, v).flip();
    }

    // 去混淆评级： 低(20)
    @Override  // c3.e
    public final boolean isActive() {
        return super.isActive() && this.o;
    }

    // This method was un-flattened
    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        int v6;
        int v4;
        int v3;
        while(byteBuffer0.hasRemaining() && !this.g.hasRemaining()) {
            int v = this.j;
            switch(this.p) {
                case 0: {
                    int v1 = byteBuffer0.limit();
                    byteBuffer0.limit(Math.min(v1, byteBuffer0.position() + this.s.length));
                    int v2 = byteBuffer0.limit() - 1;
                    while(true) {
                        if(v2 >= byteBuffer0.position()) {
                            if(Math.abs(byteBuffer0.get(v2) << 8 | byteBuffer0.get(v2 - 1) & 0xFF) > v) {
                                v3 = v2 / this.n * this.n + this.n;
                                break;
                            }
                            else {
                                v2 -= 2;
                                continue;
                            }
                        }
                        v3 = byteBuffer0.position();
                        break;
                    }
                    if(v3 == byteBuffer0.position()) {
                        this.p = 1;
                    }
                    else {
                        byteBuffer0.limit(Math.min(v3, byteBuffer0.capacity()));
                        this.f(byteBuffer0.remaining()).put(byteBuffer0).flip();
                    }
                    byteBuffer0.limit(v1);
                    continue;
                }
                case 1: {
                    e3.b.j(this.t < this.s.length);
                    v4 = byteBuffer0.limit();
                    int v5 = byteBuffer0.position() + 1;
                    while(true) {
                        if(v5 < byteBuffer0.limit()) {
                            if(Math.abs(byteBuffer0.get(v5) << 8 | byteBuffer0.get(v5 - 1) & 0xFF) > v) {
                                v6 = v5 / this.n * this.n;
                                break;
                            }
                            else {
                                v5 += 2;
                                continue;
                            }
                        }
                        v6 = byteBuffer0.limit();
                        break;
                    }
                    int v7 = v6 - byteBuffer0.position();
                    int v8 = this.t;
                    int v9 = this.u;
                    int v10 = v8 + v9;
                    byte[] arr_b = this.s;
                    if(v10 < arr_b.length) {
                        v8 = arr_b.length;
                    }
                    else {
                        v10 = v9 - (arr_b.length - v8);
                    }
                    int v11 = v8 - v10;
                    int v12 = Math.min(v7, v11);
                    byteBuffer0.limit(byteBuffer0.position() + v12);
                    byteBuffer0.get(this.s, v10, v12);
                    int v13 = this.u + v12;
                    this.u = v13;
                    e3.b.j(v13 <= this.s.length);
                    if(v6 < v4 && v7 < v11) {
                        this.h(true);
                        this.p = 0;
                        this.r = 0;
                    }
                    else {
                        this.h(false);
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            byteBuffer0.limit(v4);
        }
    }
}

