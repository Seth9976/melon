package com.iloen.melon.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class m implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState checkableTextView$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        checkableTextView$SavedState0.a = ((Boolean)parcel0.readValue(null)).booleanValue();
        return checkableTextView$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

