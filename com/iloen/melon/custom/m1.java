package com.iloen.melon.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class m1 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        Receiver toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
        toReceiverView$Receiver0.a = parcel0.readString();
        toReceiverView$Receiver0.b = parcel0.readString();
        toReceiverView$Receiver0.c = parcel0.readString();
        toReceiverView$Receiver0.d = parcel0.readString();
        toReceiverView$Receiver0.e = parcel0.readString();
        return toReceiverView$Receiver0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Receiver[v];
    }
}

