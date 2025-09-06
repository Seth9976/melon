package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.material.internal.ParcelableSparseArray;

public final class f implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        NavigationBarPresenter.SavedState navigationBarPresenter$SavedState0 = new NavigationBarPresenter.SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        navigationBarPresenter$SavedState0.a = parcel0.readInt();
        navigationBarPresenter$SavedState0.b = (ParcelableSparseArray)parcel0.readParcelable(NavigationBarPresenter.SavedState.class.getClassLoader());
        return navigationBarPresenter$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new NavigationBarPresenter.SavedState[v];
    }
}

