package Q0;

import G0.a;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import androidx.compose.runtime.O0;

public final class i implements ViewTreeObserver.OnTouchModeChangeListener {
    public final u a;

    public i(u u0) {
        this.a = u0;
    }

    @Override  // android.view.ViewTreeObserver$OnTouchModeChangeListener
    public final void onTouchModeChanged(boolean z) {
        a a0 = new a((z ? 1 : 2));
        ((O0)this.a.K0.a).setValue(a0);
    }
}

