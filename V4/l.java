package V4;

import M6.B;
import d5.n;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class l implements Runnable {
    public final B a;
    public final CancellableContinuationImpl b;

    public l(B b0, CancellableContinuationImpl cancellableContinuationImpl0) {
        this.a = b0;
        this.b = cancellableContinuationImpl0;
    }

    @Override
    public final void run() {
        Object object0;
        B b0 = this.a;
        boolean z = b0.isCancelled();
        CancellableContinuationImpl cancellableContinuationImpl0 = this.b;
        if(z) {
            DefaultImpls.cancel$default(cancellableContinuationImpl0, null, 1, null);
            return;
        }
        boolean z1 = false;
        while(true) {
            try {
                object0 = b0.get();
                goto label_15;
            }
            catch(InterruptedException unused_ex) {
                z1 = true;
            }
            catch(Throwable throwable0) {
                try {
                    if(z1) {
                        Thread.currentThread().interrupt();
                    }
                    throw throwable0;
                label_15:
                    if(z1) {
                        Thread.currentThread().interrupt();
                    }
                    cancellableContinuationImpl0.resumeWith(object0);
                    return;
                }
                catch(ExecutionException executionException0) {
                }
                break;
            }
        }
        Throwable throwable1 = executionException0.getCause();
        q.d(throwable1);
        cancellableContinuationImpl0.resumeWith(n.t(throwable1));
    }
}

