package I;

import J0.L;
import J0.o;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.JobKt;
import me.i;
import ne.a;
import oe.h;
import we.n;

public final class b0 extends h implements n {
    public final i B;
    public final h D;
    public int r;
    public Object w;

    public b0(i i0, n n0, Continuation continuation0) {
        this.B = i0;
        this.D = (h)n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b0(this.B, ((n)this.D), continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        L l1;
        L l0;
        a a0 = a.a;
        i i0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.w;
                goto label_16;
            }
            case 1: {
                l1 = (L)this.w;
                try {
                    d5.n.D(object0);
                    goto label_26;
                }
                catch(CancellationException cancellationException0) {
                    goto label_31;
                }
            }
            case 2: {
                l1 = (L)this.w;
                try {
                    d5.n.D(object0);
                    break;
                }
                catch(CancellationException cancellationException0) {
                    goto label_31;
                }
            }
            case 3: {
                l1 = (L)this.w;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            while(true) {
                l0 = l1;
            label_16:
                if(!JobKt.isActive(i0)) {
                    return H.a;
                }
                try {
                    this.w = l0;
                    this.r = 1;
                    if(((n)this.D).invoke(l0, this) == a0) {
                        return a0;
                    }
                }
                catch(CancellationException cancellationException1) {
                    l1 = l0;
                    cancellationException0 = cancellationException1;
                    break;
                }
                l1 = l0;
                try {
                label_26:
                    this.w = l1;
                    this.r = 2;
                    if(Z0.b(l1, o.c, this) != a0) {
                        continue;
                    }
                    return a0;
                }
                catch(CancellationException cancellationException0) {
                }
                break;
            }
        label_31:
            if(!JobKt.isActive(i0)) {
                throw cancellationException0;
            }
            this.w = l1;
            this.r = 3;
        }
        while(Z0.b(l1, o.c, this) != a0);
        return a0;
    }
}

