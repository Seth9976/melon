package androidx.car.app.model;

import java.util.Objects;
import v.a;

public final class ForegroundCarColorSpan extends CarSpan {
    private final CarColor mCarColor;

    private ForegroundCarColorSpan() {
        this.mCarColor = CarColor.DEFAULT;
    }

    private ForegroundCarColorSpan(CarColor carColor0) {
        this.mCarColor = carColor0;
    }

    public static ForegroundCarColorSpan create(CarColor carColor0) {
        a.b.getClass();
        if(!a.b.a.contains(carColor0.getType())) {
            throw new IllegalArgumentException("Car color type is not allowed: " + carColor0);
        }
        return new ForegroundCarColorSpan(carColor0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ForegroundCarColorSpan ? Objects.equals(this.mCarColor, ((ForegroundCarColorSpan)object0).mCarColor) : false;
    }

    public CarColor getColor() {
        return this.mCarColor;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mCarColor);
    }

    @Override
    public String toString() {
        return "[color: " + this.mCarColor + "]";
    }
}

