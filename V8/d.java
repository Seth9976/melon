package v8;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public final f B;
    public final v9.i D;
    public f r;
    public int w;

    public d(f f0, v9.i i0, Continuation continuation0) {
        this.B = f0;
        this.D = i0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        f f1;
        a a0 = a.a;
        f f0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.r = f0;
                this.w = 1;
                object0 = f0.fetchRequest(this.D, this);
                if(object0 == a0) {
                    return a0;
                }
                f1 = f0;
                break;
            }
            case 1: {
                f1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        f.access$setCachedTime$p(f1, (((Boolean)object0).booleanValue() ? System.currentTimeMillis() : f.access$getEmptyTime$p(f0)));
        return H.a;
    }
}

