package Cc;

import Bb.c;
import E9.w;
import Nc.s0;
import Nc.t0;
import Rc.K;
import Rc.O;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.GRAPHINFO;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.LIKETOPINFO;
import d8.d;
import ie.H;
import ie.f;
import java.io.Serializable;
import java.util.List;
import qd.I;
import qd.J;
import qd.h;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class z2 implements n {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;

    public z2(int v, int v1, Object object0, Object object1, boolean z) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = z;
        super();
    }

    public z2(Serializable serializable0, boolean z, k k0, int v) {
        this.a = v;
        this.c = serializable0;
        this.b = z;
        this.d = k0;
        super();
    }

    public z2(Object object0, boolean z, f f0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = z;
        this.d = f0;
        super();
    }

    public z2(String s, boolean z, q q0, int v) {
        this.a = 1;
        super();
        this.d = s;
        this.b = z;
        this.c = q0;
    }

    public z2(boolean z, c c0, a a0, int v) {
        this.a = 3;
        super();
        this.b = z;
        this.c = c0;
        this.d = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                c1.z(1, ((l)object0), ((q)this.c), ((a)this.d), this.b);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                w3.c(((String)this.d), this.b, ((q)this.c), ((l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                d5.f.a(((String)this.c), this.b, ((k)this.d), ((l)object0), 1);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                w.f(this.b, ((c)this.c), ((a)this.d), ((l)object0), 1);
                return H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                a.a.c(7, ((l)object0), ((q)this.c), ((k)this.d), this.b);
                return H.a;
            }
            case 5: {
                ((Integer)object1).getClass();
                s0.a(((q)this.c), ((t0)this.d), this.b, ((l)object0), 1);
                return H.a;
            }
            case 6: {
                ((Integer)object1).getClass();
                K.e(((O)this.c), this.b, ((k)this.d), ((l)object0), 49);
                return H.a;
            }
            case 7: {
                GRAPHINFO musicDnaMainMonthlyLogRes$RESPONSE$GRAPHINFO0 = (GRAPHINFO)this.c;
                k k0 = (k)this.d;
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    hd.H.c(musicDnaMainMonthlyLogRes$RESPONSE$GRAPHINFO0, this.b, k0, null, ((p)(((l)object0))), 0x6180);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 8: {
                LIKETOPINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO0 = (LIKETOPINFO)this.c;
                k k1 = (k)this.d;
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    hd.H.e(musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO0, this.b, false, k1, null, ((p)(((l)object0))), 0x6180, 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 9: {
                ((Integer)object1).getClass();
                h.d(((q)this.c), ((List)this.d), this.b, ((l)object0), 1);
                return H.a;
            }
            case 10: {
                ((Integer)object1).getClass();
                I.d(((String)this.c), ((J)this.d), this.b, ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                d.k(((ShortCutItem)this.c), this.b, ((k)this.d), ((l)object0), 1);
                return H.a;
            }
        }
    }
}

