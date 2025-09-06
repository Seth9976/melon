package androidx.compose.ui.layout;

import N0.L;
import N0.x;
import r0.q;
import we.k;
import we.o;

public abstract class a {
    public static final Object a(L l0) {
        Object object0 = l0.q();
        x x0 = object0 instanceof x ? ((x)object0) : null;
        return x0 == null ? null : x0.D();
    }

    public static final q b(q q0, o o0) {
        return q0.then(new LayoutElement(o0));
    }

    public static final q c(Object object0) {
        return new LayoutIdElement(object0);
    }

    public static final q d(q q0, k k0) {
        return q0.then(new OnGloballyPositionedElement(k0));
    }

    public static q e(q q0, k k0) {
        return q0.then(new OnLayoutRectChangedElement(k0));
    }

    public static final q f(q q0, k k0) {
        return q0.then(new OnSizeChangedModifier(k0));
    }
}

