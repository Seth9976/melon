package kc;

public final class d {
    public final int a;
    public final boolean b;

    public d(int v, boolean z) {
        this.a = v;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return this.a == ((d)object0).a ? this.b == ((d)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "LikeContentInfo(likeCount=" + this.a + ", isLiked=" + this.b + ")";
    }
}

