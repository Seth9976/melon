package androidx.media3.extractor.metadata.id3;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import y.a;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;

    static {
        UrlLinkFrame.CREATOR = new a(22);
    }

    public UrlLinkFrame(Parcel parcel0) {
        super(parcel0.readString());
        this.b = parcel0.readString();
        this.c = parcel0.readString();
    }

    public UrlLinkFrame(String s, String s1, String s2) {
        super(s);
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return UrlLinkFrame.class == class0 && this.a.equals(((UrlLinkFrame)object0).a) && Objects.equals(this.b, ((UrlLinkFrame)object0).b) && Objects.equals(this.c, ((UrlLinkFrame)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(0x20F, 0x1F, this.a);
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.a + ": url=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
    }
}

