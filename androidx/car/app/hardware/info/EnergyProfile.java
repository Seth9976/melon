package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.b;

public final class EnergyProfile {
    public static final int EVCONNECTOR_TYPE_CHADEMO = 3;
    public static final int EVCONNECTOR_TYPE_COMBO_1 = 4;
    public static final int EVCONNECTOR_TYPE_COMBO_2 = 5;
    public static final int EVCONNECTOR_TYPE_GBT = 9;
    public static final int EVCONNECTOR_TYPE_GBT_DC = 10;
    public static final int EVCONNECTOR_TYPE_J1772 = 1;
    public static final int EVCONNECTOR_TYPE_MENNEKES = 2;
    public static final int EVCONNECTOR_TYPE_OTHER = 101;
    public static final int EVCONNECTOR_TYPE_SCAME = 11;
    public static final int EVCONNECTOR_TYPE_TESLA_HPWC = 7;
    public static final int EVCONNECTOR_TYPE_TESLA_ROADSTER = 6;
    public static final int EVCONNECTOR_TYPE_TESLA_SUPERCHARGER = 8;
    public static final int EVCONNECTOR_TYPE_UNKNOWN = 0;
    public static final int FUEL_TYPE_BIODIESEL = 5;
    public static final int FUEL_TYPE_CNG = 8;
    public static final int FUEL_TYPE_DIESEL_1 = 3;
    public static final int FUEL_TYPE_DIESEL_2 = 4;
    public static final int FUEL_TYPE_E85 = 6;
    public static final int FUEL_TYPE_ELECTRIC = 10;
    public static final int FUEL_TYPE_HYDROGEN = 11;
    public static final int FUEL_TYPE_LEADED = 2;
    public static final int FUEL_TYPE_LNG = 9;
    public static final int FUEL_TYPE_LPG = 7;
    public static final int FUEL_TYPE_OTHER = 12;
    public static final int FUEL_TYPE_UNKNOWN = 0;
    public static final int FUEL_TYPE_UNLEADED = 1;
    private final CarValue mEvConnectorTypes;
    private final CarValue mFuelTypes;

    private EnergyProfile() {
        this.mEvConnectorTypes = CarValue.UNKNOWN_INTEGER_LIST;
        this.mFuelTypes = CarValue.UNKNOWN_INTEGER_LIST;
    }

    public EnergyProfile(b b0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EnergyProfile ? Objects.equals(this.mEvConnectorTypes, ((EnergyProfile)object0).mEvConnectorTypes) && Objects.equals(this.mFuelTypes, ((EnergyProfile)object0).mFuelTypes) : false;
    }

    public CarValue getEvConnectorTypes() {
        Objects.requireNonNull(this.mEvConnectorTypes);
        return this.mEvConnectorTypes;
    }

    public CarValue getFuelTypes() {
        Objects.requireNonNull(this.mFuelTypes);
        return this.mFuelTypes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mEvConnectorTypes, this.mFuelTypes});
    }

    @Override
    public String toString() {
        return "[ evConnectorTypes: " + this.mEvConnectorTypes + ", fuelTypes: " + this.mFuelTypes + "]";
    }
}

