package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class j implements Parcelable.ClassLoaderCreator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new NavigationBarView.SavedState(parcel0, null);
    }

    @Override  // android.os.Parcelable$ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
        return new NavigationBarView.SavedState(parcel0, classLoader0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new NavigationBarView.SavedState[v];
    }
}

