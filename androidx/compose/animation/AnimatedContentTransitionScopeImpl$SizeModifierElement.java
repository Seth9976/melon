package androidx.compose.animation;

import F.q;
import F.r;
import G.l0;
import P0.a0;
import Q0.x0;
import androidx.compose.runtime.b0;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002¨\u0006\u0004"}, d2 = {"androidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierElement", "S", "LP0/a0;", "LF/q;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class AnimatedContentTransitionScopeImpl.SizeModifierElement extends a0 {
    public final l0 a;
    public final b0 b;
    public final r c;

    public AnimatedContentTransitionScopeImpl.SizeModifierElement(l0 l00, b0 b00, r r0) {
        this.a = l00;
        this.b = b00;
        this.c = r0;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new q();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = a.a;
        return p0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof AnimatedContentTransitionScopeImpl.SizeModifierElement && kotlin.jvm.internal.q.b(((AnimatedContentTransitionScopeImpl.SizeModifierElement)object0).a, this.a) && ((AnimatedContentTransitionScopeImpl.SizeModifierElement)object0).b.equals(this.b);
    }

    @Override
    public final int hashCode() {
        int v = this.c.hashCode();
        return this.a == null ? this.b.hashCode() + v * 961 : this.b.hashCode() + (v * 0x1F + this.a.hashCode()) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "sizeTransform";
        x00.c.b(this.a, "sizeAnimation");
        x00.c.b(this.b, "sizeTransform");
        x00.c.b(this.c, "scope");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((q)p0).a = this.a;
        ((q)p0).b = this.b;
        ((q)p0).c = this.c;
    }
}

