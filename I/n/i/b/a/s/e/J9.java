package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class j9 implements b {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final byte[] h;

    static {
        j9.CREATOR = new t(13);
    }

    public j9(int v, String s, String s1, int v1, int v2, int v3, int v4, byte[] arr_b) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = arr_b;
    }

    public j9(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readInt();
        this.e = parcel0.readInt();
        this.f = parcel0.readInt();
        this.g = parcel0.readInt();
        this.h = parcel0.createByteArray();
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
            return j9.class == class0 && this.a == ((j9)object0).a && this.b.equals(((j9)object0).b) && this.c.equals(((j9)object0).c) && this.d == ((j9)object0).d && this.e == ((j9)object0).e && this.f == ((j9)object0).f && this.g == ((j9)object0).g && Arrays.equals(this.h, ((j9)object0).h);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.h) + ((((x.b(x.b((this.a + 0x20F) * 0x1F, 0x1F, this.b), 0x1F, this.c) + this.d) * 0x1F + this.e) * 0x1F + this.f) * 0x1F + this.g) * 0x1F;
    }

    @Override
    public final String toString() {
        return "Picture: mimeType=" + this.b + ", description=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(this.e);
        parcel0.writeInt(this.f);
        parcel0.writeInt(this.g);
        parcel0.writeByteArray(this.h);
    }
}

