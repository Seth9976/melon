package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class o9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;
    public final int d;
    public final byte[] e;

    static {
        o9.CREATOR = new t(21);
    }

    public o9(Parcel parcel0) {
        super("APIC");
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readInt();
        this.e = parcel0.createByteArray();
    }

    public o9(String s, String s1, int v, byte[] arr_b) {
        super("APIC");
        this.b = s;
        this.c = s1;
        this.d = v;
        this.e = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return o9.class == class0 && this.d == ((o9)object0).d && L7.p(this.b, ((o9)object0).b) && L7.p(this.c, ((o9)object0).c) && Arrays.equals(this.e, ((o9)object0).e);
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

    @Override  // i.n.i.b.a.s.e.v9
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

