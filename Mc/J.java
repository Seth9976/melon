package Mc;

import Cc.c1;
import Cc.e0;
import E9.h;
import Nc.H0;
import Nc.Q0;
import Nc.k1;
import O.F;
import O.I;
import Oc.a;
import Oc.b;
import Oc.c;
import Oc.d;
import Q0.C0;
import Q0.N;
import Vc.Z;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.custom.l1;
import com.melon.ui.K4;
import com.melon.ui.playermusic.BgType.SpecialImage;
import gd.r6;
import ie.H;
import ie.f;
import r0.q;
import we.k;
import we.n;

public final class j implements n {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final Object d;
    public final Object e;

    public j(K4 k40, m m0, boolean z, boolean z1) {
        this.a = 0;
        super();
        this.d = k40;
        this.e = m0;
        this.b = z;
        this.c = z1;
    }

    public j(q q0, K4 k40, boolean z, boolean z1, int v, int v1) {
        this.a = v1;
        this.d = q0;
        this.e = k40;
        this.b = z;
        this.c = z1;
        super();
    }

    public j(boolean z, boolean z1, Object object0, f f0, int v, int v1) {
        this.a = v1;
        this.b = z;
        this.c = z1;
        this.d = object0;
        this.e = f0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                K4 k40 = (K4)this.d;
                m m0 = (m)this.e;
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    d d0 = k40 instanceof d ? ((d)k40) : null;
                    if(d0 == null) {
                        ((p)(((l)object0))).a0(0x4B66198E);
                    }
                    else {
                        ((p)(((l)object0))).a0(0x4B66198F);
                        if(d0 instanceof a) {
                            ((p)(((l)object0))).a0(-2049147408);
                            e0.v(((a)d0).a, ((p)(((l)object0))), 0);
                            ((p)(((l)object0))).p(false);
                            ((p)(((l)object0))).p(false);
                            return H.a;
                        }
                        if(d0 instanceof b) {
                            ((p)(((l)object0))).a0(0x85DF6BA1);
                            we.a a0 = m0.getDefaultNetworkErrorHandle().a();
                            we.a a1 = m0.getDefaultNetworkErrorHandle().b();
                            c1.w(((b)d0).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                            ((p)(((l)object0))).p(false);
                        }
                        else if(d0 instanceof c) {
                            ((p)(((l)object0))).a0(-2048489030);
                            F f0 = I.a(0, 0, 3, ((p)(((l)object0))));
                            C0 c00 = N.u(((p)(((l)object0))));
                            m0.n(androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c, c00, null), ((c)d0), f0, this.b, this.c, ((p)(((l)object0))), 0);
                            ((p)(((l)object0))).p(false);
                        }
                        else {
                            throw l1.c(((p)(((l)object0))), 0xD2C504CE, false);
                        }
                    }
                    ((p)(((l)object0))).p(false);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                De.I.a(((q)this.d), ((H0)this.e), this.b, this.c, ((l)object0), 7);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                h.f(((q)this.d), ((Q0)this.e), this.b, this.c, ((l)object0), 7);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                U4.F.c(((q)this.d), ((k1)this.e), this.b, this.c, ((l)object0), 7);
                return H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                Z.b(this.b, this.c, ((we.a)this.d), ((we.a)this.e), ((l)object0), 1);
                return H.a;
            }
            case 5: {
                ((Integer)object1).getClass();
                e1.b.f(this.b, this.c, ((r6)this.d), ((k)this.e), ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                com.melon.ui.playermusic.l.b(this.b, this.c, ((SpecialImage)this.d), ((k)this.e), ((l)object0), 0xD81);
                return H.a;
            }
        }
    }
}

