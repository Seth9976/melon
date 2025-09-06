package D4;

import androidx.room.H;
import d5.n;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;

public final class f extends i implements k {
    public final k B;
    public int r;
    public final H w;

    public f(H h0, Continuation continuation0, k k0) {
        this.w = h0;
        this.B = k0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new f(this.w, continuation0, this.B);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((f)this.create(((Continuation)object0))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                e e0 = new e(this.w, null, this.B);
                this.r = 1;
                Object object1 = this.w.useConnection$room_runtime_release(false, e0, this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

