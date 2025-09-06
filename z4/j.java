package z4;

import F.w;
import Vc.B;
import androidx.work.impl.WorkDatabase_Impl;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;

public final class j implements Flow {
    public final Flow a;
    public final WorkDatabase_Impl b;
    public final B c;

    public j(Flow flow0, WorkDatabase_Impl workDatabase_Impl0, B b0) {
        this.a = flow0;
        this.b = workDatabase_Impl0;
        this.c = b0;
    }

    @Override  // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector0, Continuation continuation0) {
        w w0 = new w(flowCollector0, this.b, this.c, 1);
        Object object0 = this.a.collect(w0, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

