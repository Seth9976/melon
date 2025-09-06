package androidx.car.app.model;

import java.util.Objects;

public final class Place {
    private final CarLocation mLocation;
    private final PlaceMarker mMarker;

    private Place() {
        this.mLocation = null;
        this.mMarker = null;
    }

    public Place(K k0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Place ? Objects.equals(this.mLocation, ((Place)object0).mLocation) && Objects.equals(this.mMarker, ((Place)object0).mMarker) : false;
    }

    public CarLocation getLocation() {
        Objects.requireNonNull(this.mLocation);
        return this.mLocation;
    }

    public PlaceMarker getMarker() {
        return this.mMarker;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mLocation, this.mMarker});
    }

    @Override
    public String toString() {
        return "[ location: " + this.mLocation + ", marker: " + this.mMarker + "]";
    }
}

