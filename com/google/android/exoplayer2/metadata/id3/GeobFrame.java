package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import k8.Y;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "GEOB";
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    static {
        GeobFrame.CREATOR = new Parcelable.Creator() {
            public GeobFrame createFromParcel(Parcel parcel0) {
                return new GeobFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public GeobFrame[] newArray(int v) {
                return new GeobFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public GeobFrame(Parcel parcel0) {
        super("GEOB");
        this.mimeType = (String)Util.castNonNull(parcel0.readString());
        this.filename = (String)Util.castNonNull(parcel0.readString());
        this.description = (String)Util.castNonNull(parcel0.readString());
        this.data = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public GeobFrame(String s, String s1, String s2, byte[] arr_b) {
        super("GEOB");
        this.mimeType = s;
        this.filename = s1;
        this.description = s2;
        this.data = arr_b;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return GeobFrame.class == class0 && Util.areEqual(this.mimeType, ((GeobFrame)object0).mimeType) && Util.areEqual(this.filename, ((GeobFrame)object0).filename) && Util.areEqual(this.description, ((GeobFrame)object0).description) && Arrays.equals(this.data, ((GeobFrame)object0).data);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.mimeType == null ? 0 : this.mimeType.hashCode();
        int v2 = this.filename == null ? 0 : this.filename.hashCode();
        String s = this.description;
        if(s != null) {
            v = s.hashCode();
        }
        return Arrays.hashCode(this.data) + (((v1 + 0x20F) * 0x1F + v2) * 0x1F + v) * 0x1F;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return Y.l(Z.o(Z.e(Z.e(Z.e(Z.e(36, this.id), this.mimeType), this.filename), this.description), this.id, ": mimeType=", this.mimeType, ", filename="), this.filename, ", description=", this.description);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.mimeType);
        parcel0.writeString(this.filename);
        parcel0.writeString(this.description);
        parcel0.writeByteArray(this.data);
    }
}

