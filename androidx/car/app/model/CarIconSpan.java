package androidx.car.app.model;

import U4.x;
import java.util.Objects;
import v.b;

public final class CarIconSpan extends CarSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int mAlignment;
    private final CarIcon mIcon;

    private CarIconSpan() {
        this.mIcon = null;
        this.mAlignment = 1;
    }

    private CarIconSpan(CarIcon carIcon0, int v) {
        this.mIcon = carIcon0;
        this.mAlignment = v;
    }

    private static String alignmentToString(int v) {
        switch(v) {
            case 0: {
                return "bottom";
            }
            case 1: {
                return "baseline";
            }
            case 2: {
                return "center";
            }
            default: {
                return "unknown";
            }
        }
    }

    public static CarIconSpan create(CarIcon carIcon0) {
        return CarIconSpan.create(carIcon0, 1);
    }

    public static CarIconSpan create(CarIcon carIcon0, int v) {
        b.b.a(carIcon0);
        if(v != 0 && v != 1 && v != 2) {
            throw new IllegalStateException("Invalid alignment value: " + v);
        }
        Objects.requireNonNull(carIcon0);
        return new CarIconSpan(carIcon0, v);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarIconSpan ? Objects.equals(this.mIcon, ((CarIconSpan)object0).mIcon) : false;
    }

    public int getAlignment() {
        return this.mAlignment;
    }

    public CarIcon getIcon() {
        Objects.requireNonNull(this.mIcon);
        return this.mIcon;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mIcon);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[icon: ");
        stringBuilder0.append(this.mIcon);
        stringBuilder0.append(", alignment: ");
        return x.m(stringBuilder0, CarIconSpan.alignmentToString(this.mAlignment), "]");
    }
}

