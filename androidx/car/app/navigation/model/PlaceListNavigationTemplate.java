package androidx.car.app.navigation.model;

import androidx.car.app.model.Action;
import androidx.car.app.model.ActionStrip;
import androidx.car.app.model.CarText;
import androidx.car.app.model.D;
import androidx.car.app.model.Header;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.Y;
import java.util.Objects;

public final class PlaceListNavigationTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final Header mHeader;
    @Deprecated
    private final Action mHeaderAction;
    private final boolean mIsLoading;
    private final ItemList mItemList;
    private final ActionStrip mMapActionStrip;
    private final D mOnContentRefreshDelegate;
    private final g mPanModeDelegate;
    @Deprecated
    private final CarText mTitle;

    private PlaceListNavigationTemplate() {
        this.mTitle = null;
        this.mIsLoading = false;
        this.mItemList = null;
        this.mHeader = null;
        this.mHeaderAction = null;
        this.mActionStrip = null;
        this.mMapActionStrip = null;
        this.mPanModeDelegate = null;
        this.mOnContentRefreshDelegate = null;
    }

    public PlaceListNavigationTemplate(j j0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlaceListNavigationTemplate)) {
            return false;
        }
        return this.mIsLoading != ((PlaceListNavigationTemplate)object0).mIsLoading || !Objects.equals(this.mTitle, ((PlaceListNavigationTemplate)object0).mTitle) || !Objects.equals(this.mItemList, ((PlaceListNavigationTemplate)object0).mItemList) || !Objects.equals(this.mHeaderAction, ((PlaceListNavigationTemplate)object0).mHeaderAction) || !Objects.equals(this.mActionStrip, ((PlaceListNavigationTemplate)object0).mActionStrip) || !Objects.equals(this.mMapActionStrip, ((PlaceListNavigationTemplate)object0).mMapActionStrip) || !Boolean.valueOf(this.mPanModeDelegate == null).equals(Boolean.valueOf(((PlaceListNavigationTemplate)object0).mPanModeDelegate == null)) ? false : Boolean.valueOf(this.mOnContentRefreshDelegate == null).equals(Boolean.valueOf(((PlaceListNavigationTemplate)object0).mOnContentRefreshDelegate == null)) && Objects.equals(this.mHeader, ((PlaceListNavigationTemplate)object0).mHeader);
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public Header getHeader() {
        return this.mHeader;
    }

    @Deprecated
    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public ItemList getItemList() {
        return this.mItemList;
    }

    public ActionStrip getMapActionStrip() {
        return this.mMapActionStrip;
    }

    public D getOnContentRefreshDelegate() {
        return this.mOnContentRefreshDelegate;
    }

    public g getPanModeDelegate() {
        return this.mPanModeDelegate;
    }

    @Deprecated
    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        CarText carText0 = this.mTitle;
        Boolean boolean0 = Boolean.valueOf(this.mIsLoading);
        ItemList itemList0 = this.mItemList;
        Action action0 = this.mHeaderAction;
        ActionStrip actionStrip0 = this.mActionStrip;
        ActionStrip actionStrip1 = this.mMapActionStrip;
        boolean z = false;
        Boolean boolean1 = Boolean.valueOf(this.mPanModeDelegate == null);
        if(this.mOnContentRefreshDelegate == null) {
            z = true;
        }
        return Objects.hash(new Object[]{carText0, boolean0, itemList0, action0, actionStrip0, actionStrip1, boolean1, Boolean.valueOf(z), this.mHeader});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "PlaceListNavigationTemplate";
    }
}

