package androidx.car.app.model;

import U4.x;
import java.util.Objects;

public final class PlaceMarker {
    private static final int MAX_LABEL_LENGTH = 3;
    public static final int TYPE_ICON = 0;
    public static final int TYPE_IMAGE = 1;
    private final CarColor mColor;
    private final CarIcon mIcon;
    private final int mIconType;
    private final CarText mLabel;

    private PlaceMarker() {
        this.mIcon = null;
        this.mIconType = 0;
        this.mLabel = null;
        this.mColor = null;
    }

    public PlaceMarker(M m0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof PlaceMarker ? Objects.equals(this.mIcon, ((PlaceMarker)object0).mIcon) && Objects.equals(this.mLabel, ((PlaceMarker)object0).mLabel) && Objects.equals(this.mColor, ((PlaceMarker)object0).mColor) && this.mIconType == ((PlaceMarker)object0).mIconType : false;
    }

    public CarColor getColor() {
        return this.mColor;
    }

    public CarIcon getIcon() {
        return this.mIcon;
    }

    public int getIconType() {
        return this.mIconType;
    }

    public CarText getLabel() {
        return this.mLabel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mIcon, this.mLabel, this.mColor, this.mIconType});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[");
        if(this.mIcon != null) {
            return x.m(stringBuilder0, "[type: CUSTOM, tint: null]", "]");
        }
        return this.mLabel == null ? x.m(stringBuilder0, super.toString(), "]") : x.m(stringBuilder0, CarText.toShortString(this.mLabel), "]");
    }
}

