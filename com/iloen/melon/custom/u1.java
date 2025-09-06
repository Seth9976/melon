package com.iloen.melon.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class u1 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState verticalProgressBar$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        verticalProgressBar$SavedState0.a = parcel0.readInt();
        verticalProgressBar$SavedState0.b = parcel0.readInt();
        return verticalProgressBar$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

