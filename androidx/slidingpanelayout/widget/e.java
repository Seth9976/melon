package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class e implements Parcelable.ClassLoaderCreator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new SavedState(parcel0);
    }

    @Override  // android.os.Parcelable$ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
        return new SavedState(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

