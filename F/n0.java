package F;

import A7.d;
import java.util.LinkedHashMap;
import java.util.Map;
import je.x;
import kotlin.jvm.internal.q;

public final class n0 {
    public final Z a;
    public final l0 b;
    public final G c;
    public final e0 d;
    public final boolean e;
    public final Map f;

    public n0(Z z0, l0 l00, G g0, e0 e00, LinkedHashMap linkedHashMap0, int v) {
        if((v & 0x20) != 0) {
            linkedHashMap0 = x.a;
        }
        this(((v & 1) == 0 ? z0 : null), ((v & 2) == 0 ? l00 : null), ((v & 4) == 0 ? g0 : null), ((v & 8) == 0 ? e00 : null), (v & 16) == 0, linkedHashMap0);
    }

    public n0(Z z0, l0 l00, G g0, e0 e00, boolean z1, Map map0) {
        this.a = z0;
        this.b = l00;
        this.c = g0;
        this.d = e00;
        this.e = z1;
        this.f = map0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n0)) {
            return false;
        }
        if(!q.b(this.a, ((n0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((n0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((n0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((n0)object0).d)) {
            return false;
        }
        return this.e == ((n0)object0).e ? q.b(this.f, ((n0)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        e0 e00 = this.d;
        if(e00 != null) {
            v = e00.hashCode();
        }
        return this.f.hashCode() + d.e((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v) * 0x1F, 0x1F, this.e);
    }

    @Override
    public final String toString() {
        return "TransitionData(fade=" + this.a + ", slide=" + this.b + ", changeSize=" + this.c + ", scale=" + this.d + ", hold=" + this.e + ", effectsMap=" + this.f + ')';
    }
}

