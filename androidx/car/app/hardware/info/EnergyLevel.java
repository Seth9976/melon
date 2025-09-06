package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.a;

public final class EnergyLevel {
    private final CarValue mBatteryPercent;
    private final CarValue mDistanceDisplayUnit;
    private final CarValue mEnergyIsLow;
    private final CarValue mFuelPercent;
    private final CarValue mFuelVolumeDisplayUnit;
    private final CarValue mRangeRemainingMeters;

    private EnergyLevel() {
        this.mBatteryPercent = CarValue.UNKNOWN_FLOAT;
        this.mFuelPercent = CarValue.UNKNOWN_FLOAT;
        this.mEnergyIsLow = CarValue.UNKNOWN_BOOLEAN;
        this.mRangeRemainingMeters = CarValue.UNKNOWN_FLOAT;
        this.mDistanceDisplayUnit = CarValue.UNKNOWN_INTEGER;
        this.mFuelVolumeDisplayUnit = CarValue.UNKNOWN_INTEGER;
    }

    public EnergyLevel(a a0) {
        throw null;
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EnergyLevel ? Objects.equals(this.mBatteryPercent, ((EnergyLevel)object0).mBatteryPercent) && Objects.equals(this.mFuelPercent, ((EnergyLevel)object0).mFuelPercent) && Objects.equals(this.mEnergyIsLow, ((EnergyLevel)object0).mEnergyIsLow) && Objects.equals(this.getRangeRemainingMeters(), ((EnergyLevel)object0).getRangeRemainingMeters()) && Objects.equals(this.mDistanceDisplayUnit, ((EnergyLevel)object0).mDistanceDisplayUnit) && Objects.equals(this.mFuelVolumeDisplayUnit, ((EnergyLevel)object0).mFuelVolumeDisplayUnit) : false;
    }

    public CarValue getBatteryPercent() {
        Objects.requireNonNull(this.mBatteryPercent);
        return this.mBatteryPercent;
    }

    public CarValue getDistanceDisplayUnit() {
        Objects.requireNonNull(this.mDistanceDisplayUnit);
        return this.mDistanceDisplayUnit;
    }

    public CarValue getEnergyIsLow() {
        Objects.requireNonNull(this.mEnergyIsLow);
        return this.mEnergyIsLow;
    }

    public CarValue getFuelPercent() {
        Objects.requireNonNull(this.mFuelPercent);
        return this.mFuelPercent;
    }

    public CarValue getFuelVolumeDisplayUnit() {
        Objects.requireNonNull(this.mFuelVolumeDisplayUnit);
        return this.mFuelVolumeDisplayUnit;
    }

    public CarValue getRangeRemainingMeters() {
        Objects.requireNonNull(this.mRangeRemainingMeters);
        return this.mRangeRemainingMeters;
    }

    @Override
    public int hashCode() {
        CarValue carValue0 = this.getRangeRemainingMeters();
        return Objects.hash(new Object[]{this.mBatteryPercent, this.mFuelPercent, this.mEnergyIsLow, carValue0, this.mDistanceDisplayUnit, this.mFuelVolumeDisplayUnit});
    }

    @Override
    public String toString() {
        return "[ battery percent: " + this.mBatteryPercent + ", fuel percent: " + this.mFuelPercent + ", energyIsLow: " + this.mEnergyIsLow + ", range remaining: " + this.getRangeRemainingMeters() + ", distance display unit: " + this.mDistanceDisplayUnit + ", fuel volume display unit: " + this.mFuelVolumeDisplayUnit + "]";
    }
}

