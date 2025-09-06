package com.iloen.melon.sns.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class d implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        SharableLive sharableLive0 = new SharableLive();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharableLive0.a = parcel0.readString();
        sharableLive0.b = parcel0.readString();
        sharableLive0.d = parcel0.readString();
        sharableLive0.e = parcel0.readString();
        sharableLive0.f = (ShareLinkData)parcel0.readParcelable(ShareLinkData.class.getClassLoader());
        return sharableLive0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SharableLive[v];
    }
}

