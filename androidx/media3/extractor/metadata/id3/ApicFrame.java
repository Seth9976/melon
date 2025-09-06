package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.c;
import java.util.Arrays;
import java.util.Objects;
import y.a;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;
    public final int d;
    public final byte[] e;

    static {
        ApicFrame.CREATOR = new a(12);
    }

    public ApicFrame(Parcel parcel0) {
        super("APIC");
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readInt();
        this.e = parcel0.createByteArray();
    }

    public ApicFrame(String s, String s1, int v, byte[] arr_b) {
        super("APIC");
        this.b = s;
        this.c = s1;
        this.d = v;
        this.e = arr_b;
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final void M(c c0) {
        c0.a(this.d, this.e);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return ApicFrame.class == class0 && this.d == ((ApicFrame)object0).d && Objects.equals(this.b, ((ApicFrame)object0).b) && Objects.equals(this.c, ((ApicFrame)object0).c) && Arrays.equals(this.e, ((ApicFrame)object0).e);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = (this.d + 0x20F) * 0x1F;
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return Arrays.hashCode(this.e) + ((v + v2) * 0x1F + v1) * 0x1F;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.a + ": mimeType=" + this.b + ", description=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeByteArray(this.e);
    }
}

