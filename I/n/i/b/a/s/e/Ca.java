package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ca implements b {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    static {
        ca.CREATOR = new t(3);
    }

    public ca(long v, long v1, long v2, long v3, long v4) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
    }

    public ca(Parcel parcel0) {
        this.a = parcel0.readLong();
        this.b = parcel0.readLong();
        this.c = parcel0.readLong();
        this.d = parcel0.readLong();
        this.e = parcel0.readLong();
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
            return ca.class == class0 && this.a == ((ca)object0).a && this.b == ((ca)object0).b && this.c == ((ca)object0).c && this.d == ((ca)object0).d && this.e == ((ca)object0).e;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((int)(this.e ^ this.e >>> 0x20)) + (((int)(this.d ^ this.d >>> 0x20)) + (((int)(this.c ^ this.c >>> 0x20)) + (((int)(this.b ^ this.b >>> 0x20)) + (((int)(this.a ^ this.a >>> 0x20)) + 0x20F) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.a + ", photoSize=" + this.b + ", photoPresentationTimestampUs=" + this.c + ", videoStartPosition=" + this.d + ", videoSize=" + this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeLong(this.c);
        parcel0.writeLong(this.d);
        parcel0.writeLong(this.e);
    }
}

