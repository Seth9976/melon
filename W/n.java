package W;

import U.f0;
import Y.Q;
import a1.T;
import android.os.CancellationSignal.OnCancelListener;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;

public final class n implements CancellationSignal.OnCancelListener {
    public final int a;
    public final Object b;

    public n(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.os.CancellationSignal$OnCancelListener
    public final void onCancel() {
        if(this.a != 0) {
            DefaultImpls.cancel$default(((Job)this.b), null, 1, null);
            return;
        }
        Q q0 = (Q)this.b;
        if(q0 != null) {
            f0 f00 = q0.d;
            if(f00 != null) {
                f00.e(T.b);
            }
            f0 f01 = q0.d;
            if(f01 != null) {
                f01.f(T.b);
            }
        }
    }
}

