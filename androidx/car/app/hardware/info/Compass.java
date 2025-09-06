package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;

public final class Compass {
    private final CarValue mOrientations;

    private Compass() {
        this.mOrientations = CarValue.UNKNOWN_FLOAT_LIST;
    }

    public Compass(CarValue carValue0) {
        Objects.requireNonNull(carValue0);
        this.mOrientations = carValue0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Compass ? Objects.equals(this.mOrientations, ((Compass)object0).mOrientations) : false;
    }

    public CarValue getOrientations() {
        return this.mOrientations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mOrientations});
    }

    @Override
    public String toString() {
        return "[ orientations: " + this.mOrientations + " ]";
    }
}

