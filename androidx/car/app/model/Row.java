package androidx.car.app.model;

import androidx.appcompat.app.o;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Row implements q {
    public static final int IMAGE_TYPE_ICON = 4;
    public static final int IMAGE_TYPE_LARGE = 2;
    public static final int IMAGE_TYPE_SMALL = 1;
    public static final int NO_DECORATION = -1;
    private static final String YOUR_BOAT = "\uD83D\uDEA3";
    private final List mActions;
    private final CarIcon mImage;
    private final boolean mIsBrowsable;
    private final boolean mIsEnabled;
    private final Metadata mMetadata;
    private final int mNumericDecoration;
    private final B mOnClickDelegate;
    private final int mRowImageType;
    private final List mTexts;
    private final CarText mTitle;
    private final Toggle mToggle;

    private Row() {
        this.mTitle = null;
        this.mTexts = Collections.EMPTY_LIST;
        this.mImage = null;
        this.mActions = Collections.EMPTY_LIST;
        this.mNumericDecoration = -1;
        this.mToggle = null;
        this.mOnClickDelegate = null;
        this.mMetadata = Metadata.EMPTY_METADATA;
        this.mIsBrowsable = false;
        this.mRowImageType = 1;
        this.mIsEnabled = true;
    }

    public Row(N n0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Row)) {
            return false;
        }
        if(Objects.equals(this.mTitle, ((Row)object0).mTitle) && Objects.equals(this.mTexts, ((Row)object0).mTexts) && Objects.equals(this.mImage, ((Row)object0).mImage) && Objects.equals(this.mToggle, ((Row)object0).mToggle) && (Boolean.valueOf(this.mOnClickDelegate == null).equals(Boolean.valueOf(((Row)object0).mOnClickDelegate == null)) && Objects.equals(this.mMetadata, ((Row)object0).mMetadata) && this.mIsBrowsable == ((Row)object0).mIsBrowsable && this.mRowImageType == ((Row)object0).mRowImageType)) {
            boolean z = ((Row)object0).isEnabled();
            return this.mIsEnabled == z;
        }
        return false;
    }

    public List getActions() {
        return this.mActions;
    }

    public CarIcon getImage() {
        return this.mImage;
    }

    public Metadata getMetadata() {
        return this.mMetadata;
    }

    public int getNumericDecoration() {
        return this.mNumericDecoration;
    }

    public B getOnClickDelegate() {
        return this.mOnClickDelegate;
    }

    public int getRowImageType() {
        return this.mRowImageType;
    }

    public List getTexts() {
        return this.mTexts == null ? Collections.EMPTY_LIST : this.mTexts;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    public Toggle getToggle() {
        return this.mToggle;
    }

    @Override
    public int hashCode() {
        return this.mOnClickDelegate == null ? Objects.hash(new Object[]{this.mTitle, this.mTexts, this.mImage, this.mToggle, Boolean.TRUE, this.mMetadata, Boolean.valueOf(this.mIsBrowsable), this.mRowImageType, Boolean.valueOf(this.mIsEnabled)}) : Objects.hash(new Object[]{this.mTitle, this.mTexts, this.mImage, this.mToggle, Boolean.FALSE, this.mMetadata, Boolean.valueOf(this.mIsBrowsable), this.mRowImageType, Boolean.valueOf(this.mIsEnabled)});
    }

    public boolean isBrowsable() {
        return this.mIsBrowsable;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public Row row() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[title: ");
        stringBuilder0.append(CarText.toShortString(this.mTitle));
        stringBuilder0.append(", text count: ");
        stringBuilder0.append((this.mTexts == null ? 0 : this.mTexts.size()));
        stringBuilder0.append(", image: ");
        stringBuilder0.append(this.mImage);
        stringBuilder0.append(", isBrowsable: ");
        stringBuilder0.append(this.mIsBrowsable);
        stringBuilder0.append(", isEnabled: ");
        return o.s(stringBuilder0, this.mIsEnabled, "]");
    }

    public CharSequence yourBoat() {
        return "\uD83D\uDEA3";
    }
}

