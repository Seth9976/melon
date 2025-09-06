package xc;

import Jc.B;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.K4;
import com.melon.ui.o1;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import ie.H;
import we.n;
import yc.a;
import yc.b;
import yc.i;
import zd.O;
import zd.P;
import zd.Q;
import zd.c0;
import zd.v;

public final class q implements n {
    public final int a;
    public final Object b;
    public final Object c;

    public q(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    public q(o1 o10, B b0, int v, int v1) {
        this.a = v1;
        this.c = o10;
        this.b = b0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        V v0 = k.a;
        H h0 = H.a;
        Object object2 = this.b;
        Object object3 = this.c;
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                ((s)object3).v(((B)object2), ((l)object0), 1);
                return h0;
            }
            case 1: {
                ((Integer)object1).getClass();
                ((z)object3).t(((B)object2), ((l)object0), 1);
                return h0;
            }
            case 2: {
                ((Integer)object1).getClass();
                ((xc.H)object3).u(((B)object2), ((l)object0), 1);
                return h0;
            }
            case 3: {
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(1 & v2, (v2 & 3) != 2)) {
                    boolean z2 = ((p)(((l)object0))).i(((b)object2));
                    a a3 = ((p)(((l)object0))).N();
                    if(z2 || a3 == v0) {
                        a a4 = new a(1, ((b)object2), b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 3);
                        ((p)(((l)object0))).l0(a4);
                        a3 = a4;
                    }
                    i.d(((K4)object3), a3, ((p)(((l)object0))), 0);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 4: {
                int v3 = (int)(((Integer)object0));
                kotlin.jvm.internal.q.g(((SongInfoBase)object1), "songInfoBase");
                ((K0)object3).n(v3);
                if(((we.k)object2) != null) {
                    ((we.k)object2).invoke(new yc.n(v3, ((SongInfoBase)object1), true));
                }
                return h0;
            }
            default: {
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(1 & v1, (v1 & 3) != 2)) {
                    K4 k40 = (K4)B.a.r(((c0)((MelonBottomSheetComposeDialogFragment)object3).getViewModel()).l, ((p)(((l)object0))), 0).getValue();
                    Q q0 = ((c0)((MelonBottomSheetComposeDialogFragment)object3).getViewModel()).i;
                    if(q0 != null) {
                        boolean z = ((p)(((l)object0))).i(((MelonBottomSheetComposeDialogFragment)object3));
                        a a0 = ((p)(((l)object0))).N();
                        if(z || a0 == v0) {
                            a a1 = new a(1, ((MelonBottomSheetComposeDialogFragment)object3), MelonBottomSheetComposeDialogFragment.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9);
                            ((p)(((l)object0))).l0(a1);
                            a0 = a1;
                        }
                        boolean z1 = ((p)(((l)object0))).i(((MelonBottomSheetComposeDialogFragment)object3));
                        a a2 = ((p)(((l)object0))).N();
                        if(z1 || a2 == v0) {
                            a2 = new a(1, ((MelonBottomSheetComposeDialogFragment)object3), MelonBottomSheetComposeDialogFragment.class, "updateContentHeight", "updateContentHeight(I)V", 0, 10);
                            ((p)(((l)object0))).l0(a2);
                        }
                        v.b(q0, ((O)(((P)object2))), k40, a0, a2, ((MelonBottomSheetComposeDialogFragment)object3).d, ((MelonBottomSheetComposeDialogFragment)object3).r, ((p)(((l)object0))), 0);
                        return h0;
                    }
                }
                else {
                    ((p)(((l)object0))).T();
                }
                return h0;
            }
        }
    }
}

