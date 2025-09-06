package com.viewpagerindicator;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class f implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState underlinePageIndicator$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        underlinePageIndicator$SavedState0.a = parcel0.readInt();
        return underlinePageIndicator$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

