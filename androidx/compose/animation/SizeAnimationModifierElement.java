package androidx.compose.animation;

import F.j0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import r0.d;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierElement;", "LP0/a0;", "LF/j0;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class SizeAnimationModifierElement extends a0 {
    public final G.a0 a;

    public SizeAnimationModifierElement(G.a0 a00) {
        this.a = a00;
    }

    @Override  // P0.a0
    public final p create() {
        return new j0(this.a);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof SizeAnimationModifierElement && this.a.equals(((SizeAnimationModifierElement)object0).a) && d.a.equals(d.a);
    }

    // 去混淆评级： 低(20)
    @Override
    public final int hashCode() {
        return (0xF0000000 + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "animateContentSize";
        x00.c.b(this.a, "animationSpec");
        x00.c.b(d.a, "alignment");
        x00.c.b(null, "finishedListener");
    }

    @Override
    public final String toString() {
        return "SizeAnimationModifierElement(animationSpec=" + this.a + ", alignment=" + d.a + ", finishedListener=null)";
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((j0)p0).a = this.a;
    }
}

