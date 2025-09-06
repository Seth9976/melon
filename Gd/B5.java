package gd;

import Ac.b0;
import Cb.j;
import com.melon.ui.s4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import lb.b;
import lb.c;
import lb.d;
import lb.e;

public final class b5 implements FlowCollector {
    public final d5 a;
    public final String b;

    public b5(d5 d50, String s) {
        this.a = d50;
        this.b = s;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((e)object0) instanceof b) {
            j.b(((b)(((e)object0))).a, false, 3);
            return H.a;
        }
        d5 d50 = this.a;
        if(((e)object0) instanceof c) {
            d50.sendUiEvent(s4.a);
            return H.a;
        }
        if(!(((e)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(d50.getUiState().getValue() instanceof O4) {
            Object object1 = d50.getUiState().getValue();
            q.e(object1, "null cannot be cast to non-null type com.melon.ui.melondj.MelonDjPowerDjUiState.Success");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((O4)object1).a));
            for(Object object2: ((O4)object1).a) {
                L4 l40 = (L4)object2;
                if(l40 instanceof J4 && q.b(((J4)l40).a, this.b)) {
                    l40 = J4.a(((J4)l40), ((d)(((e)object0))).a);
                }
                arrayList0.add(l40);
            }
            d50.updateUiState(new b0(21, arrayList0));
        }
        return H.a;
    }
}

