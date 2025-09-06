package gd;

import Pc.e;
import com.melon.ui.k1;
import dd.z;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class k6 extends i implements n {
    public final n6 r;
    public final e w;

    public k6(n6 n60, e e0, Continuation continuation0) {
        this.r = n60;
        this.w = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k6(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k6)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        n6 n60 = this.r;
        int v = n60.h;
        int v1 = ((i6)this.w).a;
        if(v != v1) {
            n60.h = v1;
            if(n60.getUiState().getValue() instanceof c6) {
                Object object1 = n60.getUiState().getValue();
                q.e(object1, "null cannot be cast to non-null type com.melon.ui.melondj.MelonDjTagHubBottomUiState.Success");
                c6 c60 = (c6)object1;
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(new W5(n60.h, ((List)n60.k.getValue())));
                n60.updateUiState(new z(new c6(arrayList0), 24));
            }
            k1.startFetch$default(n60, true, null, null, 6, null);
        }
        return H.a;
    }
}

