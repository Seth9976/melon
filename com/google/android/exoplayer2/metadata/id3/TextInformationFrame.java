package com.google.android.exoplayer2.metadata.id3;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.util.Util;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String description;
    public final String value;

    static {
        TextInformationFrame.CREATOR = new Parcelable.Creator() {
            public TextInformationFrame createFromParcel(Parcel parcel0) {
                return new TextInformationFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public TextInformationFrame[] newArray(int v) {
                return new TextInformationFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public TextInformationFrame(Parcel parcel0) {
        super(((String)Util.castNonNull(parcel0.readString())));
        this.description = parcel0.readString();
        this.value = (String)Util.castNonNull(parcel0.readString());
    }

    public TextInformationFrame(String s, String s1, String s2) {
        super(s);
        this.description = s1;
        this.value = s2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return TextInformationFrame.class == class0 && this.id.equals(((TextInformationFrame)object0).id) && Util.areEqual(this.description, ((TextInformationFrame)object0).description) && Util.areEqual(this.value, ((TextInformationFrame)object0).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = x.b(0x20F, 0x1F, this.id);
        int v1 = 0;
        int v2 = this.description == null ? 0 : this.description.hashCode();
        String s = this.value;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(22, this.id), this.description), this.value), this.id, ": description=", this.description, ": value=");
        stringBuilder0.append(this.value);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.description);
        parcel0.writeString(this.value);
    }
}

