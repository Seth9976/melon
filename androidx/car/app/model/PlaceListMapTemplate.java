package androidx.car.app.model;

import java.util.Objects;

public final class PlaceListMapTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final Place mAnchor;
    private final Action mHeaderAction;
    private final boolean mIsLoading;
    private final ItemList mItemList;
    private final D mOnContentRefreshDelegate;
    private final boolean mShowCurrentLocation;
    private final CarText mTitle;

    private PlaceListMapTemplate() {
        this.mShowCurrentLocation = false;
        this.mIsLoading = false;
        this.mTitle = null;
        this.mItemList = null;
        this.mHeaderAction = null;
        this.mActionStrip = null;
        this.mAnchor = null;
        this.mOnContentRefreshDelegate = null;
    }

    public PlaceListMapTemplate(L l0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlaceListMapTemplate)) {
            return false;
        }
        return this.mShowCurrentLocation != ((PlaceListMapTemplate)object0).mShowCurrentLocation || this.mIsLoading != ((PlaceListMapTemplate)object0).mIsLoading || !Objects.equals(this.mTitle, ((PlaceListMapTemplate)object0).mTitle) || !Objects.equals(this.mItemList, ((PlaceListMapTemplate)object0).mItemList) || !Objects.equals(this.mHeaderAction, ((PlaceListMapTemplate)object0).mHeaderAction) || !Objects.equals(this.mActionStrip, ((PlaceListMapTemplate)object0).mActionStrip) || !Objects.equals(this.mAnchor, ((PlaceListMapTemplate)object0).mAnchor) ? false : Boolean.valueOf(this.mOnContentRefreshDelegate == null).equals(Boolean.valueOf(((PlaceListMapTemplate)object0).mOnContentRefreshDelegate == null));
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public Place getAnchor() {
        return this.mAnchor;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public ItemList getItemList() {
        return this.mItemList;
    }

    public D getOnContentRefreshDelegate() {
        return this.mOnContentRefreshDelegate;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        Boolean boolean0 = Boolean.valueOf(this.mShowCurrentLocation);
        Boolean boolean1 = Boolean.valueOf(this.mIsLoading);
        return this.mOnContentRefreshDelegate == null ? Objects.hash(new Object[]{boolean0, boolean1, this.mTitle, this.mItemList, this.mHeaderAction, this.mActionStrip, this.mAnchor, Boolean.TRUE}) : Objects.hash(new Object[]{boolean0, boolean1, this.mTitle, this.mItemList, this.mHeaderAction, this.mActionStrip, this.mAnchor, Boolean.FALSE});
    }

    public boolean isCurrentLocationEnabled() {
        return this.mShowCurrentLocation;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "PlaceListMapTemplate";
    }
}

