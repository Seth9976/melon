package P5;

public final class r extends D {
    public final q a;

    public r(q q0) {
        this.a = q0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof D ? this.a.equals(((r)(((D)object0))).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.a + "}";
    }
}

