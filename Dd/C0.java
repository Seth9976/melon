package Dd;

import Ac.N3;
import Ac.O2;
import Ac.Q2;
import Ac.p1;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class c0 extends i implements n {
    public Object r;
    public final g0 w;

    public c0(g0 g00, Continuation continuation0) {
        this.w = g00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c0)this.create(((Q2)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Q2 q20 = (Q2)this.r;
        d5.n.D(object0);
        g0 g00 = this.w;
        LogU.debug$default(g00.k, "listComment: " + q20, null, false, 6, null);
        if(q20 != null) {
            O1 o10 = ((g1)g00.getViewModel()).h();
            ArrayList arrayList0 = null;
            List list0 = o10 == null ? null : o10.a;
            if(list0 != null) {
                arrayList0 = new ArrayList();
                for(Object object1: list0) {
                    K4 k40 = (K4)object1;
                    if(!(k40 instanceof N3) && !(k40 instanceof O2) && !(k40 instanceof p1)) {
                        arrayList0.add(object1);
                    }
                }
            }
            int v = -1;
            ((g1)g00.getViewModel()).getClass();
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                int v1 = k.s(arrayList0);
                int v2 = 0;
                int v3 = 0;
                Iterator iterator1 = arrayList0.iterator();
                while(true) {
                    if(!iterator1.hasNext()) {
                        v3 = -1;
                        break;
                    }
                    Object object2 = iterator1.next();
                    if(((K4)object2) instanceof O0) {
                        break;
                    }
                    ++v3;
                }
                if(v3 > 0) {
                    for(Object object3: arrayList0) {
                        if(((K4)object3) instanceof O0) {
                            v = v2;
                            break;
                        }
                        ++v2;
                    }
                }
                else {
                    v = v1;
                }
            }
            g1 g10 = (g1)g00.getViewModel();
            String s = g00.getString(0x7F13089A);  // string:profile_comment "DJ에게 한마디"
            q.f(s, "getString(...)");
            g10.getClass();
            List list1 = g10.k.a(q20.a, v, s, q20.b, arrayList0);
            g1 g11 = (g1)g00.getViewModel();
            if(g11.h() != null && list1 != null && !((ArrayList)list1).isEmpty()) {
                g11.updateUiState(new J(5, g11, list1));
            }
        }
        return H.a;
    }
}

