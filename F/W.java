package F;

import G.t0;
import Vc.B;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k0;
import androidx.work.impl.WorkDatabase_Impl;
import d5.n;
import ie.H;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import z4.i;

public final class w implements FlowCollector {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public w(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        FlowCollector flowCollector1;
        i i0;
        if(this.a != 0) {
            if(continuation0 instanceof i) {
                i0 = (i)continuation0;
                int v = i0.w;
                if((v & 0x80000000) == 0) {
                    i0 = new i(this, continuation0);
                }
                else {
                    i0.w = v ^ 0x80000000;
                }
            }
            else {
                i0 = new i(this, continuation0);
            }
            Object object1 = i0.r;
            a a0 = a.a;
            switch(i0.w) {
                case 0: {
                    n.D(object1);
                    FlowCollector flowCollector0 = (FlowCollector)this.b;
                    Set set0 = (Set)object0;
                    i0.B = flowCollector0;
                    i0.w = 1;
                    Object object2 = E9.w.P(((WorkDatabase_Impl)this.c), i0, ((B)this.d), true, false);
                    if(object2 != a0) {
                        object1 = object2;
                        flowCollector1 = flowCollector0;
                        goto label_28;
                    }
                    break;
                }
                case 1: {
                    flowCollector1 = i0.B;
                    n.D(object1);
                label_28:
                    i0.B = null;
                    i0.w = 2;
                    if(flowCollector1.emit(object1, i0) != a0) {
                        return H.a;
                    }
                    break;
                }
                case 2: {
                    n.D(object1);
                    return H.a;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return a0;
        }
        t0 t00 = (t0)this.c;
        boolean z = ((Boolean)object0).booleanValue() ? ((Boolean)((we.n)((b0)this.d).getValue()).invoke(t00.c(), ((O0)t00.d).getValue())).booleanValue() : false;
        ((k0)this.b).setValue(Boolean.valueOf(z));
        return H.a;
    }
}

