package androidx.media3.extractor.metadata.id3;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import y.a;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final byte[] b;

    static {
        BinaryFrame.CREATOR = new a(13);
    }

    public BinaryFrame(Parcel parcel0) {
        super(parcel0.readString());
        this.b = parcel0.createByteArray();
    }

    public BinaryFrame(String s, byte[] arr_b) {
        super(s);
        this.b = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return BinaryFrame.class == class0 && this.a.equals(((BinaryFrame)object0).a) && Arrays.equals(this.b, ((BinaryFrame)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.b) + x.b(0x20F, 0x1F, this.a);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeByteArray(this.b);
    }
}

