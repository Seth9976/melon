package androidx.compose.animation;

import F.M;
import F.W;
import F.X;
import F.Y;
import G.l0;
import G.t0;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "LP0/a0;", "LF/W;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class EnterExitTransitionElement extends a0 {
    public final t0 a;
    public final l0 b;
    public final l0 c;
    public final l0 d;
    public final X e;
    public final Y f;
    public final a g;
    public final M h;

    public EnterExitTransitionElement(t0 t00, l0 l00, l0 l01, l0 l02, X x0, Y y0, a a0, M m0) {
        this.a = t00;
        this.b = l00;
        this.c = l01;
        this.d = l02;
        this.e = x0;
        this.f = y0;
        this.g = a0;
        this.h = m0;
    }

    @Override  // P0.a0
    public final p create() {
        return new W(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof EnterExitTransitionElement)) {
            return false;
        }
        if(!q.b(this.a, ((EnterExitTransitionElement)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((EnterExitTransitionElement)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((EnterExitTransitionElement)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((EnterExitTransitionElement)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((EnterExitTransitionElement)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((EnterExitTransitionElement)object0).f)) {
            return false;
        }
        return q.b(this.g, ((EnterExitTransitionElement)object0).g) ? q.b(this.h, ((EnterExitTransitionElement)object0).h) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        l0 l00 = this.d;
        if(l00 != null) {
            v1 = l00.hashCode();
        }
        return this.h.hashCode() + (this.g.hashCode() + (this.f.hashCode() + (this.e.hashCode() + (((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v1) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "enterExitTransition";
        x00.c.b(this.a, "transition");
        x00.c.b(this.b, "sizeAnimation");
        x00.c.b(this.c, "offsetAnimation");
        x00.c.b(this.d, "slideAnimation");
        x00.c.b(this.e, "enter");
        x00.c.b(this.f, "exit");
        x00.c.b(this.h, "graphicsLayerBlock");
    }

    @Override
    public final String toString() {
        return "EnterExitTransitionElement(transition=" + this.a + ", sizeAnimation=" + this.b + ", offsetAnimation=" + this.c + ", slideAnimation=" + this.d + ", enter=" + this.e + ", exit=" + this.f + ", isEnabled=" + this.g + ", graphicsLayerBlock=" + this.h + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((W)p0).a = this.a;
        ((W)p0).b = this.b;
        ((W)p0).c = this.c;
        ((W)p0).d = this.d;
        ((W)p0).e = this.e;
        ((W)p0).f = this.f;
        ((W)p0).g = this.g;
        ((W)p0).h = this.h;
    }
}

