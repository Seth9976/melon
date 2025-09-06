package m1;

import androidx.compose.ui.tooling.ComposeViewAdapter;
import b.t;
import b.u;

public final class e implements u {
    public final t a;
    public final ComposeViewAdapter b;

    public e(ComposeViewAdapter composeViewAdapter0) {
        this.b = composeViewAdapter0;
        this.a = new t(null);
    }

    @Override  // androidx.lifecycle.D
    public final androidx.lifecycle.t getLifecycle() {
        return this.b.D.a;
    }

    @Override  // b.u
    public final t getOnBackPressedDispatcher() {
        return this.a;
    }
}

