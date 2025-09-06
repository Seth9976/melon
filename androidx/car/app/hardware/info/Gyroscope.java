package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;

public final class Gyroscope {
    private final CarValue mRotations;

    private Gyroscope() {
        this.mRotations = CarValue.UNKNOWN_FLOAT_LIST;
    }

    public Gyroscope(CarValue carValue0) {
        Objects.requireNonNull(carValue0);
        this.mRotations = carValue0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Gyroscope ? Objects.equals(this.mRotations, ((Gyroscope)object0).mRotations) : false;
    }

    public CarValue getRotations() {
        return this.mRotations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mRotations});
    }

    @Override
    public String toString() {
        return "[ rotations: " + this.mRotations + " ]";
    }
}

