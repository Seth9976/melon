package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class f implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SliderState baseSlider$SliderState0 = new SliderState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        baseSlider$SliderState0.a = parcel0.readFloat();
        baseSlider$SliderState0.b = parcel0.readFloat();
        ArrayList arrayList0 = new ArrayList();
        baseSlider$SliderState0.c = arrayList0;
        parcel0.readList(arrayList0, Float.class.getClassLoader());
        baseSlider$SliderState0.d = parcel0.readFloat();
        baseSlider$SliderState0.e = parcel0.createBooleanArray()[0];
        return baseSlider$SliderState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SliderState[v];
    }
}

