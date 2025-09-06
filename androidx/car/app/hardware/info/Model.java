package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.e;

public final class Model {
    private final CarValue mManufacturer;
    private final CarValue mName;
    private final CarValue mYear;

    private Model() {
        this.mName = CarValue.UNKNOWN_STRING;
        this.mManufacturer = CarValue.UNKNOWN_STRING;
        this.mYear = CarValue.UNKNOWN_INTEGER;
    }

    public Model(e e0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Model ? Objects.equals(this.mName, ((Model)object0).mName) && Objects.equals(this.mYear, ((Model)object0).mYear) && Objects.equals(this.mManufacturer, ((Model)object0).mManufacturer) : false;
    }

    public CarValue getManufacturer() {
        Objects.requireNonNull(this.mManufacturer);
        return this.mManufacturer;
    }

    public CarValue getName() {
        Objects.requireNonNull(this.mName);
        return this.mName;
    }

    public CarValue getYear() {
        Objects.requireNonNull(this.mYear);
        return this.mYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mName, this.mYear, this.mManufacturer});
    }

    @Override
    public String toString() {
        return "[ name: " + this.mName + ", year: " + this.mYear + ", manufacturer: " + this.mManufacturer + "]";
    }
}

