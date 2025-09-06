package ud;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class y0 extends i implements n {
    public final R0 B;
    public Object r;
    public final CoroutineScope w;

    public y0(CoroutineScope coroutineScope0, R0 r00, Continuation continuation0) {
        this.w = coroutineScope0;
        this.B = r00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((y0)this.create(((String)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s = (String)this.r;
        d5.n.D(object0);
        w0 w00 = new w0(this.B, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.w, null, null, w00, 3, null);
        x0 x00 = new x0(this.B, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.w, null, null, x00, 3, null);
        return H.a;
    }
}

