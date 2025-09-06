package U;

import J0.y;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import oe.i;
import we.n;

public final class k0 extends i implements n {
    public final t0 B;
    public Object r;
    public final y w;

    public k0(y y0, t0 t00, Continuation continuation0) {
        this.w = y0;
        this.B = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        i0 i00 = new i0(this.w, this.B, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, CoroutineStart.UNDISPATCHED, i00, 1, null);
        j0 j00 = new j0(this.w, this.B, null);
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, CoroutineStart.UNDISPATCHED, j00, 1, null);
    }
}

