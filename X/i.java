package X;

import A7.d;
import H0.b;
import U4.x;
import kotlin.jvm.internal.q;

public final class i {
    public final String a;
    public String b;
    public boolean c;
    public e d;

    public i(String s, String s1) {
        this.a = s;
        this.b = s1;
        this.c = false;
        this.d = null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        if(!q.b(this.a, ((i)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((i)object0).b)) {
            return false;
        }
        return this.c == ((i)object0).c ? q.b(this.d, ((i)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        return this.d == null ? v : v + this.d.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TextSubstitution(layoutCache=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", isShowingSubstitution=");
        return b.k(stringBuilder0, this.c, ')');
    }
}

