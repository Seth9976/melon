package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.f;

public final class Speed {
    private final CarValue mDisplaySpeedMetersPerSecond;
    private final CarValue mRawSpeedMetersPerSecond;
    private final CarValue mSpeedDisplayUnit;

    private Speed() {
        this.mRawSpeedMetersPerSecond = CarValue.UNKNOWN_FLOAT;
        this.mDisplaySpeedMetersPerSecond = CarValue.UNKNOWN_FLOAT;
        this.mSpeedDisplayUnit = CarValue.UNKNOWN_INTEGER;
    }

    public Speed(f f0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Speed ? Objects.equals(this.getRawSpeedMetersPerSecond(), ((Speed)object0).getRawSpeedMetersPerSecond()) && Objects.equals(this.getDisplaySpeedMetersPerSecond(), ((Speed)object0).getDisplaySpeedMetersPerSecond()) && Objects.equals(this.mSpeedDisplayUnit, ((Speed)object0).mSpeedDisplayUnit) : false;
    }

    public CarValue getDisplaySpeedMetersPerSecond() {
        Objects.requireNonNull(this.mDisplaySpeedMetersPerSecond);
        return this.mDisplaySpeedMetersPerSecond;
    }

    public CarValue getRawSpeedMetersPerSecond() {
        Objects.requireNonNull(this.mRawSpeedMetersPerSecond);
        return this.mRawSpeedMetersPerSecond;
    }

    public CarValue getSpeedDisplayUnit() {
        Objects.requireNonNull(this.mSpeedDisplayUnit);
        return this.mSpeedDisplayUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.getRawSpeedMetersPerSecond(), this.getDisplaySpeedMetersPerSecond(), this.mSpeedDisplayUnit});
    }

    @Override
    public String toString() {
        return "[ raw speed: " + this.getRawSpeedMetersPerSecond() + ", display speed: " + this.getDisplaySpeedMetersPerSecond() + ", speed display unit: " + this.mSpeedDisplayUnit + "]";
    }
}

