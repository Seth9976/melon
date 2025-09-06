package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;

public final class CarHardwareLocation {
    public static final CarValue UNIMPLEMENTED_LOCATION;
    public static final CarValue UNKNOWN_LOCATION;
    private final CarValue mLocation;

    static {
        CarHardwareLocation.UNIMPLEMENTED_LOCATION = new CarValue(null, 0L, 2);
        CarHardwareLocation.UNKNOWN_LOCATION = new CarValue(null, 0L, 0);
    }

    private CarHardwareLocation() {
        this.mLocation = CarHardwareLocation.UNKNOWN_LOCATION;
    }

    public CarHardwareLocation(CarValue carValue0) {
        Objects.requireNonNull(carValue0);
        this.mLocation = carValue0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarHardwareLocation ? Objects.equals(this.mLocation, ((CarHardwareLocation)object0).mLocation) : false;
    }

    public CarValue getLocation() {
        return this.mLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mLocation});
    }

    @Override
    public String toString() {
        return "[ location: " + this.mLocation + " ]";
    }
}

