package R;

import P0.j0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final j0 B;
    public final G.g D;
    public final I.i E;
    public Object r;
    public final h w;

    public g(h h0, j0 j00, G.g g0, I.i i0, Continuation continuation0) {
        this.w = h0;
        this.B = j00;
        this.D = g0;
        this.E = i0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g(this.w, this.B, this.D, this.E, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new e(this.w, this.B, this.D, null), 3, null);
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new f(this.w, this.E, null), 3, null);
    }
}

