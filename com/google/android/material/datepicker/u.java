package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class u implements Parcelable.Creator {
    public final int a;

    public u(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                return Month.a(parcel0.readInt(), parcel0.readInt());
            }
            case 1: {
                return new DateValidatorPointBackward(parcel0.readLong());
            }
            case 2: {
                return new DateValidatorPointForward(parcel0.readLong());
            }
            case 3: {
                RangeDateSelector rangeDateSelector0 = new RangeDateSelector();  // 初始化器: Ljava/lang/Object;-><init>()V
                rangeDateSelector0.c = null;
                rangeDateSelector0.d = null;
                rangeDateSelector0.e = null;
                rangeDateSelector0.b = (Long)parcel0.readValue(Long.class.getClassLoader());
                rangeDateSelector0.c = (Long)parcel0.readValue(Long.class.getClassLoader());
                return rangeDateSelector0;
            }
            default: {
                SingleDateSelector singleDateSelector0 = new SingleDateSelector();  // 初始化器: Ljava/lang/Object;-><init>()V
                singleDateSelector0.a = (Long)parcel0.readValue(Long.class.getClassLoader());
                return singleDateSelector0;
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new Month[v];
            }
            case 1: {
                return new DateValidatorPointBackward[v];
            }
            case 2: {
                return new DateValidatorPointForward[v];
            }
            case 3: {
                return new RangeDateSelector[v];
            }
            default: {
                return new SingleDateSelector[v];
            }
        }
    }
}

