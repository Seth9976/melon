package Dc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final k B;
    public final F D;
    public int r;
    public final E w;

    public j(E e0, k k0, F f0, Continuation continuation0) {
        this.w = e0;
        this.B = k0;
        this.D = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                float f = this.w.a;
                float f1 = ((Number)this.B.c.invoke()).floatValue();
                this.r = 1;
                return this.B.a.c(this.B.b, ((float)this.D.a) / 2.0f + (f - f1), this) == a0 ? a0 : H.a;
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

