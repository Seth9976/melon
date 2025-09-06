package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "PRIV";
    public final String owner;
    public final byte[] privateData;

    static {
        PrivFrame.CREATOR = new Parcelable.Creator() {
            public PrivFrame createFromParcel(Parcel parcel0) {
                return new PrivFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public PrivFrame[] newArray(int v) {
                return new PrivFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public PrivFrame(Parcel parcel0) {
        super("PRIV");
        this.owner = (String)Util.castNonNull(parcel0.readString());
        this.privateData = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public PrivFrame(String s, byte[] arr_b) {
        super("PRIV");
        this.owner = s;
        this.privateData = arr_b;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return PrivFrame.class == class0 && Util.areEqual(this.owner, ((PrivFrame)object0).owner) && Arrays.equals(this.privateData, ((PrivFrame)object0).privateData);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.owner == null ? Arrays.hashCode(this.privateData) + 0x3FD1 : Arrays.hashCode(this.privateData) + (this.owner.hashCode() + 0x20F) * 0x1F;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.id + ": owner=" + this.owner;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.owner);
        parcel0.writeByteArray(this.privateData);
    }
}

