package gd;

public final class k5 extends Z3 {
    public final boolean a;

    public k5(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k5 ? this.a == ((k5)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "CheckSavePlaylist(isChecked=" + this.a + ")";
    }
}

