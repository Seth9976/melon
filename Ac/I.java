package ac;

import H0.e;

public final class i extends e {
    public final boolean e;

    public i(boolean z) {
        this.e = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? this.e == ((i)object0).e : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.e);
    }

    @Override
    public final String toString() {
        return "Streaming(isMusicWave=" + this.e + ")";
    }
}

