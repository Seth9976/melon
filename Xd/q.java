package xd;

import Cb.j;
import Na.d;
import Na.e;
import Na.f;
import com.melon.ui.U0;
import com.melon.ui.c3;
import gd.u7;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import qb.a;
import qb.b;
import qb.c;
import vd.G;

public final class q implements FlowCollector {
    public final r a;

    public q(r r0) {
        this.a = r0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        r r0 = this.a;
        if(((f)object0) instanceof e) {
            Object object1 = ((e)(((f)object0))).a;
            if(object1 instanceof b) {
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((b)object1).e));
                for(Object object2: ((b)object1).e) {
                    arrayList0.add(new xd.f(r0.c, ((a)object2).b, ((a)object2).c, ((a)object2).d, ((a)object2).e, ((a)object2).f, ((a)object2).g));
                }
                i i0 = arrayList0.isEmpty() ? new i(new U0(null, null, 0x1F)) : new k(arrayList0);
                r0.updateUiState(new G(i0, 9));
                return H.a;
            }
            if(!(object1 instanceof c)) {
                return H.a;
            }
            j.b(((c)object1).e, false, 3);
            return H.a;
        }
        if(!(((f)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        r0.updateUiState(new u7(new c3(null, 0, false, null, 15), 1));
        return H.a;
    }
}

