package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class g9 implements b {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final byte[] e;
    public int f;
    public static final u g;
    public static final u h;

    static {
        ob ob0 = new ob();
        ob0.k = "application/id3";
        g9.g = new u(ob0);
        ob ob1 = new ob();
        ob1.k = "application/x-scte35";
        g9.h = new u(ob1);
        g9.CREATOR = new t(9);
    }

    public g9(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        this.c = parcel0.readLong();
        this.d = parcel0.readLong();
        this.e = parcel0.createByteArray();
    }

    public g9(String s, String s1, long v, long v1, byte[] arr_b) {
        this.a = s;
        this.b = s1;
        this.c = v;
        this.d = v1;
        this.e = arr_b;
    }

    @Override  // i.n.i.b.a.s.e.x8$b
    public final byte[] b() {
        return this.c() == null ? null : this.e;
    }

    @Override  // i.n.i.b.a.s.e.x8$b
    public final u c() {
        switch(this.a) {
            case "https://aomedia.org/emsg/ID3": {
                return g9.g;
            }
            case "https://developer.apple.com/streaming/emsg-id3": {
                return g9.g;
            }
            case "urn:scte:scte35:2014:bin": {
                return g9.h;
            }
            default: {
                return null;
            }
        }
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
            return g9.class == class0 && this.c == ((g9)object0).c && this.d == ((g9)object0).d && L7.p(this.a, ((g9)object0).a) && L7.p(this.b, ((g9)object0).b) && Arrays.equals(this.e, ((g9)object0).e);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.f == 0) {
            int v = 0;
            int v1 = this.a == null ? 0 : this.a.hashCode();
            String s = this.b;
            if(s != null) {
                v = s.hashCode();
            }
            this.f = Arrays.hashCode(this.e) + ((((v1 + 0x20F) * 0x1F + v) * 0x1F + ((int)(this.c ^ this.c >>> 0x20))) * 0x1F + ((int)(this.d ^ this.d >>> 0x20))) * 0x1F;
        }
        return this.f;
    }

    @Override
    public final String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.d + ", durationMs=" + this.c + ", value=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeLong(this.c);
        parcel0.writeLong(this.d);
        parcel0.writeByteArray(this.e);
    }
}

