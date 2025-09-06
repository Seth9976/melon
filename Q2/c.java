package q2;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final n B;
    public int r;
    public Object w;

    public c(n n0, Continuation continuation0) {
        this.B = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((h)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = this.B.invoke(((h)this.w), this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.e(((h)object0), "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
        ((b)(((h)object0))).b.a.set(true);
        return (h)object0;
    }
}

