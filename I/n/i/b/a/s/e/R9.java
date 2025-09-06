package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class r9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String[] e;
    public final v9[] f;

    static {
        r9.CREATOR = new t(24);
    }

    public r9(Parcel parcel0) {
        super("CTOC");
        this.b = parcel0.readString();
        boolean z = true;
        this.c = parcel0.readByte() != 0;
        if(parcel0.readByte() == 0) {
            z = false;
        }
        this.d = z;
        this.e = parcel0.createStringArray();
        int v1 = parcel0.readInt();
        this.f = new v9[v1];
        for(int v = 0; v < v1; ++v) {
            this.f[v] = (v9)parcel0.readParcelable(v9.class.getClassLoader());
        }
    }

    public r9(String s, boolean z, boolean z1, String[] arr_s, v9[] arr_v9) {
        super("CTOC");
        this.b = s;
        this.c = z;
        this.d = z1;
        this.e = arr_s;
        this.f = arr_v9;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return r9.class == class0 && this.c == ((r9)object0).c && this.d == ((r9)object0).d && L7.p(this.b, ((r9)object0).b) && Arrays.equals(this.e, ((r9)object0).e) && Arrays.equals(this.f, ((r9)object0).f);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = ((this.c + 0x20F) * 0x1F + this.d) * 0x1F;
        return this.b == null ? v : v + this.b.hashCode();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeByte(((byte)this.c));
        parcel0.writeByte(((byte)this.d));
        parcel0.writeStringArray(this.e);
        v9[] arr_v9 = this.f;
        parcel0.writeInt(arr_v9.length);
        for(int v1 = 0; v1 < arr_v9.length; ++v1) {
            parcel0.writeParcelable(arr_v9[v1], 0);
        }
    }
}

