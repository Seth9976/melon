package com.iloen.melon.types;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;

public class BasicNameValuePair implements Parcelable, Cloneable {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;

    static {
        BasicNameValuePair.CREATOR = new e(29);
    }

    public BasicNameValuePair(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
    }

    public BasicNameValuePair(String s, String s1) {
        if(s == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = s;
        this.b = s1;
    }

    @Override
    public final Object clone() {
        return super.clone();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof BasicNameValuePair)) {
            return false;
        }
        String s = ((BasicNameValuePair)object0).a;
        if(s != null && s.equals(this.a)) {
            String s1 = ((BasicNameValuePair)object0).b;
            return s1 != null && s1.equals(this.b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 + 0x20F) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return this.a + "=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
    }
}

