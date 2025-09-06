package c2;

import android.view.WindowInsetsController.OnControllableInsetsChangedListener;
import android.view.WindowInsetsController;
import java.util.concurrent.atomic.AtomicBoolean;

public final class C implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final AtomicBoolean a;

    public C(AtomicBoolean atomicBoolean0) {
        this.a = atomicBoolean0;
    }

    @Override  // android.view.WindowInsetsController$OnControllableInsetsChangedListener
    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController0, int v) {
        this.a.set((v & 8) != 0);
    }
}

