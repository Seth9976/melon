package com.google.android.exoplayer2.metadata.id3;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String description;
    public final String url;

    static {
        UrlLinkFrame.CREATOR = new Parcelable.Creator() {
            public UrlLinkFrame createFromParcel(Parcel parcel0) {
                return new UrlLinkFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public UrlLinkFrame[] newArray(int v) {
                return new UrlLinkFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public UrlLinkFrame(Parcel parcel0) {
        super(((String)Util.castNonNull(parcel0.readString())));
        this.description = parcel0.readString();
        this.url = (String)Util.castNonNull(parcel0.readString());
    }

    public UrlLinkFrame(String s, String s1, String s2) {
        super(s);
        this.description = s1;
        this.url = s2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return UrlLinkFrame.class == class0 && this.id.equals(((UrlLinkFrame)object0).id) && Util.areEqual(this.description, ((UrlLinkFrame)object0).description) && Util.areEqual(this.url, ((UrlLinkFrame)object0).url);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = x.b(0x20F, 0x1F, this.id);
        int v1 = 0;
        int v2 = this.description == null ? 0 : this.description.hashCode();
        String s = this.url;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.id + ": url=" + this.url;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.description);
        parcel0.writeString(this.url);
    }
}

