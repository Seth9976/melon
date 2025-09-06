package com.google.android.material.checkbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState materialCheckBox$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        materialCheckBox$SavedState0.a = (int)(((Integer)parcel0.readValue(SavedState.class.getClassLoader())));
        return materialCheckBox$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

