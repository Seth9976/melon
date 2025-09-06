package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class fa extends ga {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;
    public final byte[] c;

    static {
        fa.CREATOR = new t(7);
    }

    public fa(long v, byte[] arr_b, long v1) {
        this.a = v1;
        this.b = v;
        this.c = arr_b;
    }

    public fa(Parcel parcel0) {
        this.a = parcel0.readLong();
        this.b = parcel0.readLong();
        this.c = parcel0.createByteArray();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeByteArray(this.c);
    }
}

