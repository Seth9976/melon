package Q0;

import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;

public final class h1 implements View.OnAttachStateChangeListener {
    public final Job a;

    public h1(Job job0) {
        this.a = job0;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        view0.removeOnAttachStateChangeListener(this);
        DefaultImpls.cancel$default(this.a, null, 1, null);
    }
}

