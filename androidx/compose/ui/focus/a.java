package androidx.compose.ui.focus;

import r0.q;
import w0.p;
import we.k;

public abstract class a {
    public static final q a(q q0, p p0) {
        return q0.then(new FocusRequesterElement(p0));
    }

    public static final q b(q q0, k k0) {
        return q0.then(new FocusChangedElement(k0));
    }
}

