package androidx.car.app.model;

import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

public final class CarIcon {
    public static final CarIcon ALERT = null;
    public static final CarIcon APP_ICON = null;
    public static final CarIcon BACK = null;
    public static final CarIcon COMPOSE_MESSAGE = null;
    public static final CarIcon ERROR = null;
    public static final CarIcon PAN = null;
    public static final int TYPE_ALERT = 4;
    public static final int TYPE_APP_ICON = 5;
    public static final int TYPE_BACK = 3;
    public static final int TYPE_COMPOSE_MESSAGE = 8;
    public static final int TYPE_CUSTOM = 1;
    public static final int TYPE_ERROR = 6;
    public static final int TYPE_PAN = 7;
    private static final int TYPE_RESOURCE = 2;
    private static final int TYPE_URI = 4;
    private final IconCompat mIcon;
    private final CarColor mTint;
    private final int mType;

    static {
        CarIcon.APP_ICON = CarIcon.forStandardType(5);
        CarIcon.BACK = CarIcon.forStandardType(3);
        CarIcon.ALERT = CarIcon.forStandardType(4);
        CarIcon.ERROR = CarIcon.forStandardType(6);
        CarIcon.PAN = CarIcon.forStandardType(7);
        CarIcon.COMPOSE_MESSAGE = CarIcon.forStandardType(8);
    }

    private CarIcon() {
        this.mType = 1;
        this.mIcon = null;
        this.mTint = null;
    }

    public CarIcon(IconCompat iconCompat0, CarColor carColor0, int v) {
        this.mType = v;
        this.mIcon = iconCompat0;
        this.mTint = carColor0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarIcon ? this.mType == ((CarIcon)object0).mType && Objects.equals(this.mTint, ((CarIcon)object0).mTint) && this.iconCompatEquals(((CarIcon)object0).mIcon) : false;
    }

    private static CarIcon forStandardType(int v) {
        return CarIcon.forStandardType(v, CarColor.DEFAULT);
    }

    private static CarIcon forStandardType(int v, CarColor carColor0) {
        return new CarIcon(null, carColor0, v);
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CarColor getTint() {
        return this.mTint;
    }

    public int getType() {
        return this.mType;
    }

    @Override
    public int hashCode() {
        Object object0 = this.iconCompatHash();
        return Objects.hash(new Object[]{this.mType, this.mTint, object0});
    }

    private boolean iconCompatEquals(IconCompat iconCompat0) {
        IconCompat iconCompat1 = this.mIcon;
        if(iconCompat1 == null) {
            return iconCompat0 == null;
        }
        if(iconCompat0 == null) {
            return false;
        }
        int v = iconCompat1.g();
        if(v != iconCompat0.g()) {
            return false;
        }
        switch(v) {
            case 2: {
                return Objects.equals(this.mIcon.f(), iconCompat0.f()) && this.mIcon.e() == iconCompat0.e();
            }
            case 4: {
                return Objects.equals(this.mIcon.h(), iconCompat0.h());
            }
            default: {
                return true;
            }
        }
    }

    private Object iconCompatHash() {
        IconCompat iconCompat0 = this.mIcon;
        if(iconCompat0 == null) {
            return null;
        }
        int v = iconCompat0.g();
        if(v == 2) {
            return this.mIcon.f() + this.mIcon.e();
        }
        return v == 4 ? this.mIcon.h() : v;
    }

    @Override
    public String toString() [...] // 潜在的解密器

    private static String typeToString(int v) {
        switch(v) {
            case 1: {
                return "CUSTOM";
            }
            case 3: {
                return "BACK";
            }
            case 4: {
                return "ALERT";
            }
            case 5: {
                return "APP";
            }
            case 6: {
                return "ERROR";
            }
            case 7: {
                return "PAN";
            }
            case 8: {
                return "COMPOSE_MESSAGE";
            }
            default: {
                return "<unknown>";
            }
        }
    }
}

