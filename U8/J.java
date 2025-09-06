package U8;

import O.F;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final F B;
    public final b0 r;
    public final CoroutineScope w;

    public j(b0 b00, CoroutineScope coroutineScope0, F f0, Continuation continuation0) {
        this.r = b00;
        this.w = coroutineScope0;
        this.B = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        b0 b00 = this.r;
        if(((Number)b00.getValue()).intValue() > -1) {
            U8.i i0 = new U8.i(this.B, b00, null);
            BuildersKt__Builders_commonKt.launch$default(this.w, null, null, i0, 3, null);
        }
        return H.a;
    }
}

