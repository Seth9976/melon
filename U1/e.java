package u1;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final u1.i B;
    public final long D;
    public int r;
    public final boolean w;

    public e(boolean z, u1.i i0, long v, Continuation continuation0) {
        this.w = z;
        this.B = i0;
        this.D = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                u1.i i0 = this.B;
                if(this.w) {
                    this.r = 2;
                    if(i0.a.a(this.D, 0L, this) == a0) {
                        return a0;
                    }
                }
                else {
                    this.r = 1;
                    if(i0.a.a(0L, this.D, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

