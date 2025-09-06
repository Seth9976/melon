package h4;

import B3.L;
import B3.t;
import android.util.Log;
import b3.n;
import e3.b;
import e3.p;
import i.n.i.b.a.s.e.M4;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.U5;
import i.n.i.b.a.s.e.ie;
import i.n.i.b.a.s.e.j1;
import i.n.i.b.a.s.e.ob;
import i.n.i.b.a.s.e.u;
import i.n.i.b.a.s.e.wb;
import java.util.Collections;
import java.util.List;

public final class h implements i, M4 {
    public final int a;
    public boolean b;
    public long c;
    public int d;
    public int e;
    public final Object f;
    public Object g;

    public h(int v) {
        this.a = v;
        if(v != 3) {
            super();
            this.f = new p(10);
            this.c = 0x8000000000000001L;
            return;
        }
        super();
        this.f = new wb(10);
    }

    public h(List list0, int v) {
        this.a = v;
        if(v != 2) {
            super();
            this.f = list0;
            this.g = new L[list0.size()];
            this.c = 0x8000000000000001L;
            return;
        }
        super();
        this.f = list0;
        this.g = new ie[list0.size()];
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void a() {
        if(this.a != 2) {
            this.b = false;
            return;
        }
        this.b = false;
    }

    @Override  // h4.i
    public void a(p p0) {
        boolean z1;
        boolean z;
        if(this.a != 0) {
            p p1 = (p)this.f;
            b.k(((L)this.g));
            if(this.b) {
                int v = p0.a();
                int v1 = this.e;
                if(v1 < 10) {
                    int v2 = Math.min(v, 10 - v1);
                    System.arraycopy(p0.a, p0.b, p1.a, this.e, v2);
                    if(this.e + v2 == 10) {
                        p1.G(0);
                        if(73 == p1.u() && 68 == p1.u() && 51 == p1.u()) {
                            p1.H(3);
                            this.d = p1.t() + 10;
                            goto label_18;
                        }
                        b.D("Id3Reader", "Discarding invalid ID3 tag");
                        this.b = false;
                        return;
                    }
                }
            label_18:
                int v3 = Math.min(v, this.d - this.e);
                ((L)this.g).d(p0, v3, 0);
                this.e += v3;
            }
            return;
        }
        if(this.b) {
            if(this.d == 2) {
                if(p0.a() == 0) {
                    z = false;
                }
                else {
                    if(p0.u() != 0x20) {
                        this.b = false;
                    }
                    --this.d;
                    z = this.b;
                }
                if(z) {
                    goto label_32;
                }
            }
            else {
            label_32:
                if(this.d == 1) {
                    if(p0.a() == 0) {
                        z1 = false;
                    }
                    else {
                        if(p0.u() != 0) {
                            this.b = false;
                        }
                        --this.d;
                        z1 = this.b;
                    }
                    if(z1) {
                        goto label_41;
                    }
                }
                else {
                label_41:
                    int v4 = p0.b;
                    int v5 = p0.a();
                    L[] arr_l = (L[])this.g;
                    for(int v6 = 0; v6 < arr_l.length; ++v6) {
                        L l0 = arr_l[v6];
                        p0.G(v4);
                        l0.d(p0, v5, 0);
                    }
                    this.e += v5;
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void b() {
        if(this.a != 2) {
            M7.G(((ie)this.g));
            if(this.b) {
                int v = this.d;
                if(v != 0 && this.e == v) {
                    ((ie)this.g).f(this.c, 1, v, 0, null);
                    this.b = false;
                }
            }
            return;
        }
        if(this.b) {
            ie[] arr_ie = (ie[])this.g;
            for(int v1 = 0; v1 < arr_ie.length; ++v1) {
                arr_ie[v1].f(this.c, 1, this.e, 0, null);
            }
            this.b = false;
        }
    }

    @Override  // h4.i
    public void b(boolean z) {
        if(this.a != 0) {
            b.k(((L)this.g));
            if(this.b && (this.d != 0 && this.e == this.d)) {
                b.j(Long.compare(this.c, 0x8000000000000001L) != 0);
                ((L)this.g).c(this.c, 1, this.d, 0, null);
                this.b = false;
            }
            return;
        }
        if(this.b) {
            b.j(Long.compare(this.c, 0x8000000000000001L) != 0);
            L[] arr_l = (L[])this.g;
            for(int v = 0; v < arr_l.length; ++v) {
                arr_l[v].c(this.c, 1, this.e, 0, null);
            }
            this.b = false;
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void c(wb wb0) {
        boolean z1;
        boolean z;
        if(this.a != 2) {
            wb wb1 = (wb)this.f;
            M7.G(((ie)this.g));
            if(this.b) {
                int v1 = wb0.d();
                int v2 = this.e;
                if(v2 < 10) {
                    int v3 = Math.min(v1, 10 - v2);
                    System.arraycopy(wb0.a, wb0.b, wb1.a, this.e, v3);
                    if(this.e + v3 == 10) {
                        wb1.n(0);
                        if(73 == wb1.z() && 68 == wb1.z() && 51 == wb1.z()) {
                            wb1.o(3);
                            this.d = wb1.y() + 10;
                            goto label_19;
                        }
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.b = false;
                        return;
                    }
                }
            label_19:
                int v4 = Math.min(v1, this.d - this.e);
                ((ie)this.g).b(v4, wb0);
                this.e += v4;
            }
            return;
        }
        if(this.b) {
            if(this.d == 2) {
                if(wb0.d() == 0) {
                    z = false;
                }
                else {
                    if(wb0.z() != 0x20) {
                        this.b = false;
                    }
                    --this.d;
                    z = this.b;
                }
                if(z) {
                    goto label_33;
                }
            }
            else {
            label_33:
                if(this.d == 1) {
                    if(wb0.d() == 0) {
                        z1 = false;
                    }
                    else {
                        if(wb0.z() != 0) {
                            this.b = false;
                        }
                        --this.d;
                        z1 = this.b;
                    }
                    if(z1) {
                        goto label_42;
                    }
                }
                else {
                label_42:
                    int v5 = wb0.b;
                    int v6 = wb0.d();
                    ie[] arr_ie = (ie[])this.g;
                    for(int v = 0; v < arr_ie.length; ++v) {
                        ie ie0 = arr_ie[v];
                        wb0.n(v5);
                        ie0.b(v6, wb0);
                    }
                    this.e += v6;
                }
            }
        }
    }

    @Override  // h4.i
    public void d(t t0, G g0) {
        if(this.a != 0) {
            g0.c();
            g0.d();
            L l0 = t0.track(g0.d, 5);
            this.g = l0;
            n n0 = new n();
            g0.d();
            n0.a = g0.e;
            n0.m = "application/id3";
            l0.b(new androidx.media3.common.b(n0));
            return;
        }
        L[] arr_l = (L[])this.g;
        for(int v = 0; v < arr_l.length; ++v) {
            F f0 = (F)((List)this.f).get(v);
            g0.c();
            g0.d();
            L l1 = t0.track(g0.d, 3);
            n n1 = new n();
            g0.d();
            n1.a = g0.e;
            n1.m = "application/dvbsubs";
            n1.p = Collections.singletonList(f0.b);
            n1.d = f0.a;
            l1.b(new androidx.media3.common.b(n1));
            arr_l[v] = l1;
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void e(U5 u50, G g0) {
        if(this.a != 2) {
            g0.a();
            g0.b();
            ie ie0 = u50.i(g0.d, 5);
            this.g = ie0;
            ob ob0 = new ob();
            g0.b();
            ob0.a = g0.e;
            ob0.k = "application/id3";
            ie0.a(new u(ob0));
            return;
        }
        ie[] arr_ie = (ie[])this.g;
        for(int v = 0; v < arr_ie.length; ++v) {
            j1 j10 = (j1)((List)this.f).get(v);
            g0.a();
            g0.b();
            ie ie1 = u50.i(g0.d, 3);
            ob ob1 = new ob();
            g0.b();
            ob1.a = g0.e;
            ob1.k = "application/dvbsubs";
            ob1.m = Collections.singletonList(j10.b);
            ob1.c = j10.a;
            ie1.a(new u(ob1));
            arr_ie[v] = ie1;
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void k(long v, int v1) {
        if(this.a != 2) {
            if((v1 & 4) != 0) {
                this.b = true;
                this.c = v;
                this.d = 0;
                this.e = 0;
            }
            return;
        }
        if((v1 & 4) != 0) {
            this.b = true;
            this.c = v;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override  // h4.i
    public void packetStarted(long v, int v1) {
        if(this.a != 0) {
            if((v1 & 4) != 0) {
                this.b = true;
                this.c = v;
                this.d = 0;
                this.e = 0;
            }
            return;
        }
        if((v1 & 4) != 0) {
            this.b = true;
            this.c = v;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override  // h4.i
    public void seek() {
        if(this.a != 0) {
            this.b = false;
            this.c = 0x8000000000000001L;
            return;
        }
        this.b = false;
        this.c = 0x8000000000000001L;
    }
}

