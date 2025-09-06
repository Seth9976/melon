package v8;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final v9.i B;
    public int r;
    public final f w;

    public e(f f0, v9.i i0, Continuation continuation0) {
        this.w = f0;
        this.B = i0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, this.B, continuation0);
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
                f f0 = this.w;
                v9.i i0 = v9.i.c;
                v9.i i1 = this.B;
                if(f0.isExpired() || q.b(i1, i0)) {
                    f0.get_response().setValue((q.b(i1, v9.i.b) ? new v8.i(h.d, v9.i.b, null, null) : new v8.i(h.e, i0, null, null)));
                    d d0 = new d(f0, i1, null);
                    this.r = 1;
                    if(BuildersKt.withContext(Dispatchers.getIO(), d0, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

