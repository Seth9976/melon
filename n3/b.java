package n3;

import R8.s;
import Y3.e;
import Y3.i;
import Y3.l;
import h3.c;
import h3.f;
import i.n.i.b.a.s.e.pd;
import i3.d;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

public final class b implements e, c {
    public final s a;
    public final Object b;
    public final ArrayDeque c;
    public final ArrayDeque d;
    public final h3.e[] e;
    public final f[] f;
    public int g;
    public int h;
    public h3.e i;
    public pd j;
    public boolean k;
    public boolean l;
    public long m;
    public final int n;
    public final Object o;

    public b(l l0) {
        this.n = 1;
        this(new i[2], new Y3.c[2]);
        h3.e[] arr_e = this.e;
        e3.b.j(this.g == arr_e.length);
        for(int v = 0; v < arr_e.length; ++v) {
            arr_e[v].q(0x400);
        }
        this.o = l0;
    }

    public b(d d0) {
        this.n = 0;
        this(new h3.e[1], new a[1]);
        this.o = d0;
    }

    public b(h3.e[] arr_e, f[] arr_f) {
        this.b = new Object();
        this.m = 0x8000000000000001L;
        this.c = new ArrayDeque();
        this.d = new ArrayDeque();
        this.e = arr_e;
        this.g = arr_e.length;
        for(int v1 = 0; v1 < this.g; ++v1) {
            h3.e[] arr_e1 = this.e;
            h3.e e0 = this.n == 0 ? new h3.e(1) : new i(1);  // 初始化器: Lh3/e;-><init>(I)V
            arr_e1[v1] = e0;
        }
        this.f = arr_f;
        this.h = arr_f.length;
        for(int v = 0; v < this.h; ++v) {
            f[] arr_f1 = this.f;
            Y3.c c0 = this.n == 0 ? new a(this) : new Y3.c(this);
            arr_f1[v] = c0;
        }
        s s0 = new s(this, 1);
        this.a = s0;
        s0.start();
    }

    @Override  // h3.c
    public final void a(i i0) {
        this.g(i0);
    }

    @Override  // h3.c
    public final void b(long v) {
        synchronized(this.b) {
            e3.b.j(this.g == this.e.length || this.k);
            this.m = v;
        }
    }

    public final pd c(Throwable throwable0) {
        return this.n != 0 ? new Y3.f("Unexpected decode error", throwable0) : new n3.d("Unexpected decode error", throwable0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V / 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    }

    public final pd d(h3.e e0, f f0, boolean z) {
        if(this.n != 0) {
            i i0 = (i)e0;
            Y3.c c0 = (Y3.c)f0;
            try {
                ByteBuffer byteBuffer0 = i0.e;
                byteBuffer0.getClass();
                byte[] arr_b = byteBuffer0.array();
                int v = byteBuffer0.limit();
                l l0 = (l)this.o;
                if(z) {
                    l0.reset();
                }
                Y3.d d0 = l0.i(arr_b, 0, v);
                long v1 = i0.g;
                long v2 = i0.j;
                c0.c = v1;
                c0.e = d0;
                if(v2 != 0x7FFFFFFFFFFFFFFFL) {
                    v1 = v2;
                }
                c0.f = v1;
                c0.d = false;
                return null;
            }
            catch(Y3.f pd0) {
                return pd0;
            }
        }
        a a0 = (a)f0;
        try {
            ByteBuffer byteBuffer1 = e0.e;
            byteBuffer1.getClass();
            e3.b.j(byteBuffer1.hasArray());
            e3.b.c(byteBuffer1.arrayOffset() == 0);
            byte[] arr_b1 = byteBuffer1.array();
            ((d)this.o).getClass();
            a0.e = d.a(byteBuffer1.remaining(), arr_b1);
            a0.c = e0.g;
            return null;
        }
        catch(n3.d pd1) {
            return pd1;
        }
    }

    @Override  // h3.c
    public final Object dequeueInputBuffer() {
        pd pd0;
        h3.e e0;
        synchronized(this.b) {
            pd0 = this.j;
            if(pd0 == null) {
                e3.b.j(this.i == null);
                int v1 = this.g;
                if(v1 == 0) {
                    e0 = null;
                }
                else {
                    this.g = v1 - 1;
                    e0 = this.e[v1 - 1];
                }
                this.i = e0;
                return e0;
            }
        }
        throw pd0;
    }

    @Override  // h3.c
    public final Object dequeueOutputBuffer() {
        return this.f();
    }

    public final boolean e() {
        boolean z;
        f f0;
        h3.e e0;
        pd pd0;
        synchronized(this.b) {
            while(!this.l && (this.c.isEmpty() || this.h <= 0)) {
                this.b.wait();
            }
            if(this.l) {
                return false;
            }
            e0 = (h3.e)this.c.removeFirst();
            int v1 = this.h - 1;
            this.h = v1;
            f0 = this.f[v1];
            z = this.k;
            this.k = false;
        }
        if(e0.i(4)) {
            f0.c(4);
        }
        else {
            f0.c = e0.g;
            if(e0.i(0x8000000)) {
                f0.c(0x8000000);
            }
            if(this.m != 0x8000000000000001L && e0.g < this.m) {
                f0.d = true;
            }
            try {
                pd0 = this.d(e0, f0, z);
            }
            catch(RuntimeException runtimeException0) {
                pd0 = this.c(runtimeException0);
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                pd0 = this.c(outOfMemoryError0);
            }
            if(pd0 != null) {
                synchronized(this.b) {
                    this.j = pd0;
                }
                return false;
            }
        }
        synchronized(this.b) {
            if(this.k) {
                f0.p();
            }
            else if(f0.d) {
                f0.p();
            }
            else {
                this.d.addLast(f0);
            }
            e0.o();
            int v3 = this.g;
            this.g = v3 + 1;
            this.e[v3] = e0;
            return true;
        }
    }

    public final f f() {
        pd pd0;
        synchronized(this.b) {
            pd0 = this.j;
            if(pd0 == null) {
                return this.d.isEmpty() ? null : ((f)this.d.removeFirst());
            }
        }
        throw pd0;
    }

    @Override  // h3.c
    public final void flush() {
        synchronized(this.b) {
            this.k = true;
            h3.e e0 = this.i;
            if(e0 != null) {
                e0.o();
                int v1 = this.g;
                this.g = v1 + 1;
                this.e[v1] = e0;
                this.i = null;
            }
            while(!this.c.isEmpty()) {
                h3.e e1 = (h3.e)this.c.removeFirst();
                e1.o();
                int v2 = this.g;
                this.g = v2 + 1;
                this.e[v2] = e1;
            }
            while(!this.d.isEmpty()) {
                ((f)this.d.removeFirst()).p();
            }
        }
    }

    public final void g(h3.e e0) {
        pd pd0;
        synchronized(this.b) {
            pd0 = this.j;
            if(pd0 == null) {
                e3.b.c(e0 == this.i);
                this.c.addLast(e0);
                if(!this.c.isEmpty() && this.h > 0) {
                    this.b.notify();
                }
                this.i = null;
                return;
            }
        }
        throw pd0;
    }

    public final void h(f f0) {
        synchronized(this.b) {
            f0.o();
            int v1 = this.h;
            this.h = v1 + 1;
            this.f[v1] = f0;
            if(!this.c.isEmpty() && this.h > 0) {
                this.b.notify();
            }
        }
    }

    @Override  // h3.c
    public final void release() {
        synchronized(this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        }
        catch(InterruptedException unused_ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override  // Y3.e
    public void setPositionUs(long v) {
    }
}

