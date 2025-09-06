package androidx.car.app.model;

import java.util.Objects;

public final class DistanceSpan extends CarSpan {
    private final Distance mDistance;

    private DistanceSpan() {
        this.mDistance = null;
    }

    private DistanceSpan(Distance distance0) {
        this.mDistance = distance0;
    }

    public static DistanceSpan create(Distance distance0) {
        Objects.requireNonNull(distance0);
        return new DistanceSpan(distance0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DistanceSpan ? Objects.equals(this.mDistance, ((DistanceSpan)object0).mDistance) : false;
    }

    public Distance getDistance() {
        Objects.requireNonNull(this.mDistance);
        return this.mDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mDistance);
    }

    @Override
    public String toString() {
        return "[distance: " + this.mDistance + "]";
    }
}

