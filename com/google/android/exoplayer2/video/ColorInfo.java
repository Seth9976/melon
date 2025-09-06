package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;

    static {
        ColorInfo.CREATOR = new Parcelable.Creator() {
            public ColorInfo createFromParcel(Parcel parcel0) {
                return new ColorInfo(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ColorInfo[] newArray(int v) {
                return new ColorInfo[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ColorInfo(int v, int v1, int v2, byte[] arr_b) {
        this.colorSpace = v;
        this.colorRange = v1;
        this.colorTransfer = v2;
        this.hdrStaticInfo = arr_b;
    }

    public ColorInfo(Parcel parcel0) {
        this.colorSpace = parcel0.readInt();
        this.colorRange = parcel0.readInt();
        this.colorTransfer = parcel0.readInt();
        this.hdrStaticInfo = Util.readBoolean(parcel0) ? parcel0.createByteArray() : null;
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
            return ColorInfo.class == class0 && this.colorSpace == ((ColorInfo)object0).colorSpace && this.colorRange == ((ColorInfo)object0).colorRange && this.colorTransfer == ((ColorInfo)object0).colorTransfer && Arrays.equals(this.hdrStaticInfo, ((ColorInfo)object0).hdrStaticInfo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.hdrStaticInfo) + (((this.colorSpace + 0x20F) * 0x1F + this.colorRange) * 0x1F + this.colorTransfer) * 0x1F;
        }
        return this.hashCode;
    }

    @Override
    public String toString() {
        return this.hdrStaticInfo == null ? "ColorInfo(" + this.colorSpace + ", " + this.colorRange + ", " + this.colorTransfer + ", " + false + ")" : "ColorInfo(" + this.colorSpace + ", " + this.colorRange + ", " + this.colorTransfer + ", " + true + ")";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.colorSpace);
        parcel0.writeInt(this.colorRange);
        parcel0.writeInt(this.colorTransfer);
        Util.writeBoolean(parcel0, this.hdrStaticInfo != null);
        byte[] arr_b = this.hdrStaticInfo;
        if(arr_b != null) {
            parcel0.writeByteArray(arr_b);
        }
    }
}

