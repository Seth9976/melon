package androidx.compose.foundation.text.handwriting;

import P0.a0;
import Q0.x0;
import V.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingElement;", "LP0/a0;", "LV/b;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class StylusHandwritingElement extends a0 {
    public final a a;

    public StylusHandwritingElement(a a0) {
        this.a = a0;
    }

    @Override  // P0.a0
    public final p create() {
        return new b(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof StylusHandwritingElement ? q.b(this.a, ((StylusHandwritingElement)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "stylusHandwriting";
        x00.c.b(this.a, "onHandwritingSlopExceeded");
    }

    @Override
    public final String toString() {
        return "StylusHandwritingElement(onHandwritingSlopExceeded=" + this.a + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((b)p0).c = this.a;
    }
}

