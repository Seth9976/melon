package U4;

public final class r extends u {
    public final i a;

    public r(i i0) {
        this.a = i0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return r.class == class0 ? this.a.equals(((r)object0).a) : false;
        }
        return false;
    }

    // 去混淆评级： 低(30)
    @Override
    public final int hashCode() {
        return this.a.hashCode() + 80096157;
    }

    @Override
    public final String toString() {
        return "Failure {mOutputData=" + this.a + '}';
    }
}

