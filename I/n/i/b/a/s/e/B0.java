package i.n.i.b.a.s.e;

import android.os.Message;
import ea.b;
import jeb.synthetic.FIN;

public final class b0 implements ie {
    public final e7 a;
    public final b b;
    public final s c;
    public long d;
    public final c0 e;

    public b0(c0 c00, L3 l30) {
        this.e = c00;
        this.a = new e7(l30, null, null, null);
        this.b = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new s(1);  // 初始化器: Li/n/i/b/a/s/e/I8;-><init>(I)V
        this.d = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.ie
    public final void a(u u0) {
        this.a.a(u0);
    }

    @Override  // i.n.i.b.a.s.e.ie
    public final void c(int v, wb wb0) {
        this.a.b(v, wb0);
    }

    @Override  // i.n.i.b.a.s.e.ie
    public final int d(xe xe0, int v, boolean z) {
        return this.a.d(xe0, v, z);
    }

    @Override  // i.n.i.b.a.s.e.ie
    public final void f(long v, int v1, int v2, int v3, he he0) {
        long v8;
        long v5;
        this.a.f(v, v1, v2, v3, he0);
        while(this.a.l(false)) {
            s s0 = this.c;
            s0.o();
            if(this.a.i(this.b, s0, 0, false) == -4) {
                s0.q();
            }
            else {
                s0 = null;
            }
            if(s0 != null) {
                long v4 = s0.f;
                x8 x80 = this.e.c.o(s0);
                if(x80 != null) {
                    g9 g90 = (g9)x80.a[0];
                    if("urn:mpeg:dash:event:2012".equals(g90.a) && ("1".equals(g90.b) || "2".equals(g90.b) || "3".equals(g90.b))) {
                        try {
                            v5 = 0x8000000000000001L;
                            v5 = L7.I(L7.k(g90.e));
                        }
                        catch(H4 unused_ex) {
                        }
                        if(v5 != 0x8000000000000001L) {
                            a0 a00 = new a0(v4, v5);
                            Message message0 = this.e.d.obtainMessage(1, a00);
                            this.e.d.sendMessage(message0);
                        }
                    }
                }
            }
        }
        e7 e70 = this.a;
        G6 g60 = e70.a;
        __monitor_enter(e70);
        int v6 = FIN.finallyOpen$NT();
        int v7 = e70.t;
        if(v7 == 0) {
            FIN.finallyExec$NT(v6);
            v8 = -1L;
        }
        else {
            v8 = e70.j(v7);
            FIN.finallyCodeBegin$NT(v6);
            __monitor_exit(e70);
            FIN.finallyCodeEnd$NT(v6);
        }
        g60.d(v8);
    }
}

