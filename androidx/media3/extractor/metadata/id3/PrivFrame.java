package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Objects;
import y.a;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final byte[] c;

    static {
        PrivFrame.CREATOR = new a(20);
    }

    public PrivFrame(Parcel parcel0) {
        super("PRIV");
        this.b = parcel0.readString();
        this.c = parcel0.createByteArray();
    }

    public PrivFrame(String s, byte[] arr_b) {
        super("PRIV");
        this.b = s;
        this.c = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return PrivFrame.class == class0 && Objects.equals(this.b, ((PrivFrame)object0).b) && Arrays.equals(this.c, ((PrivFrame)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.b == null ? Arrays.hashCode(this.c) + 0x3FD1 : Arrays.hashCode(this.c) + (this.b.hashCode() + 0x20F) * 0x1F;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.a + ": owner=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeByteArray(this.c);
    }
}

