package androidx.compose.ui.input.key;

import r0.q;
import we.k;

public abstract class a {
    public static final q a(k k0) {
        return new SoftKeyboardInterceptionElement(k0);
    }

    public static final q b(k k0) {
        return new KeyInputElement(k0, null);
    }

    public static final q c(q q0, k k0) {
        return q0.then(new KeyInputElement(null, k0));
    }
}

