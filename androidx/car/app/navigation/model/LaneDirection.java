package androidx.car.app.navigation.model;

import androidx.appcompat.app.o;
import java.util.Objects;

public final class LaneDirection {
    public static final int SHAPE_NORMAL_LEFT = 5;
    public static final int SHAPE_NORMAL_RIGHT = 6;
    public static final int SHAPE_SHARP_LEFT = 7;
    public static final int SHAPE_SHARP_RIGHT = 8;
    public static final int SHAPE_SLIGHT_LEFT = 3;
    public static final int SHAPE_SLIGHT_RIGHT = 4;
    public static final int SHAPE_STRAIGHT = 2;
    public static final int SHAPE_UNKNOWN = 1;
    public static final int SHAPE_U_TURN_LEFT = 9;
    public static final int SHAPE_U_TURN_RIGHT = 10;
    private final boolean mIsRecommended;
    private final int mShape;

    private LaneDirection() {
        this.mShape = 1;
        this.mIsRecommended = false;
    }

    private LaneDirection(int v, boolean z) {
        this.mShape = v;
        this.mIsRecommended = z;
    }

    public static LaneDirection create(int v, boolean z) {
        return new LaneDirection(v, z);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof LaneDirection ? this.mShape == ((LaneDirection)object0).mShape && this.mIsRecommended == ((LaneDirection)object0).mIsRecommended : false;
    }

    public int getShape() {
        return this.mShape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mShape, Boolean.valueOf(this.mIsRecommended)});
    }

    public boolean isRecommended() {
        return this.mIsRecommended;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[shape: ");
        stringBuilder0.append(this.mShape);
        stringBuilder0.append(", isRecommended: ");
        return o.s(stringBuilder0, this.mIsRecommended, "]");
    }
}

