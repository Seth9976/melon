package com.google.android.exoplayer2.metadata.icy;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class IcyInfo implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    static {
        IcyInfo.CREATOR = new Parcelable.Creator() {
            public IcyInfo createFromParcel(Parcel parcel0) {
                return new IcyInfo(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public IcyInfo[] newArray(int v) {
                return new IcyInfo[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public IcyInfo(Parcel parcel0) {
        this.rawMetadata = (byte[])Assertions.checkNotNull(parcel0.createByteArray());
        this.title = parcel0.readString();
        this.url = parcel0.readString();
    }

    public IcyInfo(byte[] arr_b, String s, String s1) {
        this.rawMetadata = arr_b;
        this.title = s;
        this.url = s1;
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
            return IcyInfo.class == class0 ? Arrays.equals(this.rawMetadata, ((IcyInfo)object0).rawMetadata) : false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = d.o("ICY: title=\"", this.title, "\", url=\"", this.url, "\", rawMetadata.length=\"");
        return x.g(this.rawMetadata.length, "\"", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeByteArray(this.rawMetadata);
        parcel0.writeString(this.title);
        parcel0.writeString(this.url);
    }
}

