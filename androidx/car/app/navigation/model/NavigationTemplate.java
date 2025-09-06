package androidx.car.app.navigation.model;

import androidx.car.app.model.ActionStrip;
import androidx.car.app.model.CarColor;
import androidx.car.app.model.Toggle;
import androidx.car.app.model.Y;
import java.util.Objects;

public final class NavigationTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final CarColor mBackgroundColor;
    private final TravelEstimate mDestinationTravelEstimate;
    private final ActionStrip mMapActionStrip;
    private final f mNavigationInfo;
    private final g mPanModeDelegate;
    private final Toggle mPanModeToggle;

    private NavigationTemplate() {
        this.mNavigationInfo = null;
        this.mBackgroundColor = null;
        this.mDestinationTravelEstimate = null;
        this.mActionStrip = null;
        this.mMapActionStrip = null;
        this.mPanModeToggle = null;
        this.mPanModeDelegate = null;
    }

    public NavigationTemplate(e e0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof NavigationTemplate)) {
            return false;
        }
        return !Objects.equals(this.mNavigationInfo, ((NavigationTemplate)object0).mNavigationInfo) || !Objects.equals(this.mBackgroundColor, ((NavigationTemplate)object0).mBackgroundColor) || !Objects.equals(this.mDestinationTravelEstimate, ((NavigationTemplate)object0).mDestinationTravelEstimate) || !Objects.equals(this.mActionStrip, ((NavigationTemplate)object0).mActionStrip) || !Objects.equals(this.mMapActionStrip, ((NavigationTemplate)object0).mMapActionStrip) || !Objects.equals(this.mPanModeToggle, ((NavigationTemplate)object0).mPanModeToggle) ? false : Boolean.valueOf(this.mPanModeDelegate == null).equals(Boolean.valueOf(((NavigationTemplate)object0).mPanModeDelegate == null));
    }

    public ActionStrip getActionStrip() {
        Objects.requireNonNull(this.mActionStrip);
        return this.mActionStrip;
    }

    public CarColor getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public TravelEstimate getDestinationTravelEstimate() {
        return this.mDestinationTravelEstimate;
    }

    public ActionStrip getMapActionStrip() {
        return this.mMapActionStrip;
    }

    public f getNavigationInfo() {
        return this.mNavigationInfo;
    }

    public g getPanModeDelegate() {
        return this.mPanModeDelegate;
    }

    @Deprecated
    public Toggle getPanModeToggle() {
        return this.mPanModeToggle;
    }

    @Override
    public int hashCode() {
        return this.mPanModeDelegate == null ? Objects.hash(new Object[]{this.mNavigationInfo, this.mBackgroundColor, this.mDestinationTravelEstimate, this.mActionStrip, this.mMapActionStrip, this.mPanModeToggle, Boolean.TRUE}) : Objects.hash(new Object[]{this.mNavigationInfo, this.mBackgroundColor, this.mDestinationTravelEstimate, this.mActionStrip, this.mMapActionStrip, this.mPanModeToggle, Boolean.FALSE});
    }

    @Override
    public String toString() {
        return "NavigationTemplate";
    }
}

