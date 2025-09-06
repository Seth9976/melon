package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class la extends ga {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;

    static {
        la.CREATOR = new t(17);
    }

    public la(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    public static long a(long v, wb wb0) {
        long v1 = (long)wb0.z();
        return (0x80L & v1) == 0L ? 0x8000000000000001L : 0x1FFFFFFFFL & ((v1 & 1L) << 0x20 | wb0.A()) + v;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
    }
}

