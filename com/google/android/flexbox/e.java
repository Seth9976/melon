package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class e implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        boolean z = false;
        LayoutParams flexboxLayout$LayoutParams0 = new LayoutParams(0, 0);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V
        flexboxLayout$LayoutParams0.b = 0.0f;
        flexboxLayout$LayoutParams0.c = 1.0f;
        flexboxLayout$LayoutParams0.d = -1;
        flexboxLayout$LayoutParams0.e = -1.0f;
        flexboxLayout$LayoutParams0.h = 0xFFFFFF;
        flexboxLayout$LayoutParams0.i = 0xFFFFFF;
        flexboxLayout$LayoutParams0.a = parcel0.readInt();
        flexboxLayout$LayoutParams0.b = parcel0.readFloat();
        flexboxLayout$LayoutParams0.c = parcel0.readFloat();
        flexboxLayout$LayoutParams0.d = parcel0.readInt();
        flexboxLayout$LayoutParams0.e = parcel0.readFloat();
        flexboxLayout$LayoutParams0.f = parcel0.readInt();
        flexboxLayout$LayoutParams0.g = parcel0.readInt();
        flexboxLayout$LayoutParams0.h = parcel0.readInt();
        flexboxLayout$LayoutParams0.i = parcel0.readInt();
        if(parcel0.readByte() != 0) {
            z = true;
        }
        flexboxLayout$LayoutParams0.j = z;
        flexboxLayout$LayoutParams0.bottomMargin = parcel0.readInt();
        flexboxLayout$LayoutParams0.leftMargin = parcel0.readInt();
        flexboxLayout$LayoutParams0.rightMargin = parcel0.readInt();
        flexboxLayout$LayoutParams0.topMargin = parcel0.readInt();
        flexboxLayout$LayoutParams0.height = parcel0.readInt();
        flexboxLayout$LayoutParams0.width = parcel0.readInt();
        return flexboxLayout$LayoutParams0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new LayoutParams[v];
    }
}

