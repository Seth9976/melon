package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "APIC";
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    static {
        ApicFrame.CREATOR = new Parcelable.Creator() {
            public ApicFrame createFromParcel(Parcel parcel0) {
                return new ApicFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ApicFrame[] newArray(int v) {
                return new ApicFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ApicFrame(Parcel parcel0) {
        super("APIC");
        this.mimeType = (String)Util.castNonNull(parcel0.readString());
        this.description = parcel0.readString();
        this.pictureType = parcel0.readInt();
        this.pictureData = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public ApicFrame(String s, String s1, int v, byte[] arr_b) {
        super("APIC");
        this.mimeType = s;
        this.description = s1;
        this.pictureType = v;
        this.pictureData = arr_b;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return ApicFrame.class == class0 && this.pictureType == ((ApicFrame)object0).pictureType && Util.areEqual(this.mimeType, ((ApicFrame)object0).mimeType) && Util.areEqual(this.description, ((ApicFrame)object0).description) && Arrays.equals(this.pictureData, ((ApicFrame)object0).pictureData);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = (this.pictureType + 0x20F) * 0x1F;
        int v1 = 0;
        int v2 = this.mimeType == null ? 0 : this.mimeType.hashCode();
        String s = this.description;
        if(s != null) {
            v1 = s.hashCode();
        }
        return Arrays.hashCode(this.pictureData) + ((v + v2) * 0x1F + v1) * 0x1F;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(25, this.id), this.mimeType), this.description), this.id, ": mimeType=", this.mimeType, ", description=");
        stringBuilder0.append(this.description);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.mimeType);
        parcel0.writeString(this.description);
        parcel0.writeInt(this.pictureType);
        parcel0.writeByteArray(this.pictureData);
    }
}

