package ed;

import Ac.U2;
import androidx.compose.runtime.b1;
import kotlin.jvm.internal.q;
import p0.p;

public final class j0 extends l0 {
    public final p a;
    public final U2 b;
    public final f c;
    public final v0 d;
    public final b1 e;

    public j0(p p0, U2 u20, f f0, v0 v00, b1 b10) {
        q.g(p0, "data");
        super();
        this.a = p0;
        this.b = u20;
        this.c = f0;
        this.d = v00;
        this.e = b10;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j0 && q.b(this.a, ((j0)object0).a) && this.b.equals(((j0)object0).b) && this.c.equals(((j0)object0).c) && this.d.equals(((j0)object0).d) && this.e.equals(((j0)object0).e);
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + (this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "TagList(data=" + this.a + ", nextTagClickAction=" + this.b + ", refreshClickAction=" + this.c + ", sendClickLog=" + this.d + ", isVisible=" + this.e + ")";
    }
}

