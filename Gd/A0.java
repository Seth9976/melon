package gd;

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

public final class a0 implements FlowCollector {
    public final b0 a;

    public a0(b0 b00) {
        this.a = b00;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        b0 b00 = this.a;
        if(((o)object0) instanceof k) {
            b00.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            if(b00.getUiState().getValue() instanceof S) {
                Object object1 = b00.getUiState().getValue();
                q.e(object1, "null cannot be cast to non-null type com.melon.ui.melondj.MelonDjBrandFollowerListUiState.Success");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((S)object1).a));
                for(Object object2: ((S)object1).a) {
                    J j0 = (J)object2;
                    if(j0 instanceof gd.H && q.b(((gd.H)j0).a, "-1")) {
                        j0 = gd.H.a(((gd.H)j0), ((n)(((o)object0))).b);
                    }
                    arrayList0.add(j0);
                }
                b00.updateUiState(new Ac.b0(14, arrayList0));
                return H.a;
            }
        }
        else if(!(((o)object0) instanceof bb.j)) {
            if(((o)object0) instanceof f) {
                String s = ((f)(((o)object0))).a.getMessage();
                if(s != null) {
                    LogU.error$default(b00.f, s, null, false, 6, null);
                    b00.sendUiEvent(new t4(s));
                    return H.a;
                }
            }
            else if(((o)object0) instanceof l) {
                b00.sendUiEvent(new t4(b00.e.a(((l)(((o)object0))).a)));
            }
        }
        return H.a;
    }
}

