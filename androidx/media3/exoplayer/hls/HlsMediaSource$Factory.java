package androidx.media3.exoplayer.hls;

import E9.g;
import Nf.p;
import b3.E;
import e1.F;
import e3.h;
import g3.e;
import i3.d;
import java.util.List;
import k3.o;
import kb.D;
import l3.c;
import l3.k;
import s3.a;
import s3.y;
import y8.s;

public final class HlsMediaSource.Factory implements y {
    public final D a;
    public c b;
    public R6.c c;
    public boolean d;
    public final F e;
    public final d f;
    public final h g;
    public final s h;
    public final p i;
    public final boolean j;
    public final int k;
    public final long l;

    public HlsMediaSource.Factory(e e0) {
        D d0 = new D(e0, 3);
        super();
        this.a = d0;
        this.h = new s(16);
        this.e = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.f = m3.c.o;
        this.i = new p(-1);
        this.g = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.k = 1;
        this.l = 0x8000000000000001L;
        this.j = true;
        this.d = true;
    }

    @Override  // s3.y
    public final void a(boolean z) {
        this.d = z;
    }

    @Override  // s3.y
    public final void b(R6.c c0) {
        this.c = c0;
    }

    @Override  // s3.y
    public final a c(E e0) {
        e0.b.getClass();
        if(this.b == null) {
            c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.a = new R6.c(9);
            this.b = c0;
        }
        R6.c c1 = this.c;
        if(c1 != null) {
            this.b.a = c1;
        }
        c c2 = this.b;
        c2.b = this.d;
        List list0 = e0.b.e;
        F f0 = this.e;
        if(!list0.isEmpty()) {
            f0 = new g(f0, list0);
        }
        o o0 = this.h.g(e0);
        this.f.getClass();
        m3.c c3 = new m3.c(this.a, this.i, f0);
        return new k(e0, this.a, c2, this.g, o0, this.i, c3, this.l, this.j, this.k);
    }
}

