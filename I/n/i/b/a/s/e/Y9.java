package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class y9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final byte[] c;

    static {
        y9.CREATOR = new Tc(5);
    }

    public y9(Parcel parcel0) {
        super("PRIV");
        this.b = parcel0.readString();
        this.c = parcel0.createByteArray();
    }

    public y9(String s, byte[] arr_b) {
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
            return y9.class == class0 && L7.p(this.b, ((y9)object0).b) && Arrays.equals(this.c, ((y9)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.b == null ? Arrays.hashCode(this.c) + 0x3FD1 : Arrays.hashCode(this.c) + (this.b.hashCode() + 0x20F) * 0x1F;
    }

    @Override  // i.n.i.b.a.s.e.v9
    public final String toString() {
        return this.a + ": owner=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeByteArray(this.c);
    }
}

