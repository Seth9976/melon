package gd;

import Ac.b0;
import Cb.j;
import bb.f;
import bb.h;
import bb.k;
import bb.l;
import bb.n;
import bb.o;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.s4;
import com.melon.ui.t4;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;

public final class t0 implements FlowCollector {
    public final u0 a;

    public t0(u0 u00) {
        this.a = u00;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        u0 u00 = this.a;
        if(((o)object0) instanceof k) {
            u00.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            if(u00.getUiState().getValue() instanceof l0) {
                Object object1 = u00.getUiState().getValue();
                q.e(object1, "null cannot be cast to non-null type com.melon.ui.melondj.MelonDjBrandLikePersonListUiState.Success");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((l0)object1).a));
                for(Object object2: ((l0)object1).a) {
                    e0 e00 = (e0)object2;
                    if(e00 instanceof c0 && q.b(((c0)e00).a, "-1")) {
                        e00 = c0.a(((c0)e00), ((n)(((o)object0))).b);
                    }
                    arrayList0.add(e00);
                }
                u00.updateUiState(new b0(16, arrayList0));
                return H.a;
            }
        }
        else if(!(((o)object0) instanceof bb.j)) {
            if(((o)object0) instanceof f) {
                String s = ((f)(((o)object0))).a.getMessage();
                if(s != null) {
                    LogU.error$default(u00.f, s, null, false, 6, null);
                    u00.sendUiEvent(new t4(s));
                    return H.a;
                }
            }
            else if(((o)object0) instanceof l) {
                u00.sendUiEvent(new t4(u00.e.a(((l)(((o)object0))).a)));
            }
        }
        return H.a;
    }
}

