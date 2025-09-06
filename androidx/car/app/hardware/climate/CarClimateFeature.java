package androidx.car.app.hardware.climate;

import java.util.List;
import java.util.Objects;
import s.a;

public final class CarClimateFeature {
    private final List mCarZones;
    private final int mFeature;

    public CarClimateFeature(a a0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return CarClimateFeature.class == class0 && this.mFeature.equals(((CarClimateFeature)object0).mFeature) && Objects.equals(this.mCarZones, ((CarClimateFeature)object0).mCarZones);
        }
        return false;
    }

    public List getCarZones() {
        return this.mCarZones;
    }

    public int getFeature() {
        return this.mFeature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mFeature, this.mCarZones});
    }

    @Override
    public String toString() {
        return "ClimateProfileFeature{mFeature=\'" + this.mFeature + "\', mCarZones=" + this.mCarZones + '}';
    }
}

