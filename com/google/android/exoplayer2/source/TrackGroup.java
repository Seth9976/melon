package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Format[] formats;
    private int hashCode;
    public final int length;

    static {
        TrackGroup.CREATOR = new Parcelable.Creator() {
            public TrackGroup createFromParcel(Parcel parcel0) {
                return new TrackGroup(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public TrackGroup[] newArray(int v) {
                return new TrackGroup[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public TrackGroup(Parcel parcel0) {
        int v = parcel0.readInt();
        this.length = v;
        this.formats = new Format[v];
        for(int v1 = 0; v1 < this.length; ++v1) {
            this.formats[v1] = (Format)parcel0.readParcelable(Format.class.getClassLoader());
        }
    }

    public TrackGroup(Format[] arr_format) {
        Assertions.checkState(arr_format.length > 0);
        this.formats = arr_format;
        this.length = arr_format.length;
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
            return TrackGroup.class == class0 && this.length == ((TrackGroup)object0).length && Arrays.equals(this.formats, ((TrackGroup)object0).formats);
        }
        return false;
    }

    public Format getFormat(int v) {
        return this.formats[v];
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.formats) + 0x20F;
        }
        return this.hashCode;
    }

    public int indexOf(Format format0) {
        for(int v = 0; true; ++v) {
            Format[] arr_format = this.formats;
            if(v >= arr_format.length) {
                break;
            }
            if(format0 == arr_format[v]) {
                return v;
            }
        }
        return -1;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.length);
        for(int v1 = 0; v1 < this.length; ++v1) {
            parcel0.writeParcelable(this.formats[v1], 0);
        }
    }
}

