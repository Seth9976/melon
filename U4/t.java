package U4;

public final class t extends u {
    public final i a;

    public t(i i0) {
        this.a = i0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return t.class == class0 ? this.a.equals(((t)object0).a) : false;
        }
        return false;
    }

    // 去混淆评级： 低(30)
    @Override
    public final int hashCode() {
        return this.a.hashCode() + 80096219;
    }

    @Override
    public final String toString() {
        return "Success {mOutputData=" + this.a + '}';
    }
}

