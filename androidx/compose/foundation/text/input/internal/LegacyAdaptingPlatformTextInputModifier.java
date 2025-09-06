package androidx.compose.foundation.text.input.internal;

import L.a;
import P0.a0;
import Q0.x0;
import U.f0;
import W.f;
import W.r;
import W.t;
import Y.Q;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifier;", "LP0/a0;", "LW/r;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class LegacyAdaptingPlatformTextInputModifier extends a0 {
    public final t a;
    public final f0 b;
    public final Q c;

    public LegacyAdaptingPlatformTextInputModifier(t t0, f0 f00, Q q0) {
        this.a = t0;
        this.b = f00;
        this.c = q0;
    }

    @Override  // P0.a0
    public final p create() {
        return new r(this.a, this.b, this.c);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return false;
        }
        if(!q.b(this.a, ((LegacyAdaptingPlatformTextInputModifier)object0).a)) {
            return false;
        }
        return q.b(this.b, ((LegacyAdaptingPlatformTextInputModifier)object0).b) ? q.b(this.c, ((LegacyAdaptingPlatformTextInputModifier)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override
    public final String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.a + ", legacyTextFieldState=" + this.b + ", textFieldSelectionManager=" + this.c + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        if(((r)p0).isAttached()) {
            ((f)((r)p0).a).b();
            ((r)p0).a.i(((r)p0));
        }
        ((r)p0).a = this.a;
        if(((r)p0).isAttached()) {
            t t0 = ((r)p0).a;
            if(t0.a != null) {
                a.c("Expected textInputModifierNode to be null");
            }
            t0.a = (r)p0;
        }
        ((r)p0).b = this.b;
        ((r)p0).c = this.c;
    }
}

