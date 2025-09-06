package jc;

import com.iloen.melon.utils.log.LogConstantsKt;
import hd.h0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.SupervisorKt;
import oe.i;
import we.n;

public final class a extends i implements n {
    public boolean r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((a)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        if(!z) {
            LogConstantsKt.debugOnlyDebugMode(j.b, "stop()");
            CoroutineScope coroutineScope1 = j.f;
            if(coroutineScope1 != null) {
                CoroutineScopeKt.cancel$default(coroutineScope1, "stop()", null, 2, null);
            }
        }
        else if(j.f == null) {
            LogConstantsKt.infoOnlyDebugMode(j.b, "start()");
            CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
            DefaultImpls.invokeOnCompletion$default(BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new jc.i(coroutineScope0, null), 3, null), true, false, new h0(10), 2, null);
            j.f = coroutineScope0;
            return H.a;
        }
        return H.a;
    }
}

