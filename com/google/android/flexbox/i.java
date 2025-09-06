package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class i implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState flexboxLayoutManager$SavedState0 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        flexboxLayoutManager$SavedState0.a = parcel0.readInt();
        flexboxLayoutManager$SavedState0.b = parcel0.readInt();
        return flexboxLayoutManager$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

