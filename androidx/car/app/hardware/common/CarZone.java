package androidx.car.app.hardware.common;

import java.util.Objects;
import t.a;

public final class CarZone {
    public static final int CAR_ZONE_COLUMN_ALL = 16;
    public static final int CAR_ZONE_COLUMN_CENTER = 0x30;
    public static final int CAR_ZONE_COLUMN_DRIVER = 80;
    public static final int CAR_ZONE_COLUMN_LEFT = 0x20;
    public static final int CAR_ZONE_COLUMN_PASSENGER = 0x60;
    public static final int CAR_ZONE_COLUMN_RIGHT = 0x40;
    public static final CarZone CAR_ZONE_GLOBAL = null;
    public static final int CAR_ZONE_ROW_ALL = 0;
    public static final int CAR_ZONE_ROW_EXCLUDE_FIRST = 4;
    public static final int CAR_ZONE_ROW_FIRST = 1;
    public static final int CAR_ZONE_ROW_SECOND = 2;
    public static final int CAR_ZONE_ROW_THIRD = 3;
    private final int mColumn;
    private final int mRow;

    static {
        CarZone.CAR_ZONE_GLOBAL = new CarZone(new a());  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    private CarZone() {
        this.mRow = 0;
        this.mColumn = 0;
    }

    public CarZone(a a0) {
        a0.getClass();
        this.mRow = 0;
        this.mColumn = 16;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CarZone)) {
            return false;
        }
        Integer integer0 = ((CarZone)object0).getColumn();
        if(this.mColumn.equals(integer0)) {
            Integer integer1 = ((CarZone)object0).getRow();
            return this.mRow.equals(integer1);
        }
        return false;
    }

    public int getColumn() {
        return this.mColumn;
    }

    public int getRow() {
        return this.mRow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mRow, this.mColumn});
    }

    @Override
    public String toString() {
        String s;
        switch(this.mRow) {
            case 0: {
                s = "CAR_ZONE_ROW_ALL";
                break;
            }
            case 1: {
                s = "CAR_ZONE_ROW_FIRST";
                break;
            }
            case 2: {
                s = "CAR_ZONE_ROW_SECOND";
                break;
            }
            case 3: {
                s = "CAR_ZONE_ROW_THIRD";
                break;
            }
            case 4: {
                s = "CAR_ZONE_ROW_EXCLUDE_FIRST";
                break;
            }
            default: {
                s = "UNKNOWN";
            }
        }
        switch(this.mColumn) {
            case 16: {
                return "[CarZone row value: " + s + ", column value: " + "CAR_ZONE_COLUMN_ALL" + "]";
            }
            case 0x20: {
                return "[CarZone row value: " + s + ", column value: " + "CAR_ZONE_COLUMN_LEFT" + "]";
            }
            case 0x30: {
                return "[CarZone row value: " + s + ", column value: " + "CAR_ZONE_COLUMN_CENTER" + "]";
            }
            case 0x40: {
                return "[CarZone row value: " + s + ", column value: " + "CAR_ZONE_COLUMN_RIGHT" + "]";
            }
            case 80: {
                return "[CarZone row value: " + s + ", column value: " + "CAR_ZONE_COLUMN_DRIVER" + "]";
            }
            case 0x60: {
                return "[CarZone row value: " + s + ", column value: " + "CAR_ZONE_COLUMN_PASSENGER" + "]";
            }
            default: {
                return "[CarZone row value: " + s + ", column value: " + "UNKNOWN" + "]";
            }
        }
    }
}

