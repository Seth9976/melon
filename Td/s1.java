package td;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class s1 extends i implements n {
    public Object r;
    public final t1 w;

    public s1(Continuation continuation0, t1 t10) {
        this.w = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s1(continuation0, this.w);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new q1(null, this.w), 3, null);
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new r1(null, this.w), 3, null);
    }
}

