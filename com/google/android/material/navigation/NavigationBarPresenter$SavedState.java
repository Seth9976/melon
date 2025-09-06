package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

class NavigationBarPresenter.SavedState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int a;
    public ParcelableSparseArray b;

    static {
        NavigationBarPresenter.SavedState.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeParcelable(this.b, 0);
    }
}

