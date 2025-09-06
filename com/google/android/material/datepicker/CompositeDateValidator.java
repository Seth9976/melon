package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class CompositeDateValidator implements DateValidator {
    public static final Parcelable.Creator CREATOR;
    public final f a;
    public final ArrayList b;
    public static final c c;
    public static final d d;

    static {
        CompositeDateValidator.c = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        CompositeDateValidator.d = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        CompositeDateValidator.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public CompositeDateValidator(ArrayList arrayList0, f f0) {
        this.b = arrayList0;
        this.a = f0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof CompositeDateValidator && this.b.equals(((CompositeDateValidator)object0).b) && this.a.getId() == ((CompositeDateValidator)object0).a.getId();
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override  // com.google.android.material.datepicker.CalendarConstraints$DateValidator
    public final boolean i(long v) {
        return this.a.a(this.b, v);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeList(this.b);
        parcel0.writeInt(this.a.getId());
    }
}

