package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class q9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final v9[] g;

    static {
        q9.CREATOR = new t(23);
    }

    public q9(Parcel parcel0) {
        super("CHAP");
        this.b = parcel0.readString();
        this.c = parcel0.readInt();
        this.d = parcel0.readInt();
        this.e = parcel0.readLong();
        this.f = parcel0.readLong();
        int v = parcel0.readInt();
        this.g = new v9[v];
        for(int v1 = 0; v1 < v; ++v1) {
            this.g[v1] = (v9)parcel0.readParcelable(v9.class.getClassLoader());
        }
    }

    public q9(String s, int v, int v1, long v2, long v3, v9[] arr_v9) {
        super("CHAP");
        this.b = s;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = arr_v9;
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
            return q9.class == class0 && this.c == ((q9)object0).c && this.d == ((q9)object0).d && this.e == ((q9)object0).e && this.f == ((q9)object0).f && L7.p(this.b, ((q9)object0).b) && Arrays.equals(this.g, ((q9)object0).g);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = ((((this.c + 0x20F) * 0x1F + this.d) * 0x1F + ((int)this.e)) * 0x1F + ((int)this.f)) * 0x1F;
        return this.b == null ? v : v + this.b.hashCode();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeLong(this.e);
        parcel0.writeLong(this.f);
        v9[] arr_v9 = this.g;
        parcel0.writeInt(arr_v9.length);
        for(int v1 = 0; v1 < arr_v9.length; ++v1) {
            parcel0.writeParcelable(arr_v9[v1], 0);
        }
    }
}

