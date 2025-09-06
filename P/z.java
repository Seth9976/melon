package P;

import d5.l;
import d5.m;
import e3.o;
import e3.p;
import ea.b;
import ea.d;
import h4.D;
import h4.H;
import h4.f;
import h4.g;
import h4.h;
import h4.k;
import h4.n;
import h4.q;
import h4.s;
import h4.t;
import h4.v;
import h4.y;
import i.n.i.b.a.s.e.F2;
import i.n.i.b.a.s.e.La;
import i.n.i.b.a.s.e.M8;
import i.n.i.b.a.s.e.Qd;
import i.n.i.b.a.s.e.V7;
import i.n.i.b.a.s.e.W;
import i.n.i.b.a.s.e.X5;
import i.n.i.b.a.s.e.Y3;
import i.n.i.b.a.s.e.b9;
import i.n.i.b.a.s.e.k1;
import i.n.i.b.a.s.e.n5;
import i.n.i.b.a.s.e.ob;
import i.n.i.b.a.s.e.sa;
import i.n.i.b.a.s.e.u;
import i.n.i.b.a.s.e.wb;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class z {
    public int a;
    public List b;

    public z(int v, List list0) {
        this.a = v;
        this.b = list0;
        super();
    }

    public k1 a(int v, sa sa0) {
        String s = (String)sa0.b;
        switch(v) {
            case 2: {
                return new La(new n5(new b(this.c(sa0))));
            }
            case 3: 
            case 4: {
                return new La(new M8(s));
            }
            case 15: {
                if(!this.b(2)) {
                    return new La(new F2(false, s));
                }
                break;
            }
            case 16: {
                return new La(new X5(new b(this.c(sa0))));
            }
            case 17: {
                if(!this.b(2)) {
                    return new La(new V7(s));
                }
                break;
            }
            case 21: {
                return new La(new h(3));
            }
            case 27: {
                if(!this.b(4)) {
                    return new La(new q(new d(this.c(sa0)), this.b(1), this.b(8)));
                }
                break;
            }
            case 36: {
                return new La(new s(new d(this.c(sa0))));
            }
            case 89: {
                return new La(new h(((List)sa0.c), 2));
            }
            case 130: {
                return !this.b(0x40) ? null : new La(new Y3(s));
            }
            case 0x86: {
                if(!this.b(16)) {
                    return new Qd(new sa("application/x-scte35"));
                }
                break;
            }
            case 0x81: 
            case 0x87: {
                return new La(new W(s, 0));
            }
            case 0x8A: {
                return new La(new Y3(s));
            }
            case 0xAC: {
                return new La(new W(s, 1));
            }
            case 0x101: {
                return new Qd(new sa("application/vnd.dvb.ait"));
            }
            default: {
                return null;
            }
        }
        return null;
    }

    public boolean b(int v) {
        return (v & this.a) != 0;
    }

    public List c(sa sa0) {
        String s1;
        int v6;
        List list0 = this.b;
        if(this.b(0x20)) {
            return list0;
        }
        wb wb0 = new wb(((byte[])sa0.d));
        while(wb0.d() > 0) {
            int v = wb0.z();
            int v1 = wb0.z();
            int v2 = wb0.b + v1;
            if(v == 0x86) {
                ArrayList arrayList0 = new ArrayList();
                int v3 = wb0.z();
                for(int v4 = 0; v4 < (v3 & 0x1F); ++v4) {
                    String s = wb0.g(3, b9.c);
                    int v5 = wb0.z();
                    boolean z = (v5 & 0x80) != 0;
                    if(z) {
                        v6 = v5 & 0x3F;
                        s1 = "application/cea-708";
                    }
                    else {
                        s1 = "application/cea-608";
                        v6 = 1;
                    }
                    int v7 = (byte)wb0.z();
                    wb0.o(1);
                    List list1 = z ? Collections.singletonList(((v7 & 0x40) == 0 ? new byte[]{0} : new byte[]{1})) : null;
                    ob ob0 = new ob();
                    ob0.k = s1;
                    ob0.c = s;
                    ob0.C = v6;
                    ob0.m = list1;
                    arrayList0.add(new u(ob0));
                }
                list0 = arrayList0;
            }
            wb0.n(v2);
        }
        return list0;
    }

    public H d(int v, o o0) {
        String s = (String)o0.d;
        switch(v) {
            case 3: 
            case 4: {
                return new y(new h4.u(s, o0.e()));
            }
            case 15: {
                if(!this.f(2)) {
                    return new y(new f(false, s, o0.e()));
                }
                break;
            }
            case 16: {
                return new y(new n(new l(this.e(o0))));
            }
            case 17: {
                if(!this.f(2)) {
                    return new y(new t(s, o0.e()));
                }
                break;
            }
            case 21: {
                return new y(new h(1));
            }
            case 27: {
                if(!this.f(4)) {
                    return new y(new q(new y8.s(this.e(o0)), this.f(1), this.f(8)));
                }
                break;
            }
            case 36: {
                return new y(new s(new y8.s(this.e(o0))));
            }
            case 45: {
                return new y(new v());
            }
            case 89: {
                return new y(new h(((List)o0.e), 0));
            }
            case 2: 
            case 0x80: {
                return new y(new k(new l(this.e(o0))));
            }
            case 130: {
                return !this.f(0x40) ? null : new y(new g(s, o0.e(), 0x1000));
            }
            case 0x86: {
                if(!this.f(16)) {
                    return new D(new m("application/x-scte35", 13));
                }
                break;
            }
            case 0x81: 
            case 0x87: {
                return new y(new h4.b(s, o0.e(), 0));
            }
            case 0x88: 
            case 0x8A: {
                return new y(new g(s, o0.e(), 0x1000));
            }
            case 0x8B: {
                return new y(new g(s, o0.e(), 5408));
            }
            case 0xAC: {
                return new y(new h4.b(s, o0.e(), 1));
            }
            case 0x101: {
                return new D(new m("application/vnd.dvb.ait", 13));
            }
            default: {
                return null;
            }
        }
        return null;
    }

    public List e(o o0) {
        String s1;
        int v6;
        List list0 = this.b;
        if(this.f(0x20)) {
            return list0;
        }
        p p0 = new p(((byte[])o0.b));
        while(p0.a() > 0) {
            int v = p0.u();
            int v1 = p0.u();
            int v2 = p0.b + v1;
            if(v == 0x86) {
                ArrayList arrayList0 = new ArrayList();
                int v3 = p0.u();
                for(int v4 = 0; v4 < (v3 & 0x1F); ++v4) {
                    String s = p0.s(3, StandardCharsets.UTF_8);
                    int v5 = p0.u();
                    boolean z = (v5 & 0x80) != 0;
                    if(z) {
                        v6 = v5 & 0x3F;
                        s1 = "application/cea-708";
                    }
                    else {
                        s1 = "application/cea-608";
                        v6 = 1;
                    }
                    int v7 = (byte)p0.u();
                    p0.H(1);
                    List list1 = z ? Collections.singletonList(((v7 & 0x40) == 0 ? new byte[]{1} : new byte[]{0})) : null;
                    b3.n n0 = new b3.n();
                    n0.m = b3.H.l(s1);
                    n0.d = s;
                    n0.G = v6;
                    n0.p = list1;
                    arrayList0.add(new androidx.media3.common.b(n0));
                }
                list0 = arrayList0;
            }
            p0.G(v2);
        }
        return list0;
    }

    public boolean f(int v) {
        return (v & this.a) != 0;
    }
}

