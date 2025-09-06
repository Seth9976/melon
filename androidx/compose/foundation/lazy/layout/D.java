package androidx.compose.foundation.lazy.layout;

import d5.n;
import e1.u;
import ie.H;
import kotlinx.coroutines.CancellableContinuationImpl;
import ne.a;
import oe.c;
import r0.o;

public final class d implements o {
    public boolean a;
    public CancellableContinuationImpl b;

    public final Object c(c c0) {
        CancellableContinuationImpl cancellableContinuationImpl2;
        androidx.compose.foundation.lazy.layout.c c1;
        if(c0 instanceof androidx.compose.foundation.lazy.layout.c) {
            c1 = (androidx.compose.foundation.lazy.layout.c)c0;
            int v = c1.D;
            if((v & 0x80000000) == 0) {
                c1 = new androidx.compose.foundation.lazy.layout.c(this, c0);
            }
            else {
                c1.D = v ^ 0x80000000;
            }
        }
        else {
            c1 = new androidx.compose.foundation.lazy.layout.c(this, c0);
        }
        Object object0 = c1.w;
        a a0 = a.a;
        H h0 = H.a;
        switch(c1.D) {
            case 0: {
                n.D(object0);
                if(!this.a) {
                    CancellableContinuationImpl cancellableContinuationImpl0 = this.b;
                    c1.r = cancellableContinuationImpl0;
                    c1.D = 1;
                    CancellableContinuationImpl cancellableContinuationImpl1 = new CancellableContinuationImpl(u.D(c1), 1);
                    cancellableContinuationImpl1.initCancellability();
                    this.b = cancellableContinuationImpl1;
                    if(cancellableContinuationImpl1.getResult() == a0) {
                        return a0;
                    }
                    cancellableContinuationImpl2 = cancellableContinuationImpl0;
                    goto label_28;
                }
                break;
            }
            case 1: {
                cancellableContinuationImpl2 = c1.r;
                n.D(object0);
            label_28:
                if(cancellableContinuationImpl2 != null) {
                    cancellableContinuationImpl2.resumeWith(h0);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

