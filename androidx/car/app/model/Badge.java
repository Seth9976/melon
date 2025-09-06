package androidx.car.app.model;

import java.util.Objects;

public class Badge {
    private final CarColor mBackgroundColor;
    private final boolean mHasDot;
    private final CarIcon mIcon;

    private Badge() {
        this.mHasDot = false;
        this.mBackgroundColor = null;
        this.mIcon = null;
    }

    public Badge(h h0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Badge ? this.mHasDot == ((Badge)object0).mHasDot && Objects.equals(this.mBackgroundColor, ((Badge)object0).mBackgroundColor) && Objects.equals(this.mIcon, ((Badge)object0).mIcon) : false;
    }

    public CarColor getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public CarIcon getIcon() {
        return this.mIcon;
    }

    public boolean hasDot() {
        return this.mHasDot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mHasDot), this.mBackgroundColor, this.mIcon});
    }

    @Override
    public String toString() {
        return "[hasDot: " + this.mHasDot + ", backgroundColor: " + this.mBackgroundColor + ", icon: " + this.mIcon + "]";
    }
}

