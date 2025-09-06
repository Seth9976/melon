package androidx.car.app.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class GridTemplate implements Y {
    public static final int ITEM_IMAGE_SHAPE_CIRCLE = 2;
    public static final int ITEM_IMAGE_SHAPE_UNSET = 1;
    public static final int ITEM_SIZE_LARGE = 4;
    public static final int ITEM_SIZE_MEDIUM = 2;
    public static final int ITEM_SIZE_SMALL = 1;
    private final ActionStrip mActionStrip;
    private final List mActions;
    private final Action mHeaderAction;
    private final boolean mIsLoading;
    private final int mItemImageShape;
    private final int mItemSize;
    private final ItemList mSingleList;
    private final CarText mTitle;

    private GridTemplate() {
        this.mIsLoading = false;
        this.mTitle = null;
        this.mHeaderAction = null;
        this.mSingleList = null;
        this.mActionStrip = null;
        this.mActions = Collections.EMPTY_LIST;
        this.mItemSize = 1;
        this.mItemImageShape = 1;
    }

    public GridTemplate(l l0) {
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof GridTemplate ? this.mIsLoading == ((GridTemplate)object0).mIsLoading && Objects.equals(this.mTitle, ((GridTemplate)object0).mTitle) && Objects.equals(this.mHeaderAction, ((GridTemplate)object0).mHeaderAction) && Objects.equals(this.mSingleList, ((GridTemplate)object0).mSingleList) && Objects.equals(this.mActionStrip, ((GridTemplate)object0).mActionStrip) && Objects.equals(this.mActions, ((GridTemplate)object0).mActions) && this.mItemSize == ((GridTemplate)object0).mItemSize && this.mItemImageShape == ((GridTemplate)object0).mItemImageShape : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public List getActions() {
        return this.mActions;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public int getItemImageShape() {
        return this.mItemImageShape;
    }

    public int getItemSize() {
        return this.mItemSize;
    }

    public ItemList getSingleList() {
        return this.mSingleList;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mIsLoading), this.mTitle, this.mHeaderAction, this.mSingleList, this.mActionStrip, this.mItemSize, this.mItemImageShape});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "GridTemplate";
    }
}

