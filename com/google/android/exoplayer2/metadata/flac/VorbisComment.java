package com.google.android.exoplayer2.metadata.flac;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Util;

public final class VorbisComment implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final String key;
    public final String value;

    static {
        VorbisComment.CREATOR = new Parcelable.Creator() {
            public VorbisComment createFromParcel(Parcel parcel0) {
                return new VorbisComment(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public VorbisComment[] newArray(int v) {
                return new VorbisComment[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public VorbisComment(Parcel parcel0) {
        this.key = (String)Util.castNonNull(parcel0.readString());
        this.value = (String)Util.castNonNull(parcel0.readString());
    }

    public VorbisComment(String s, String s1) {
        this.key = s;
        this.value = s1;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return VorbisComment.class == class0 && this.key.equals(((VorbisComment)object0).key) && this.value.equals(((VorbisComment)object0).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.value.hashCode() + x.b(0x20F, 0x1F, this.key);
    }

    @Override
    public String toString() {
        return "VC: " + this.key + "=" + this.value;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.key);
        parcel0.writeString(this.value);
    }
}

