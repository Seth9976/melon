package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class p9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final byte[] b;

    static {
        p9.CREATOR = new t(22);
    }

    public p9(Parcel parcel0) {
        super(parcel0.readString());
        this.b = parcel0.createByteArray();
    }

    public p9(String s, byte[] arr_b) {
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
            return p9.class == class0 && this.a.equals(((p9)object0).a) && Arrays.equals(this.b, ((p9)object0).b);
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

