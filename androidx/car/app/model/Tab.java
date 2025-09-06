package androidx.car.app.model;

import java.util.Objects;

public final class Tab {
    private static final String EMPTY_TAB_CONTENT_ID = "EMPTY_TAB_CONTENT_ID";
    private final String mContentId;
    private final CarIcon mIcon;
    private final CarText mTitle;

    private Tab() {
        this.mTitle = null;
        this.mContentId = "EMPTY_TAB_CONTENT_ID";
        this.mIcon = null;
    }

    public Tab(T t0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Tab ? Objects.equals(this.mTitle, ((Tab)object0).mTitle) && Objects.equals(this.mContentId, ((Tab)object0).mContentId) && Objects.equals(this.mIcon, ((Tab)object0).mIcon) : false;
    }

    public String getContentId() {
        Objects.requireNonNull(this.mContentId);
        return this.mContentId;
    }

    public CarIcon getIcon() {
        Objects.requireNonNull(this.mIcon);
        return this.mIcon;
    }

    public CarText getTitle() {
        Objects.requireNonNull(this.mTitle);
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTitle, this.mContentId, this.mIcon});
    }

    @Override
    public String toString() {
        return "[title: " + CarText.toShortString(this.mTitle) + ", contentId: " + this.mContentId + ", icon: " + this.mIcon + "]";
    }
}

