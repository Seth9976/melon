package n1;

import G.e;
import G.o;
import kotlin.jvm.internal.q;

public final class f {
    public final e a;
    public final o b;
    public final r c;

    public f(e e0, o o0, r r0) {
        this.a = e0;
        this.b = o0;
        this.c = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        if(!q.b(this.a, ((f)object0).a)) {
            return false;
        }
        return q.b(this.b, ((f)object0).b) ? q.b(this.c, ((f)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "AnimateXAsStateSearchInfo(animatable=" + this.a + ", animationSpec=" + this.b + ", toolingState=" + this.c + ')';
    }
}

