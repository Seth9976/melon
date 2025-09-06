package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static {
        TimeModel.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public TimeModel(Parcel parcel0) {
        int v = parcel0.readInt();
        int v1 = parcel0.readInt();
        int v2 = parcel0.readInt();
        int v3 = parcel0.readInt();
        super();
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.a = v3;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TimeModel ? this.b == ((TimeModel)object0).b && this.c == ((TimeModel)object0).c && this.a == ((TimeModel)object0).a && this.d == ((TimeModel)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(this.a);
    }
}

