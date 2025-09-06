package I8;

import kotlin.jvm.internal.q;

public final class k {
    public final long a;
    public final String b;

    public k(long v, String s) {
        this.a = v;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        return this.a == ((k)object0).a ? q.b(this.b, ((k)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "GenreInfo(audioId=" + this.a + ", genreName=" + this.b + ")";
    }
}

