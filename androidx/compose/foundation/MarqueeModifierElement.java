package androidx.compose.foundation;

import A7.d;
import P0.a0;
import Q0.x0;
import androidx.compose.runtime.O0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import r1.f;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierElement;", "LP0/a0;", "Landroidx/compose/foundation/v0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class MarqueeModifierElement extends a0 {
    public final int a;
    public final int b;
    public final int c;
    public final w0 d;
    public final float e;

    public MarqueeModifierElement(int v, int v1, int v2, w0 w00, float f) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = w00;
        this.e = f;
    }

    @Override  // P0.a0
    public final p create() {
        return new v0(this.a, this.b, this.c, this.d, this.e);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof MarqueeModifierElement && this.a == ((MarqueeModifierElement)object0).a && this.b == ((MarqueeModifierElement)object0).b && this.c == ((MarqueeModifierElement)object0).c && q.b(this.d, ((MarqueeModifierElement)object0).d) && f.a(this.e, ((MarqueeModifierElement)object0).e);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.e) + (this.d.hashCode() + d.b(this.c, d.b(this.b, d.b(0, this.a * 0x1F, 0x1F), 0x1F), 0x1F)) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "basicMarquee";
        x00.c.b(this.a, "iterations");
        q0 q00 = new q0();  // 初始化器: Ljava/lang/Object;-><init>()V
        x00.c.b(q00, "animationMode");
        x00.c.b(this.b, "delayMillis");
        x00.c.b(this.c, "initialDelayMillis");
        x00.c.b(this.d, "spacing");
        f f0 = new f(this.e);
        x00.c.b(f0, "velocity");
    }

    @Override
    public final String toString() {
        return "MarqueeModifierElement(iterations=" + this.a + ", animationMode=Immediately, delayMillis=" + this.b + ", initialDelayMillis=" + this.c + ", spacing=" + this.d + ", velocity=" + f.b(this.e) + ')';
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((O0)((v0)p0).j).setValue(this.d);
        q0 q00 = new q0();  // 初始化器: Ljava/lang/Object;-><init>()V
        ((O0)((v0)p0).k).setValue(q00);
        int v = this.a;
        int v1 = this.b;
        int v2 = this.c;
        float f = this.e;
        if(((v0)p0).a == v && ((v0)p0).b == v1 && ((v0)p0).c == v2 && f.a(((v0)p0).d, f)) {
            return;
        }
        ((v0)p0).a = v;
        ((v0)p0).b = v1;
        ((v0)p0).c = v2;
        ((v0)p0).d = f;
        ((v0)p0).q0();
    }
}

