package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.util.Util;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "----";
    public final String description;
    public final String domain;
    public final String text;

    static {
        InternalFrame.CREATOR = new Parcelable.Creator() {
            public InternalFrame createFromParcel(Parcel parcel0) {
                return new InternalFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public InternalFrame[] newArray(int v) {
                return new InternalFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public InternalFrame(Parcel parcel0) {
        super("----");
        this.domain = (String)Util.castNonNull(parcel0.readString());
        this.description = (String)Util.castNonNull(parcel0.readString());
        this.text = (String)Util.castNonNull(parcel0.readString());
    }

    public InternalFrame(String s, String s1, String s2) {
        super("----");
        this.domain = s;
        this.description = s1;
        this.text = s2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return InternalFrame.class == class0 && Util.areEqual(this.description, ((InternalFrame)object0).description) && Util.areEqual(this.domain, ((InternalFrame)object0).domain) && Util.areEqual(this.text, ((InternalFrame)object0).text);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.domain == null ? 0 : this.domain.hashCode();
        int v2 = this.description == null ? 0 : this.description.hashCode();
        String s = this.text;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + 0x20F) * 0x1F + v2) * 0x1F + v;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(23, this.id), this.domain), this.description), this.id, ": domain=", this.domain, ", description=");
        stringBuilder0.append(this.description);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.domain);
        parcel0.writeString(this.text);
    }
}

