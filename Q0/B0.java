package Q0;

import A3.c;
import Ld.p;
import android.view.Choreographer;
import androidx.compose.foundation.S;
import androidx.compose.runtime.W;
import androidx.compose.runtime.g0;
import d5.n;
import df.v;
import e1.u;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import me.g;
import me.h;
import me.i;
import ne.a;
import we.k;

public final class b0 implements W {
    public final int a;
    public final Object b;
    public final Object c;

    public b0(Choreographer choreographer0, Z z0) {
        this.a = 0;
        super();
        this.b = choreographer0;
        this.c = z0;
    }

    public b0(W w0) {
        this.a = 1;
        super();
        this.b = w0;
        this.c = new c(1, false);
    }

    @Override  // androidx.compose.runtime.W
    public final Object c(k k0, Continuation continuation0) {
        b0 b00;
        H h0;
        g0 g00;
        if(this.a != 0) {
            if(continuation0 instanceof g0) {
                g00 = (g0)continuation0;
                int v = g00.E;
                if((v & 0x80000000) == 0) {
                    g00 = new g0(this, continuation0);
                }
                else {
                    g00.E = v ^ 0x80000000;
                }
            }
            else {
                g00 = new g0(this, continuation0);
            }
            a a0 = g00.B;
            a a1 = a.a;
            switch(g00.E) {
                case 0: {
                    n.D(a0);
                    c c0 = (c)this.c;
                    g00.r = this;
                    g00.w = k0;
                    g00.E = 1;
                    if(c0.a) {
                        h0 = H.a;
                    }
                    else {
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(g00), 1);
                        cancellableContinuationImpl0.initCancellability();
                        synchronized(c0.b) {
                            ((ArrayList)c0.c).add(cancellableContinuationImpl0);
                        }
                        cancellableContinuationImpl0.invokeOnCancellation(new S(5, c0, cancellableContinuationImpl0));
                        h0 = cancellableContinuationImpl0.getResult();
                        if(h0 != a1) {
                            h0 = H.a;
                        }
                    }
                    if(h0 != a1) {
                        b00 = this;
                        break;
                    }
                    return a1;
                }
                case 1: {
                    k0 = g00.w;
                    b00 = g00.r;
                    n.D(a0);
                    break;
                }
                case 2: {
                    n.D(a0);
                    return a0;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            g00.r = null;
            g00.w = null;
            g00.E = 2;
            a0 = ((W)b00.b).c(k0, g00);
            return a0 == a1 ? a1 : a0;
        }
        Z z0 = (Z)this.c;
        CancellableContinuationImpl cancellableContinuationImpl1 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl1.initCancellability();
        a0 a00 = new a0(cancellableContinuationImpl1, this, k0);
        if(q.b(z0.b, ((Choreographer)this.b))) {
            synchronized(z0.d) {
                z0.f.add(a00);
                if(!z0.i) {
                    z0.i = true;
                    z0.b.postFrameCallback(z0.j);
                }
            }
            cancellableContinuationImpl1.invokeOnCancellation(new p(9, z0, a00));
            return cancellableContinuationImpl1.getResult();
        }
        ((Choreographer)this.b).postFrameCallback(a00);
        cancellableContinuationImpl1.invokeOnCancellation(new p(10, this, a00));
        return cancellableContinuationImpl1.getResult();
    }

    @Override  // me.i
    public final Object fold(Object object0, we.n n0) {
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

