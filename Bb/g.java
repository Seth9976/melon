package bb;

import kotlin.jvm.internal.q;

public final class g {
    public final String a;
    public final boolean b;

    public g(String s, boolean z) {
        q.g(s, "contentsTypeId");
        super();
        this.a = s;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        return q.b(this.a, ((g)object0).a) ? this.b == ((g)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "LikeData(contentsTypeId=" + this.a + ", isLike=" + this.b + ")";
    }
}

