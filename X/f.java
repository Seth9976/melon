package X;

import a1.g;
import kotlin.jvm.internal.q;

public final class f {
    public final g a;
    public g b;
    public boolean c;
    public d d;

    public f(g g0, g g1) {
        this.a = g0;
        this.b = g1;
        this.c = false;
        this.d = null;
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
        if(!q.b(this.b, ((f)object0).b)) {
            return false;
        }
        return this.c == ((f)object0).c ? q.b(this.d, ((f)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = A7.d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
        return this.d == null ? v : v + this.d.hashCode();
    }

    @Override
    public final String toString() {
        return "TextSubstitutionValue(original=" + this.a + ", substitution=" + this.b + ", isShowingSubstitution=" + this.c + ", layoutCache=" + this.d + ')';
    }
}

