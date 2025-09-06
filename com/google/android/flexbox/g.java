package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class g implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        LayoutParams flexboxLayoutManager$LayoutParams0 = new LayoutParams(-2, -2);  // 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(II)V
        flexboxLayoutManager$LayoutParams0.f = 1.0f;
        flexboxLayoutManager$LayoutParams0.g = -1;
        flexboxLayoutManager$LayoutParams0.h = -1.0f;
        flexboxLayoutManager$LayoutParams0.k = 0xFFFFFF;
        flexboxLayoutManager$LayoutParams0.l = 0xFFFFFF;
        flexboxLayoutManager$LayoutParams0.e = parcel0.readFloat();
        flexboxLayoutManager$LayoutParams0.f = parcel0.readFloat();
        flexboxLayoutManager$LayoutParams0.g = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.h = parcel0.readFloat();
        flexboxLayoutManager$LayoutParams0.i = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.j = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.k = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.l = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.m = parcel0.readByte() != 0;
        flexboxLayoutManager$LayoutParams0.bottomMargin = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.leftMargin = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.rightMargin = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.topMargin = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.height = parcel0.readInt();
        flexboxLayoutManager$LayoutParams0.width = parcel0.readInt();
        return flexboxLayoutManager$LayoutParams0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LayoutParams[v];
    }
}

