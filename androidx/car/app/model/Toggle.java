package androidx.car.app.model;

import androidx.appcompat.app.o;
import java.util.Objects;

public final class Toggle {
    private final boolean mIsChecked;
    private final boolean mIsEnabled;
    private final z mOnCheckedChangeDelegate;

    private Toggle() {
        this.mOnCheckedChangeDelegate = null;
        this.mIsChecked = false;
        this.mIsEnabled = true;
    }

    public Toggle(Z z0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Toggle ? this.mIsChecked == ((Toggle)object0).mIsChecked && this.mIsEnabled == ((Toggle)object0).mIsEnabled : false;
    }

    public z getOnCheckedChangeDelegate() {
        Objects.requireNonNull(this.mOnCheckedChangeDelegate);
        return this.mOnCheckedChangeDelegate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mIsChecked), Boolean.valueOf(this.mIsEnabled)});
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[ isChecked: ");
        stringBuilder0.append(this.mIsChecked);
        stringBuilder0.append(", isEnabled: ");
        return o.s(stringBuilder0, this.mIsEnabled, "]");
    }
}

