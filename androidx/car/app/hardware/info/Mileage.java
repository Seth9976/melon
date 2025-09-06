package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.d;

public final class Mileage {
    private final CarValue mDistanceDisplayUnit;
    private final CarValue mOdometerMeters;

    private Mileage() {
        this.mOdometerMeters = CarValue.UNKNOWN_FLOAT;
        this.mDistanceDisplayUnit = CarValue.UNKNOWN_INTEGER;
    }

    public Mileage(d d0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Mileage ? Objects.equals(this.getOdometerMeters(), ((Mileage)object0).getOdometerMeters()) && Objects.equals(this.mDistanceDisplayUnit, ((Mileage)object0).mDistanceDisplayUnit) : false;
    }

    public CarValue getDistanceDisplayUnit() {
        Objects.requireNonNull(this.mDistanceDisplayUnit);
        return this.mDistanceDisplayUnit;
    }

    public CarValue getOdometerMeters() {
        Objects.requireNonNull(this.mOdometerMeters);
        return this.mOdometerMeters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.getOdometerMeters(), this.mDistanceDisplayUnit});
    }

    @Override
    public String toString() {
        return "[ odometer: " + this.getOdometerMeters() + ", distance display unit: " + this.mDistanceDisplayUnit + "]";
    }
}

