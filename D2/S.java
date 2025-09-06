package D2;

import B0.b;
import df.v;
import e1.u;
import i.n.i.b.a.s.e.M3;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ProducerScope;
import me.g;
import me.h;
import me.i;
import ne.a;
import oe.c;
import we.n;

public final class s implements D {
    public final AtomicReference a;
    public final ProducerScope b;

    public s(AtomicReference atomicReference0, ProducerScope producerScope0) {
        this.a = atomicReference0;
        this.b = producerScope0;
    }

    public final void a(n n0, c c0) {
        r r0;
        if(c0 instanceof r) {
            r0 = (r)c0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new r(this, c0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new r(this, c0);
        }
        Object object0 = r0.r;
        a a0 = a.a;
        switch(r0.B) {
            case 0: {
                d5.n.D(object0);
                r0.B = 1;
                CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(r0), 1);
                cancellableContinuationImpl0.initCancellability();
                ProducerScope producerScope0 = this.b;
                cancellableContinuationImpl0.invokeOnCancellation(new b(producerScope0, 3));
                CancellableContinuation cancellableContinuation0 = (CancellableContinuation)this.a.getAndSet(cancellableContinuationImpl0);
                if(cancellableContinuation0 != null) {
                    DefaultImpls.cancel$default(cancellableContinuation0, null, 1, null);
                }
                producerScope0.trySend-JP2dKIU(n0);
                if(cancellableContinuationImpl0.getResult() == a0) {
                    return;
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
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // me.i
    public final Object fold(Object object0, n n0) {
        return v.v(this, object0, n0);
    }

    @Override  // me.i
    public final g get(h h0) {
        return v.w(this, h0);
    }

    @Override  // me.i
    public final i minusKey(h h0) {
        return v.E(this, h0);
    }

    @Override  // me.i
    public final i plus(i i0) {
        return v.F(i0, this);
    }
}

