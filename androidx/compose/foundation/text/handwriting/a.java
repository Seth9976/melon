package androidx.compose.foundation.text.handwriting;

import P0.o;
import V.c;
import androidx.compose.ui.input.pointer.StylusHoverIconModifierElement;
import r0.n;
import r0.q;

public abstract class a {
    public static final o a;

    static {
        a.a = new o(10.0f, 40.0f, 10.0f, 40.0f);
    }

    public static final q a(boolean z, boolean z1, we.a a0) {
        q q0 = n.a;
        if(z && c.a) {
            if(z1) {
                q0 = new StylusHoverIconModifierElement(a.a);
            }
            return q0.then(new StylusHandwritingElement(a0));
        }
        return q0;
    }
}

