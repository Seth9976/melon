package androidx.car.app.navigation.model;

import androidx.car.app.model.Action;
import androidx.car.app.model.ActionStrip;
import androidx.car.app.model.CarText;
import androidx.car.app.model.Header;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.Y;
import java.util.Objects;

public final class RoutePreviewNavigationTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final Header mHeader;
    @Deprecated
    private final Action mHeaderAction;
    private final boolean mIsLoading;
    private final ItemList mItemList;
    private final ActionStrip mMapActionStrip;
    private final Action mNavigateAction;
    private final g mPanModeDelegate;
    @Deprecated
    private final CarText mTitle;

    private RoutePreviewNavigationTemplate() {
        this.mTitle = null;
        this.mIsLoading = false;
        this.mNavigateAction = null;
        this.mItemList = null;
        this.mHeader = null;
        this.mHeaderAction = null;
        this.mActionStrip = null;
        this.mMapActionStrip = null;
        this.mPanModeDelegate = null;
    }

    public RoutePreviewNavigationTemplate(k k0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof RoutePreviewNavigationTemplate)) {
            return false;
        }
        return this.mIsLoading != ((RoutePreviewNavigationTemplate)object0).mIsLoading || !Objects.equals(this.mTitle, ((RoutePreviewNavigationTemplate)object0).mTitle) || !Objects.equals(this.mNavigateAction, ((RoutePreviewNavigationTemplate)object0).mNavigateAction) || !Objects.equals(this.mItemList, ((RoutePreviewNavigationTemplate)object0).mItemList) || !Objects.equals(this.mHeaderAction, ((RoutePreviewNavigationTemplate)object0).mHeaderAction) || !Objects.equals(this.mActionStrip, ((RoutePreviewNavigationTemplate)object0).mActionStrip) || !Objects.equals(this.mMapActionStrip, ((RoutePreviewNavigationTemplate)object0).mMapActionStrip) ? false : Boolean.valueOf(this.mPanModeDelegate == null).equals(Boolean.valueOf(((RoutePreviewNavigationTemplate)object0).mPanModeDelegate == null)) && Objects.equals(this.mHeader, ((RoutePreviewNavigationTemplate)object0).mHeader);
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

    public Action getNavigateAction() {
        return this.mNavigateAction;
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
        Boolean boolean0 = Boolean.valueOf(this.mIsLoading);
        return this.mPanModeDelegate == null ? Objects.hash(new Object[]{this.mTitle, boolean0, this.mNavigateAction, this.mItemList, this.mHeaderAction, this.mActionStrip, this.mMapActionStrip, Boolean.TRUE, this.mHeader}) : Objects.hash(new Object[]{this.mTitle, boolean0, this.mNavigateAction, this.mItemList, this.mHeaderAction, this.mActionStrip, this.mMapActionStrip, Boolean.FALSE, this.mHeader});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "RoutePreviewNavigationTemplate";
    }
}

