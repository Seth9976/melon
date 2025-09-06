package f1;

import W.x;
import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;

public final class n extends m {
    @Override  // android.view.inputmethod.InputConnection
    public final void performHandwritingGesture(HandwritingGesture handwritingGesture0, Executor executor0, IntConsumer intConsumer0) {
        x x0 = this.b;
        if(x0 != null) {
            x0.performHandwritingGesture(handwritingGesture0, executor0, intConsumer0);
        }
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture0, CancellationSignal cancellationSignal0) {
        return this.b == null ? false : this.b.previewHandwritingGesture(previewableHandwritingGesture0, cancellationSignal0);
    }
}

