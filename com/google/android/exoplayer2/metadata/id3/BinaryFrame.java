package com.google.android.exoplayer2.metadata.id3;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final byte[] data;

    static {
        BinaryFrame.CREATOR = new Parcelable.Creator() {
            public BinaryFrame createFromParcel(Parcel parcel0) {
                return new BinaryFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public BinaryFrame[] newArray(int v) {
                return new BinaryFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public BinaryFrame(Parcel parcel0) {
        super(((String)Util.castNonNull(parcel0.readString())));
        this.data = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public BinaryFrame(String s, byte[] arr_b) {
        super(s);
        this.data = arr_b;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return BinaryFrame.class == class0 && this.id.equals(((BinaryFrame)object0).id) && Arrays.equals(this.data, ((BinaryFrame)object0).data);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.data) + x.b(0x20F, 0x1F, this.id);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeByteArray(this.data);
    }
}

