package i.n.i.b.a.s.e;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ea.b;
import java.util.ArrayList;

public final class s0 extends d2 implements Handler.Callback {
    public boolean B;
    public boolean D;
    public long E;
    public long G;
    public x8 I;
    public final E4 m;
    public final Y n;
    public final Handler o;
    public final s r;
    public Ja w;

    public s0(Y y0, Looper looper0) {
        super(5);
        this.n = y0;
        this.o = looper0 == null ? null : new Handler(looper0, this);
        this.m = E4.e;
        this.r = new s(1);  // 初始化器: Li/n/i/b/a/s/e/I8;-><init>(I)V
        this.G = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void b() {
        this.I = null;
        this.G = 0x8000000000000001L;
        this.w = null;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final int g(u u0) {
        if(this.m.q(u0)) {
            return u0.Z == null ? 4 : 2;
        }
        return 0;
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        if(message0.what != 0) {
            throw new IllegalStateException();
        }
        this.n.d(((x8)message0.obj));
        return true;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void j(long v, long v1) {
        boolean z = true;
        while(z) {
            if(!this.B && this.I == null) {
                s s0 = this.r;
                s0.o();
                b b0 = this.b;
                b0.d();
                int v2 = this.f(b0, s0, 0);
                if(v2 != -4) {
                    if(v2 == -5) {
                        u u0 = (u)b0.b;
                        u0.getClass();
                        this.E = u0.r;
                    }
                }
                else if(s0.f(4)) {
                    this.B = true;
                }
                else {
                    s0.i = this.E;
                    s0.q();
                    x8 x80 = this.w.o(s0);
                    if(x80 != null) {
                        ArrayList arrayList0 = new ArrayList(x80.a.length);
                        this.y(x80, arrayList0);
                        if(!arrayList0.isEmpty()) {
                            this.I = new x8(arrayList0);
                            this.G = s0.f;
                        }
                    }
                }
            }
            x8 x81 = this.I;
            if(x81 == null || this.G > v) {
                z = false;
            }
            else {
                Handler handler0 = this.o;
                if(handler0 == null) {
                    this.n.d(x81);
                }
                else {
                    handler0.obtainMessage(0, x81).sendToTarget();
                }
                this.I = null;
                this.G = 0x8000000000000001L;
                z = true;
            }
            if(this.B && this.I == null) {
                this.D = true;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void k(long v, boolean z) {
        this.I = null;
        this.G = 0x8000000000000001L;
        this.B = false;
        this.D = false;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void m(u[] arr_u, long v, long v1) {
        this.w = this.m.y(arr_u[0]);
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final boolean p() {
        return this.D;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final boolean q() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final String r() {
        return "MetadataRenderer";
    }

    public final void y(x8 x80, ArrayList arrayList0) {
        for(int v = 0; true; ++v) {
            i.n.i.b.a.s.e.x8.b[] arr_x8$b = x80.a;
            if(v >= arr_x8$b.length) {
                break;
            }
            u u0 = arr_x8$b[v].c();
            if(u0 == null) {
                arrayList0.add(arr_x8$b[v]);
            }
            else {
                E4 e40 = this.m;
                if(e40.q(u0)) {
                    Ja ja0 = e40.y(u0);
                    byte[] arr_b = arr_x8$b[v].b();
                    arr_b.getClass();
                    this.r.o();
                    this.r.r(arr_b.length);
                    this.r.d.put(arr_b);
                    this.r.q();
                    x8 x81 = ja0.o(this.r);
                    if(x81 != null) {
                        this.y(x81, arrayList0);
                    }
                }
                else {
                    arrayList0.add(arr_x8$b[v]);
                }
            }
        }
    }
}

