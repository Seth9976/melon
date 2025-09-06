package Cc;

import Hd.T;
import Hd.h;
import O.F;
import Vc.i;
import Vc.j;
import androidx.compose.runtime.l;
import com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment;
import de.c;
import ie.H;
import java.util.List;
import jd.x2;
import kd.G;
import kotlinx.coroutines.flow.StateFlow;
import r0.q;
import sd.o;
import we.a;
import we.k;
import we.n;
import y0.Q;

public final class t0 implements n {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public t0(T t0, q q0, h h0, List list0, F f0, int v) {
        this.a = 1;
        super();
        this.c = t0;
        this.b = q0;
        this.d = h0;
        this.e = list0;
        this.f = f0;
    }

    public t0(DrawerBtmSheetFragment drawerBtmSheetFragment0, List list0, String s, k k0, k k1, int v) {
        this.a = 3;
        super();
        this.d = drawerBtmSheetFragment0;
        this.e = list0;
        this.c = s;
        this.b = k0;
        this.f = k1;
    }

    public t0(Object object0, Object object1, Object object2, Object object3, Object object4, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.e = object2;
        this.b = object3;
        this.f = object4;
        super();
    }

    public t0(String s, String s1, List list0, String s2, a a0, int v) {
        this.a = 6;
        super();
        this.c = s;
        this.d = s1;
        this.b = list0;
        this.e = s2;
        this.f = a0;
    }

    public t0(x2 x20, String s, String s1, a a0, k k0, int v) {
        this.a = 4;
        super();
        this.e = x20;
        this.c = s;
        this.d = s1;
        this.f = a0;
        this.b = k0;
    }

    public t0(q q0, String s, String s1, String s2, Q q1, int v) {
        this.a = 5;
        super();
        this.b = q0;
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = q1;
    }

    public t0(a a0, a a1, a a2, a a3, a a4, int v) {
        this.a = 7;
        super();
        this.f = a0;
        this.c = a1;
        this.d = a2;
        this.e = a3;
        this.b = a4;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        Object object2 = this.b;
        Object object3 = this.e;
        Object object4 = this.d;
        Object object5 = this.c;
        Object object6 = this.f;
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                e0.p(((String)object5), ((String)object4), ((String)object3), ((q)object2), ((a)object6), ((l)object0), 1);
                return h0;
            }
            case 1: {
                ((Integer)object1).getClass();
                ((T)object5).o(((q)object2), ((h)object4), ((List)object3), ((F)object6), ((l)object0), 7);
                return h0;
            }
            case 2: {
                ((Integer)object1).getClass();
                i.b(((j)object5), ((StateFlow)object4), ((StateFlow)object3), ((StateFlow)object2), ((StateFlow)object6), ((l)object0), 1);
                return h0;
            }
            case 3: {
                ((Integer)object1).getClass();
                ((DrawerBtmSheetFragment)object4).n(((List)object3), ((String)object5), ((k)object2), ((k)object6), ((l)object0), 1);
                return h0;
            }
            case 4: {
                ((Integer)object1).getClass();
                G.i(((x2)object3), ((String)object5), ((String)object4), ((a)object6), ((k)object2), ((l)object0), 1);
                return h0;
            }
            case 5: {
                ((Integer)object1).getClass();
                o.f(((q)object2), ((String)object5), ((String)object4), ((String)object3), ((Q)object6), ((l)object0), 1);
                return h0;
            }
            case 6: {
                ((Integer)object1).getClass();
                e1.G.a(((String)object5), ((String)object4), ((List)object2), ((String)object3), ((a)object6), ((l)object0), 1);
                return h0;
            }
            default: {
                ((Integer)object1).getClass();
                c.h(((a)object6), ((a)object5), ((a)object4), ((a)object3), ((a)object2), ((l)object0), 1);
                return h0;
            }
        }
    }
}

