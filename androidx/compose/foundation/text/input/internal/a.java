package androidx.compose.foundation.text.input.internal;

import U.f0;
import W.t;
import Y.Q;
import r0.q;

public abstract class a {
    public static final q a(q q0, t t0, f0 f00, Q q1) {
        return q0.then(new LegacyAdaptingPlatformTextInputModifier(t0, f00, q1));
    }
}

