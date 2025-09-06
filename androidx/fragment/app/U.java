package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.lifecycle.D;
import androidx.lifecycle.M;

public final class u implements M {
    public final w a;

    public u(w w0) {
        this.a = w0;
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        if(((D)object0) != null) {
            w w0 = this.a;
            if(w0.mShowsDialog) {
                View view0 = w0.requireView();
                if(view0.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if(w0.mDialog != null) {
                    if(l0.P(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + w0.mDialog);
                    }
                    w0.mDialog.setContentView(view0);
                }
            }
        }
    }
}

