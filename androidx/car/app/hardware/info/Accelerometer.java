package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;

public final class Accelerometer {
    private final CarValue mForces;

    private Accelerometer() {
        this.mForces = CarValue.UNKNOWN_FLOAT_LIST;
    }

    public Accelerometer(CarValue carValue0) {
        Objects.requireNonNull(carValue0);
        this.mForces = carValue0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Accelerometer ? Objects.equals(this.mForces, ((Accelerometer)object0).mForces) : false;
    }

    public CarValue getForces() {
        return this.mForces;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mForces});
    }

    @Override
    public String toString() {
        return "[ forces: " + this.mForces + " ]";
    }
}

