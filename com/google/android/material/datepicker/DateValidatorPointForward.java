package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class DateValidatorPointForward implements DateValidator {
    public static final Parcelable.Creator CREATOR;
    public final long a;

    static {
        DateValidatorPointForward.CREATOR = new u(2);
    }

    public DateValidatorPointForward(long v) {
        this.a = v;
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
        return object0 instanceof DateValidatorPointForward ? this.a == ((DateValidatorPointForward)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    @Override  // com.google.android.material.datepicker.CalendarConstraints$DateValidator
    public final boolean i(long v) {
        return v >= this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
    }
}

