package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class e9 implements b {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final String b;

    static {
        e9.CREATOR = new t(5);
    }

    public e9(int v, String s) {
        this.a = v;
        this.b = s;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Ait(controlCode=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(",url=");
        return x.m(stringBuilder0, this.b, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeInt(this.a);
    }
}

