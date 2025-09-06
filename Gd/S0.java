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

public final class s0 implements FlowCollector {
    public final u0 a;
    public final String b;

    public s0(u0 u00, String s) {
        this.a = u00;
        this.b = s;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((e)object0) instanceof b) {
            j.b(((b)(((e)object0))).a, false, 3);
            return H.a;
        }
        u0 u00 = this.a;
        if(((e)object0) instanceof c) {
            u00.sendUiEvent(s4.a);
            return H.a;
        }
        if(!(((e)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(u00.getUiState().getValue() instanceof l0) {
            Object object1 = u00.getUiState().getValue();
            q.e(object1, "null cannot be cast to non-null type com.melon.ui.melondj.MelonDjBrandLikePersonListUiState.Success");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((l0)object1).a));
            for(Object object2: ((l0)object1).a) {
                e0 e00 = (e0)object2;
                if(e00 instanceof c0 && q.b(((c0)e00).a, this.b)) {
                    e00 = c0.a(((c0)e00), ((d)(((e)object0))).a);
                }
                arrayList0.add(e00);
            }
            u00.updateUiState(new b0(15, arrayList0));
        }
        return H.a;
    }
}

