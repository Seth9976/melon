package u5;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class i implements ViewTreeObserver.OnPreDrawListener {
    public boolean a;
    public final e b;
    public final ViewTreeObserver c;
    public final CancellableContinuationImpl d;

    public i(e e0, ViewTreeObserver viewTreeObserver0, CancellableContinuationImpl cancellableContinuationImpl0) {
        this.b = e0;
        this.c = viewTreeObserver0;
        this.d = cancellableContinuationImpl0;
    }

    @Override  // android.view.ViewTreeObserver$OnPreDrawListener
    public final boolean onPreDraw() {
        e e0 = this.b;
        g g0 = e0.b();
        if(g0 != null) {
            ViewTreeObserver viewTreeObserver0 = this.c;
            if(viewTreeObserver0.isAlive()) {
                viewTreeObserver0.removeOnPreDrawListener(this);
            }
            else {
                e0.a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            if(!this.a) {
                this.a = true;
                this.d.resumeWith(g0);
            }
        }
        return true;
    }
}

