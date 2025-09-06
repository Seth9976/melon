package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

public final class CalendarConstraints implements Parcelable {
    public interface DateValidator extends Parcelable {
        boolean i(long arg1);
    }

    public static final Parcelable.Creator CREATOR;
    public final Month a;
    public final Month b;
    public final DateValidator c;
    public final Month d;
    public final int e;
    public final int f;
    public final int g;

    static {
        CalendarConstraints.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public CalendarConstraints(Month month0, Month month1, DateValidator calendarConstraints$DateValidator0, Month month2, int v) {
        Objects.requireNonNull(month0, "start cannot be null");
        Objects.requireNonNull(month1, "end cannot be null");
        Objects.requireNonNull(calendarConstraints$DateValidator0, "validator cannot be null");
        this.a = month0;
        this.b = month1;
        this.d = month2;
        this.e = v;
        this.c = calendarConstraints$DateValidator0;
        if(month2 != null && month0.a.compareTo(month2.a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if(month2 != null && month2.a.compareTo(month1.a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if(v < 0 || v > E.g(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.g = month0.e(month1) + 1;
        this.f = month1.c - month0.c + 1;
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
        return object0 instanceof CalendarConstraints ? this.a.equals(((CalendarConstraints)object0).a) && this.b.equals(((CalendarConstraints)object0).b) && Objects.equals(this.d, ((CalendarConstraints)object0).d) && this.e == ((CalendarConstraints)object0).e && this.c.equals(((CalendarConstraints)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.d, this.e, this.c});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(this.a, 0);
        parcel0.writeParcelable(this.b, 0);
        parcel0.writeParcelable(this.d, 0);
        parcel0.writeParcelable(this.c, 0);
        parcel0.writeInt(this.e);
    }
}

