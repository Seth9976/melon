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

public final class c5 implements FlowCollector {
    public final d5 a;

    public c5(d5 d50) {
        this.a = d50;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        d5 d50 = this.a;
        if(((o)object0) instanceof k) {
            d50.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            if(d50.getUiState().getValue() instanceof O4) {
                Object object1 = d50.getUiState().getValue();
                q.e(object1, "null cannot be cast to non-null type com.melon.ui.melondj.MelonDjPowerDjUiState.Success");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((O4)object1).a));
                for(Object object2: ((O4)object1).a) {
                    L4 l40 = (L4)object2;
                    if(l40 instanceof J4 && q.b(((J4)l40).a, "-1")) {
                        l40 = J4.a(((J4)l40), ((n)(((o)object0))).b);
                    }
                    arrayList0.add(l40);
                }
                d50.updateUiState(new b0(22, arrayList0));
                return H.a;
            }
        }
        else if(!(((o)object0) instanceof bb.j)) {
            if(((o)object0) instanceof f) {
                String s = ((f)(((o)object0))).a.getMessage();
                if(s != null) {
                    LogU.error$default(d50.i, s, null, false, 6, null);
                    d50.sendUiEvent(new t4(s));
                    return H.a;
                }
            }
            else if(((o)object0) instanceof l) {
                d50.sendUiEvent(new t4(d50.b.a(((l)(((o)object0))).a)));
            }
        }
        return H.a;
    }
}

