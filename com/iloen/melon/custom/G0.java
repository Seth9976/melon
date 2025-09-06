package com.iloen.melon.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.types.MediaAttachInfo;

public final class g0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState mediaAttachmentView$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        mediaAttachmentView$SavedState0.a = (MediaAttachInfo)parcel0.readSerializable();
        return mediaAttachmentView$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

