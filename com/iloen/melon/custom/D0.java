package com.iloen.melon.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class d0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState mediaAttachmentLayout$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        mediaAttachmentLayout$SavedState0.a = (List)parcel0.readSerializable();
        return mediaAttachmentLayout$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

