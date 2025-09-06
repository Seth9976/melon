package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Objects;
import y.a;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;
    public final String d;
    public final byte[] e;

    static {
        GeobFrame.CREATOR = new a(17);
    }

    public GeobFrame(Parcel parcel0) {
        super("GEOB");
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readString();
        this.e = parcel0.createByteArray();
    }

    public GeobFrame(String s, String s1, String s2, byte[] arr_b) {
        super("GEOB");
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return GeobFrame.class == class0 && Objects.equals(this.b, ((GeobFrame)object0).b) && Objects.equals(this.c, ((GeobFrame)object0).c) && Objects.equals(this.d, ((GeobFrame)object0).d) && Arrays.equals(this.e, ((GeobFrame)object0).e);
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
        return Arrays.hashCode(this.e) + (((v1 + 0x20F) * 0x1F + v2) * 0x1F + v) * 0x1F;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.a + ": mimeType=" + this.b + ", filename=" + this.c + ", description=" + this.d;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeString(this.d);
        parcel0.writeByteArray(this.e);
    }
}

