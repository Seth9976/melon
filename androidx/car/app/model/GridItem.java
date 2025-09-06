package androidx.car.app.model;

import java.util.Objects;

public final class GridItem implements q {
    public static final int IMAGE_TYPE_ICON = 1;
    public static final int IMAGE_TYPE_LARGE = 2;
    private final Badge mBadge;
    private final CarIcon mImage;
    private final int mImageType;
    private final boolean mIsLoading;
    private final B mOnClickDelegate;
    private final CarText mText;
    private final CarText mTitle;

    private GridItem() {
        this.mIsLoading = false;
        this.mTitle = null;
        this.mText = null;
        this.mImage = null;
        this.mImageType = 2;
        this.mOnClickDelegate = null;
        this.mBadge = null;
    }

    public GridItem(k k0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof GridItem)) {
            return false;
        }
        return this.mIsLoading != ((GridItem)object0).mIsLoading || !Objects.equals(this.mTitle, ((GridItem)object0).mTitle) || !Objects.equals(this.mText, ((GridItem)object0).mText) || !Objects.equals(this.mImage, ((GridItem)object0).mImage) ? false : Boolean.valueOf(this.mOnClickDelegate == null).equals(Boolean.valueOf(((GridItem)object0).mOnClickDelegate == null)) && Objects.equals(this.mBadge, ((GridItem)object0).mBadge) && this.mImageType == ((GridItem)object0).mImageType;
    }

    public Badge getBadge() {
        return this.mBadge;
    }

    public CarIcon getImage() {
        return this.mImage;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public B getOnClickDelegate() {
        return this.mOnClickDelegate;
    }

    public CarText getText() {
        return this.mText;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        Boolean boolean0 = Boolean.valueOf(this.mIsLoading);
        Integer integer0 = this.mImageType;
        return this.mOnClickDelegate == null ? Objects.hash(new Object[]{boolean0, this.mTitle, this.mImage, integer0, Boolean.TRUE, this.mBadge}) : Objects.hash(new Object[]{boolean0, this.mTitle, this.mImage, integer0, Boolean.FALSE, this.mBadge});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "[title: " + CarText.toShortString(this.mTitle) + ", text: " + CarText.toShortString(this.mText) + ", image: " + this.mImage + ", isLoading: " + this.mIsLoading + ", badge: " + this.mBadge + "]";
    }
}

