package com.google.android.exoplayer2.extractor.mp4;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    static {
        MdtaMetadataEntry.CREATOR = new Parcelable.Creator() {
            public MdtaMetadataEntry createFromParcel(Parcel parcel0) {
                return new MdtaMetadataEntry(parcel0, null);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public MdtaMetadataEntry[] newArray(int v) {
                return new MdtaMetadataEntry[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private MdtaMetadataEntry(Parcel parcel0) {
        this.key = (String)Util.castNonNull(parcel0.readString());
        byte[] arr_b = new byte[parcel0.readInt()];
        this.value = arr_b;
        parcel0.readByteArray(arr_b);
        this.localeIndicator = parcel0.readInt();
        this.typeIndicator = parcel0.readInt();
    }

    public MdtaMetadataEntry(Parcel parcel0, com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry.1 mdtaMetadataEntry$10) {
        this(parcel0);
    }

    public MdtaMetadataEntry(String s, byte[] arr_b, int v, int v1) {
        this.key = s;
        this.value = arr_b;
        this.localeIndicator = v;
        this.typeIndicator = v1;
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
            return MdtaMetadataEntry.class == class0 && this.key.equals(((MdtaMetadataEntry)object0).key) && Arrays.equals(this.value, ((MdtaMetadataEntry)object0).value) && this.localeIndicator == ((MdtaMetadataEntry)object0).localeIndicator && this.typeIndicator == ((MdtaMetadataEntry)object0).typeIndicator;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((Arrays.hashCode(this.value) + x.b(0x20F, 0x1F, this.key)) * 0x1F + this.localeIndicator) * 0x1F + this.typeIndicator;
    }

    @Override
    public String toString() {
        String s = String.valueOf(this.key);
        return s.length() == 0 ? new String("mdta: key=") : "mdta: key=" + s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.key);
        parcel0.writeInt(this.value.length);
        parcel0.writeByteArray(this.value);
        parcel0.writeInt(this.localeIndicator);
        parcel0.writeInt(this.typeIndicator);
    }
}

