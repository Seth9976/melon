package androidx.car.app.model;

import android.location.Location;
import java.util.Objects;

public final class CarLocation {
    private final double mLat;
    private final double mLng;

    private CarLocation() {
        this(0.0, 0.0);
    }

    private CarLocation(double f, double f1) {
        this.mLat = f;
        this.mLng = f1;
    }

    public static CarLocation create(double f, double f1) {
        return new CarLocation(f, f1);
    }

    public static CarLocation create(Location location0) {
        Objects.requireNonNull(location0);
        return CarLocation.create(location0.getLatitude(), location0.getLongitude());
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarLocation ? Double.doubleToLongBits(this.mLat) == Double.doubleToLongBits(((CarLocation)object0).mLat) && Double.doubleToLongBits(this.mLng) == Double.doubleToLongBits(((CarLocation)object0).mLng) : false;
    }

    public double getLatitude() {
        return this.mLat;
    }

    public double getLongitude() {
        return this.mLng;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mLat, this.mLng});
    }

    @Override
    public String toString() {
        return "[" + this.getLatitude() + ", " + this.getLongitude() + "]";
    }
}

