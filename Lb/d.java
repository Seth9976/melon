package lb;

public final class d extends e {
    public final boolean a;

    public d(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? this.a == ((d)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "UpdateFriend(isFriend=" + this.a + ")";
    }
}

