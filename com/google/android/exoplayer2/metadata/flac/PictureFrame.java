package com.google.android.exoplayer2.metadata.flac;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PictureFrame implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final int colors;
    public final int depth;
    public final String description;
    public final int height;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;
    public final int width;

    static {
        PictureFrame.CREATOR = new Parcelable.Creator() {
            public PictureFrame createFromParcel(Parcel parcel0) {
                return new PictureFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public PictureFrame[] newArray(int v) {
                return new PictureFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public PictureFrame(int v, String s, String s1, int v1, int v2, int v3, int v4, byte[] arr_b) {
        this.pictureType = v;
        this.mimeType = s;
        this.description = s1;
        this.width = v1;
        this.height = v2;
        this.depth = v3;
        this.colors = v4;
        this.pictureData = arr_b;
    }

    public PictureFrame(Parcel parcel0) {
        this.pictureType = parcel0.readInt();
        this.mimeType = (String)Util.castNonNull(parcel0.readString());
        this.description = (String)Util.castNonNull(parcel0.readString());
        this.width = parcel0.readInt();
        this.height = parcel0.readInt();
        this.depth = parcel0.readInt();
        this.colors = parcel0.readInt();
        this.pictureData = (byte[])Util.castNonNull(parcel0.createByteArray());
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
            return PictureFrame.class == class0 && this.pictureType == ((PictureFrame)object0).pictureType && this.mimeType.equals(((PictureFrame)object0).mimeType) && this.description.equals(((PictureFrame)object0).description) && this.width == ((PictureFrame)object0).width && this.height == ((PictureFrame)object0).height && this.depth == ((PictureFrame)object0).depth && this.colors == ((PictureFrame)object0).colors && Arrays.equals(this.pictureData, ((PictureFrame)object0).pictureData);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.pictureData) + ((((x.b(x.b((this.pictureType + 0x20F) * 0x1F, 0x1F, this.mimeType), 0x1F, this.description) + this.width) * 0x1F + this.height) * 0x1F + this.depth) * 0x1F + this.colors) * 0x1F;
    }

    @Override
    public String toString() {
        return "Picture: mimeType=" + this.mimeType + ", description=" + this.description;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.pictureType);
        parcel0.writeString(this.mimeType);
        parcel0.writeString(this.description);
        parcel0.writeInt(this.width);
        parcel0.writeInt(this.height);
        parcel0.writeInt(this.depth);
        parcel0.writeInt(this.colors);
        parcel0.writeByteArray(this.pictureData);
    }
}

