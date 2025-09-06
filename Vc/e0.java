package Vc;

public final class e0 implements g0 {
    public final boolean a;
    public final boolean b;

    public e0(boolean z, boolean z1) {
        this.a = z;
        this.b = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e0 && this.a == ((e0)object0).a && this.b == ((e0)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + Boolean.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnMuteButtonClick(isMute=" + this.a + ", sendClickLog=" + this.b + ")";
    }
}

