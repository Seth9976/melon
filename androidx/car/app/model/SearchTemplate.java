package androidx.car.app.model;

import java.util.Objects;

public final class SearchTemplate implements Y {
    private final ActionStrip mActionStrip;
    private final Action mHeaderAction;
    private final String mInitialSearchText;
    private final boolean mIsLoading;
    private final ItemList mItemList;
    private final O mSearchCallbackDelegate;
    private final String mSearchHint;
    private final boolean mShowKeyboardByDefault;

    private SearchTemplate() {
        this.mInitialSearchText = null;
        this.mSearchHint = null;
        this.mIsLoading = false;
        this.mItemList = null;
        this.mHeaderAction = null;
        this.mActionStrip = null;
        this.mSearchCallbackDelegate = null;
        this.mShowKeyboardByDefault = true;
    }

    public SearchTemplate(Q q0) {
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SearchTemplate ? this.mIsLoading == ((SearchTemplate)object0).mIsLoading && Objects.equals(this.mInitialSearchText, ((SearchTemplate)object0).mInitialSearchText) && Objects.equals(this.mSearchHint, ((SearchTemplate)object0).mSearchHint) && Objects.equals(this.mItemList, ((SearchTemplate)object0).mItemList) && Objects.equals(this.mHeaderAction, ((SearchTemplate)object0).mHeaderAction) && Objects.equals(this.mActionStrip, ((SearchTemplate)object0).mActionStrip) && this.mShowKeyboardByDefault == ((SearchTemplate)object0).mShowKeyboardByDefault : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public String getInitialSearchText() {
        return this.mInitialSearchText;
    }

    public ItemList getItemList() {
        return this.mItemList;
    }

    public O getSearchCallbackDelegate() {
        Objects.requireNonNull(this.mSearchCallbackDelegate);
        return this.mSearchCallbackDelegate;
    }

    public String getSearchHint() {
        return this.mSearchHint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mInitialSearchText, Boolean.valueOf(this.mIsLoading), this.mSearchHint, this.mItemList, Boolean.valueOf(this.mShowKeyboardByDefault), this.mHeaderAction, this.mActionStrip});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public boolean isShowKeyboardByDefault() {
        return this.mShowKeyboardByDefault;
    }

    @Override
    public String toString() {
        return "SearchTemplate";
    }
}

