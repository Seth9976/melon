package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Objects;
import y.a;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;
    public final String d;

    static {
        InternalFrame.CREATOR = new a(18);
    }

    public InternalFrame(Parcel parcel0) {
        super("----");
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readString();
    }

    public InternalFrame(String s, String s1, String s2) {
        super("----");
        this.b = s;
        this.c = s1;
        this.d = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return InternalFrame.class == class0 && Objects.equals(this.c, ((InternalFrame)object0).c) && Objects.equals(this.b, ((InternalFrame)object0).b) && Objects.equals(this.d, ((InternalFrame)object0).d);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.b == null ? 0 : this.b.hashCode();
        int v2 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + 0x20F) * 0x1F + v2) * 0x1F + v;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.a + ": domain=" + this.b + ", description=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
    }
}

