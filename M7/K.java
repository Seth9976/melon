package M7;

public final class k {
    public final j a;
    public final j b;
    public final double c;

    public k(j j0, j j1, double f) {
        this.a = j0;
        this.b = j1;
        this.c = f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        if(this.a != ((k)object0).a) {
            return false;
        }
        return this.b == ((k)object0).b ? Double.compare(this.c, ((k)object0).c) == 0 : false;
    }

    @Override
    public final int hashCode() {
        return Double.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "DataCollectionStatus(performance=" + this.a + ", crashlytics=" + this.b + ", sessionSamplingRate=" + this.c + ')';
    }
}

