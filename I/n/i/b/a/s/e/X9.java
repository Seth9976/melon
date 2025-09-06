package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class x9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final int b;
    public final int c;
    public final int d;
    public final int[] e;
    public final int[] f;

    static {
        x9.CREATOR = new Tc(4);
    }

    public x9(int v, int v1, int v2, int[] arr_v, int[] arr_v1) {
        super("MLLT");
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = arr_v;
        this.f = arr_v1;
    }

    public x9(Parcel parcel0) {
        super("MLLT");
        this.b = parcel0.readInt();
        this.c = parcel0.readInt();
        this.d = parcel0.readInt();
        this.e = parcel0.createIntArray();
        this.f = parcel0.createIntArray();
    }

    @Override  // i.n.i.b.a.s.e.v9
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
            return x9.class == class0 && this.b == ((x9)object0).b && this.c == ((x9)object0).c && this.d == ((x9)object0).d && Arrays.equals(this.e, ((x9)object0).e) && Arrays.equals(this.f, ((x9)object0).f);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.e);
        return Arrays.hashCode(this.f) + (v + (((this.b + 0x20F) * 0x1F + this.c) * 0x1F + this.d) * 0x1F) * 0x1F;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeIntArray(this.e);
        parcel0.writeIntArray(this.f);
    }
}

