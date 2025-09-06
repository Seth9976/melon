package D4;

import androidx.room.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import we.k;
import we.n;

public final class i extends oe.i implements n {
    public final k B;
    public int r;
    public final H w;

    public i(H h0, Continuation continuation0, k k0) {
        this.w = h0;
        this.B = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(this.w, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                h h0 = new h(this.w, null, this.B);
                this.r = 1;
                Object object1 = this.w.useConnection$room_runtime_release(false, h0, this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

