package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final TrackGroupArray EMPTY;
    private int hashCode;
    public final int length;
    private final TrackGroup[] trackGroups;

    static {
        TrackGroupArray.EMPTY = new TrackGroupArray(new TrackGroup[0]);
        TrackGroupArray.CREATOR = new Parcelable.Creator() {
            public TrackGroupArray createFromParcel(Parcel parcel0) {
                return new TrackGroupArray(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public TrackGroupArray[] newArray(int v) {
                return new TrackGroupArray[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public TrackGroupArray(Parcel parcel0) {
        int v = parcel0.readInt();
        this.length = v;
        this.trackGroups = new TrackGroup[v];
        for(int v1 = 0; v1 < this.length; ++v1) {
            this.trackGroups[v1] = (TrackGroup)parcel0.readParcelable(TrackGroup.class.getClassLoader());
        }
    }

    public TrackGroupArray(TrackGroup[] arr_trackGroup) {
        this.trackGroups = arr_trackGroup;
        this.length = arr_trackGroup.length;
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
            return TrackGroupArray.class == class0 && this.length == ((TrackGroupArray)object0).length && Arrays.equals(this.trackGroups, ((TrackGroupArray)object0).trackGroups);
        }
        return false;
    }

    public TrackGroup get(int v) {
        return this.trackGroups[v];
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public int indexOf(TrackGroup trackGroup0) {
        for(int v = 0; v < this.length; ++v) {
            if(this.trackGroups[v] == trackGroup0) {
                return v;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.length);
        for(int v1 = 0; v1 < this.length; ++v1) {
            parcel0.writeParcelable(this.trackGroups[v1], 0);
        }
    }
}

