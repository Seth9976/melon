package androidx.car.app.hardware.common;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import k8.Y;

public final class CarValue {
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNAVAILABLE = 3;
    public static final int STATUS_UNIMPLEMENTED = 2;
    public static final int STATUS_UNKNOWN;
    public static final CarValue UNIMPLEMENTED_FLOAT_LIST;
    public static final CarValue UNIMPLEMENTED_INTEGER;
    public static final CarValue UNKNOWN_BOOLEAN;
    public static final CarValue UNKNOWN_FLOAT;
    public static final CarValue UNKNOWN_FLOAT_LIST;
    public static final CarValue UNKNOWN_INTEGER;
    public static final CarValue UNKNOWN_INTEGER_LIST;
    public static final CarValue UNKNOWN_STRING;
    private final List mCarZones;
    private final int mStatus;
    private final long mTimestampMillis;
    private final Object mValue;

    static {
        CarValue.UNIMPLEMENTED_INTEGER = CarValue.unimplemented();
        CarValue.UNKNOWN_INTEGER = CarValue.unknown();
        CarValue.UNKNOWN_BOOLEAN = CarValue.unknown();
        CarValue.UNKNOWN_FLOAT = CarValue.unknown();
        CarValue.UNKNOWN_STRING = CarValue.unknown();
        CarValue.UNIMPLEMENTED_FLOAT_LIST = CarValue.unimplemented();
        CarValue.UNKNOWN_FLOAT_LIST = CarValue.unknown();
        CarValue.UNKNOWN_INTEGER_LIST = CarValue.unknown();
    }

    private CarValue() {
        this.mValue = null;
        this.mTimestampMillis = 0L;
        this.mStatus = 0;
        this.mCarZones = Collections.EMPTY_LIST;
    }

    public CarValue(Object object0, long v, int v1) {
        this.mValue = object0;
        this.mTimestampMillis = v;
        this.mStatus = v1;
        this.mCarZones = Collections.singletonList(CarZone.CAR_ZONE_GLOBAL);
    }

    public CarValue(Object object0, long v, int v1, List list0) {
        this.mValue = object0;
        this.mTimestampMillis = v;
        this.mStatus = v1;
        this.mCarZones = list0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarValue ? Objects.equals(this.mValue, ((CarValue)object0).mValue) && this.mTimestampMillis == ((CarValue)object0).mTimestampMillis && this.mStatus == ((CarValue)object0).mStatus && Objects.equals(this.mCarZones, ((CarValue)object0).mCarZones) : false;
    }

    public List getCarZones() {
        return this.mStatus == 2 ? Collections.EMPTY_LIST : this.mCarZones;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public long getTimestampMillis() {
        return this.mTimestampMillis;
    }

    public Object getValue() {
        return this.mValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mValue, this.mTimestampMillis, this.mStatus, this.mCarZones});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[value: ");
        stringBuilder0.append(this.mValue);
        stringBuilder0.append(", timestamp: ");
        stringBuilder0.append(this.mTimestampMillis);
        stringBuilder0.append(", Status: ");
        stringBuilder0.append(this.mStatus);
        stringBuilder0.append(", CarZones: ");
        return Y.m(stringBuilder0, this.mCarZones, "]");
    }

    private static CarValue unimplemented() {
        return new CarValue(null, 0L, 2);
    }

    private static CarValue unknown() {
        return new CarValue(null, 0L, 0);
    }
}

