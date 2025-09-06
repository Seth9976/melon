package androidx.car.app.model;

import java.util.Locale;
import java.util.Objects;

public final class Distance {
    public static final int UNIT_FEET = 6;
    public static final int UNIT_KILOMETERS = 2;
    public static final int UNIT_KILOMETERS_P1 = 3;
    public static final int UNIT_METERS = 1;
    public static final int UNIT_MILES = 4;
    public static final int UNIT_MILES_P1 = 5;
    public static final int UNIT_YARDS = 7;
    private final double mDisplayDistance;
    private final int mDisplayUnit;

    private Distance() {
        this.mDisplayDistance = 0.0;
        this.mDisplayUnit = 1;
    }

    private Distance(double f, int v) {
        this.mDisplayDistance = f;
        this.mDisplayUnit = v;
    }

    public static Distance create(double f, int v) {
        if(f < 0.0) {
            throw new IllegalArgumentException("displayDistance must be a positive value");
        }
        return new Distance(f, v);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Distance ? this.mDisplayUnit == ((Distance)object0).mDisplayUnit && this.mDisplayDistance == ((Distance)object0).mDisplayDistance : false;
    }

    public double getDisplayDistance() {
        return this.mDisplayDistance;
    }

    public int getDisplayUnit() {
        return this.mDisplayUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mDisplayDistance, this.mDisplayUnit});
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.04f%s", this.mDisplayDistance, Distance.unitToString(this.mDisplayUnit));
    }

    private static String unitToString(int v) {
        switch(v) {
            case 1: {
                return "m";
            }
            case 2: {
                return "km";
            }
            case 3: {
                return "km_p1";
            }
            case 4: {
                return "mi";
            }
            case 5: {
                return "mi_p1";
            }
            case 6: {
                return "ft";
            }
            case 7: {
                return "yd";
            }
            default: {
                return "?";
            }
        }
    }
}

