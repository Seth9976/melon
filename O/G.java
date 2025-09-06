package O;

import androidx.compose.foundation.lazy.layout.p;
import m0.b;
import we.k;

public final class g implements p {
    public final k a;
    public final k b;
    public final b c;

    public g(k k0, k k1, b b0) {
        this.a = k0;
        this.b = k1;
        this.c = b0;
    }

    @Override  // androidx.compose.foundation.lazy.layout.p
    public final k getKey() {
        return this.a;
    }

    @Override  // androidx.compose.foundation.lazy.layout.p
    public final k getType() {
        return this.b;
    }
}

