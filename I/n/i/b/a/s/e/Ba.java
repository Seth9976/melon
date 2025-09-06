package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class ba implements b {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;

    static {
        ba.CREATOR = new t(1);
    }

    public ba(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.createByteArray();
        this.c = parcel0.readInt();
        this.d = parcel0.readInt();
    }

    public ba(String s, byte[] arr_b, int v, int v1) {
        this.a = s;
        this.b = arr_b;
        this.c = v;
        this.d = v1;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return ba.class == class0 && this.a.equals(((ba)object0).a) && Arrays.equals(this.b, ((ba)object0).b) && this.c == ((ba)object0).c && this.d == ((ba)object0).d;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((Arrays.hashCode(this.b) + x.b(0x20F, 0x1F, this.a)) * 0x1F + this.c) * 0x1F + this.d;
    }

    @Override
    public final String toString() {
        return "mdta: key=" + this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeByteArray(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
    }
}

