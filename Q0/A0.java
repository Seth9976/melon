package Q0;

import android.view.Choreographer.FrameCallback;
import d5.n;
import ie.o;
import kotlinx.coroutines.CancellableContinuationImpl;
import we.k;

public final class a0 implements Choreographer.FrameCallback {
    public final CancellableContinuationImpl a;
    public final k b;

    public a0(CancellableContinuationImpl cancellableContinuationImpl0, b0 b00, k k0) {
        this.a = cancellableContinuationImpl0;
        this.b = k0;
    }

    @Override  // android.view.Choreographer$FrameCallback
    public final void doFrame(long v) {
        o o0;
        try {
            o0 = this.b.invoke(v);
        }
        catch(Throwable throwable0) {
            o0 = n.t(throwable0);
        }
        this.a.resumeWith(o0);
    }
}

