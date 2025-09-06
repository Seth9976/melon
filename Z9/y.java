package z9;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class y extends i implements n {
    public Object r;
    public final String w;

    public y(String s, Continuation continuation0) {
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new w(this.w, null), 3, null);
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new x(this.w, null), 3, null);
    }
}

