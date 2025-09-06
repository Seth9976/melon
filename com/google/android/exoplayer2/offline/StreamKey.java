package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class StreamKey implements Parcelable, Comparable {
    public static final Parcelable.Creator CREATOR;
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    static {
        StreamKey.CREATOR = new Parcelable.Creator() {
            public StreamKey createFromParcel(Parcel parcel0) {
                return new StreamKey(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public StreamKey[] newArray(int v) {
                return new StreamKey[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public StreamKey(int v, int v1) {
        this(0, v, v1);
    }

    public StreamKey(int v, int v1, int v2) {
        this.periodIndex = v;
        this.groupIndex = v1;
        this.trackIndex = v2;
    }

    public StreamKey(Parcel parcel0) {
        this.periodIndex = parcel0.readInt();
        this.groupIndex = parcel0.readInt();
        this.trackIndex = parcel0.readInt();
    }

    public int compareTo(StreamKey streamKey0) {
        int v = this.periodIndex - streamKey0.periodIndex;
        if(v == 0) {
            v = this.groupIndex - streamKey0.groupIndex;
            return v == 0 ? this.trackIndex - streamKey0.trackIndex : v;
        }
        return v;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((StreamKey)object0));
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
            return StreamKey.class == class0 && this.periodIndex == ((StreamKey)object0).periodIndex && this.groupIndex == ((StreamKey)object0).groupIndex && this.trackIndex == ((StreamKey)object0).trackIndex;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.periodIndex * 0x1F + this.groupIndex) * 0x1F + this.trackIndex;
    }

    @Override
    public String toString() {
        return this.periodIndex + "." + this.groupIndex + "." + this.trackIndex;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.periodIndex);
        parcel0.writeInt(this.groupIndex);
        parcel0.writeInt(this.trackIndex);
    }
}

