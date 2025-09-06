package androidx.compose.runtime;

import kotlinx.coroutines.CoroutineScope;
import me.i;

public final class k0 implements b0, CoroutineScope {
    public final i a;
    public final b0 b;

    public k0(b0 b00, i i0) {
        this.a = i0;
        this.b = b00;
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    public final i getCoroutineContext() {
        return this.a;
    }

    @Override  // androidx.compose.runtime.b1
    public final Object getValue() {
        return this.b.getValue();
    }

    @Override  // androidx.compose.runtime.b0
    public final void setValue(Object object0) {
        this.b.setValue(object0);
    }
}

