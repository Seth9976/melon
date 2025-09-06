package androidx.car.app.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TabTemplate implements Y {
    private final String mActiveTabContentId;
    private final Action mHeaderAction;
    private final boolean mIsLoading;
    private final U mTabCallbackDelegate;
    private final TabContents mTabContents;
    private final List mTabs;

    private TabTemplate() {
        this.mIsLoading = false;
        this.mHeaderAction = null;
        this.mTabs = Collections.EMPTY_LIST;
        this.mTabContents = null;
        this.mTabCallbackDelegate = null;
        this.mActiveTabContentId = null;
    }

    public TabTemplate(W w0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TabTemplate)) {
            return false;
        }
        if(this.mIsLoading == ((TabTemplate)object0).mIsLoading && Objects.equals(this.mHeaderAction, ((TabTemplate)object0).mHeaderAction) && Objects.equals(this.mTabs, ((TabTemplate)object0).mTabs) && Objects.equals(this.mTabContents, ((TabTemplate)object0).mTabContents)) {
            String s = ((TabTemplate)object0).getActiveTabContentId();
            return Objects.equals(this.mActiveTabContentId, s);
        }
        return false;
    }

    public String getActiveTabContentId() {
        Objects.requireNonNull(this.mActiveTabContentId);
        return this.mActiveTabContentId;
    }

    public Action getHeaderAction() {
        Objects.requireNonNull(this.mHeaderAction);
        return this.mHeaderAction;
    }

    public U getTabCallbackDelegate() {
        Objects.requireNonNull(this.mTabCallbackDelegate);
        return this.mTabCallbackDelegate;
    }

    public TabContents getTabContents() {
        Objects.requireNonNull(this.mTabContents);
        return this.mTabContents;
    }

    public List getTabs() {
        return this.mTabs == null ? Collections.EMPTY_LIST : this.mTabs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mIsLoading), this.mHeaderAction, this.mTabs, this.mTabContents, this.mActiveTabContentId});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "TabTemplate";
    }
}

