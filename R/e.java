package R;

import Ac.J;
import G.g;
import I.l;
import P0.j0;
import e1.u;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;
import x0.c;

public final class e extends i implements n {
    public final j0 B;
    public final g D;
    public int r;
    public final h w;

    public e(h h0, j0 j00, g g0, Continuation continuation0) {
        this.w = h0;
        this.B = j00;
        this.D = g0;
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
        H h2;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l l0 = this.w.a;
                d d0 = new d(this.w, this.B, this.D);
                this.r = 1;
                l0.getClass();
                c c0 = (c)d0.invoke();
                if(c0 == null || l0.o0(c0, l0.i)) {
                    h2 = h0;
                }
                else {
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                    cancellableContinuationImpl0.initCancellability();
                    I.h h1 = new I.h(d0, cancellableContinuationImpl0);
                    I.a a1 = l0.e;
                    g0.e e0 = a1.a;
                    c c1 = (c)d0.invoke();
                    if(c1 == null) {
                        cancellableContinuationImpl0.resumeWith(h0);
                    }
                    else {
                        cancellableContinuationImpl0.invokeOnCancellation(new J(19, a1, h1));
                        Ce.g g0 = P4.a.K(0, e0.c);
                        int v = g0.a;
                        int v1 = g0.b;
                        if(v <= v1) {
                            while(true) {
                                c c2 = (c)((I.h)e0.a[v1]).a.invoke();
                                if(c2 != null) {
                                    c c3 = c1.d(c2);
                                    if(c3.equals(c1)) {
                                        e0.a(v1 + 1, h1);
                                        goto label_45;
                                    }
                                    if(!c3.equals(c2)) {
                                        CancellationException cancellationException0 = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                                        int v2 = e0.c - 1;
                                        if(v2 <= v1) {
                                            while(true) {
                                                ((I.h)e0.a[v1]).b.cancel(cancellationException0);
                                                if(v2 == v1) {
                                                    break;
                                                }
                                                ++v2;
                                            }
                                        }
                                    }
                                }
                                if(v1 == v) {
                                    break;
                                }
                                --v1;
                            }
                        }
                        e0.a(0, h1);
                    label_45:
                        if(!l0.j) {
                            l0.p0();
                        }
                    }
                    h2 = cancellableContinuationImpl0.getResult();
                    if(h2 != a.a) {
                        h2 = h0;
                    }
                }
                return h2 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

