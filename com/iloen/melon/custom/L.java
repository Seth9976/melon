package com.iloen.melon.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class l implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState checkableTagView$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        checkableTagView$SavedState0.a = ((Boolean)parcel0.readValue(null)).booleanValue();
        return checkableTagView$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

