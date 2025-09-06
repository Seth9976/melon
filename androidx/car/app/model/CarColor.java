package androidx.car.app.model;

import U4.x;
import java.util.Objects;

public final class CarColor {
    public static final CarColor BLUE = null;
    public static final CarColor DEFAULT = null;
    public static final CarColor GREEN = null;
    public static final CarColor PRIMARY = null;
    public static final CarColor RED = null;
    public static final CarColor SECONDARY = null;
    public static final int TYPE_BLUE = 6;
    public static final int TYPE_CUSTOM = 0;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_GREEN = 5;
    public static final int TYPE_PRIMARY = 2;
    public static final int TYPE_RED = 4;
    public static final int TYPE_SECONDARY = 3;
    public static final int TYPE_YELLOW = 7;
    public static final CarColor YELLOW;
    private final int mColor;
    private final int mColorDark;
    private final int mType;

    static {
        CarColor.DEFAULT = CarColor.create(1);
        CarColor.PRIMARY = CarColor.create(2);
        CarColor.SECONDARY = CarColor.create(3);
        CarColor.RED = CarColor.create(4);
        CarColor.GREEN = CarColor.create(5);
        CarColor.BLUE = CarColor.create(6);
        CarColor.YELLOW = CarColor.create(7);
    }

    private CarColor() {
        this.mType = 1;
        this.mColor = 0;
        this.mColorDark = 0;
    }

    private CarColor(int v, int v1, int v2) {
        this.mType = v;
        this.mColor = v1;
        this.mColorDark = v2;
    }

    private static CarColor create(int v) {
        return new CarColor(v, 0, 0);
    }

    public static CarColor createCustom(int v, int v1) {
        return new CarColor(0, v, v1);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarColor ? this.mColor == ((CarColor)object0).mColor && this.mColorDark == ((CarColor)object0).mColorDark && this.mType == ((CarColor)object0).mType : false;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getColorDark() {
        return this.mColorDark;
    }

    public int getType() {
        return this.mType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mType, this.mColor, this.mColorDark});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[type: ");
        stringBuilder0.append(CarColor.typeToString(this.mType));
        stringBuilder0.append(", color: ");
        stringBuilder0.append(this.mColor);
        stringBuilder0.append(", dark: ");
        return x.g(this.mColorDark, "]", stringBuilder0);
    }

    private static String typeToString(int v) {
        switch(v) {
            case 0: {
                return "CUSTOM";
            }
            case 1: {
                return "DEFAULT";
            }
            case 2: {
                return "PRIMARY";
            }
            case 3: {
                return "SECONDARY";
            }
            case 4: {
                return "RED";
            }
            case 5: {
                return "GREEN";
            }
            case 6: {
                return "BLUE";
            }
            case 7: {
                return "YELLOW";
            }
            default: {
                return "<unknown>";
            }
        }
    }
}

