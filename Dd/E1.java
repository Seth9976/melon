package Dd;

import Ac.O2;
import Ac.R3;
import Ac.V3;
import Ac.g2;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.k1;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.JobKt;
import oe.i;
import we.n;

public final class e1 extends i implements n {
    public Object r;
    public final g1 w;

    public e1(g1 g10, Continuation continuation0) {
        this.w = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e1(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1 = this.r;
        d5.n.D(object0);
        JobKt.ensureActive(this.getContext());
        g1 g10 = this.w;
        LogU.debug$default(g10.q, "CommentUpdateAction onEvent: " + ((V3)object1), null, false, 6, null);
        int v = ((V3)object1).a();
        g2 g20 = g10.k;
        if(v != g20.b() || !q.b(((V3)object1).b(), g20.d())) {
            LogU.debug$default(g10.q, "Event does not match current channel or content ref value, ignoring.", null, false, 6, null);
        }
        else {
            if(((V3)object1) instanceof R3) {
                k1.startFetch$default(g10, true, null, null, 6, null);
                return H.a;
            }
            O1 o10 = g10.h();
            if(o10 != null) {
                List list0 = g20.c(o10.a, ((V3)object1));
                ArrayList arrayList0 = new ArrayList();
                for(Object object2: list0) {
                    if(object2 instanceof O2) {
                        arrayList0.add(object2);
                    }
                }
                g20.k(arrayList0);
                g10.updateUiState(new E(o10, list0, 1));
                return H.a;
            }
        }
        return H.a;
    }
}

