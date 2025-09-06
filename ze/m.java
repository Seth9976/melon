package Ze;

import H0.b;
import hf.g;
import hf.h;
import java.util.Collection;
import kotlin.jvm.internal.q;

public final class m {
    public final h a;
    public final Collection b;
    public final boolean c;

    public m(h h0, Collection collection0) {
        this(h0, collection0, h0.a == g.c);
    }

    public m(h h0, Collection collection0, boolean z) {
        q.g(collection0, "qualifierApplicabilityTypes");
        super();
        this.a = h0;
        this.b = collection0;
        this.c = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        if(!q.b(this.a, ((m)object0).a)) {
            return false;
        }
        return q.b(this.b, ((m)object0).b) ? this.c == ((m)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("JavaDefaultQualifiers(nullabilityQualifier=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", qualifierApplicabilityTypes=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", definitelyNotNull=");
        return b.k(stringBuilder0, this.c, ')');
    }
}

