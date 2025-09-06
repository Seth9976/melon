package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class s9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;
    public final String d;

    static {
        s9.CREATOR = new t(25);
    }

    public s9(Parcel parcel0) {
        super("COMM");
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readString();
    }

    public s9(String s, String s1, String s2) {
        super("COMM");
        this.b = s;
        this.c = s1;
        this.d = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return s9.class == class0 && L7.p(this.c, ((s9)object0).c) && L7.p(this.b, ((s9)object0).b) && L7.p(this.d, ((s9)object0).d);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.b == null ? 0 : this.b.hashCode();
        int v2 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + 0x20F) * 0x1F + v2) * 0x1F + v;
    }

    @Override  // i.n.i.b.a.s.e.v9
    public final String toString() {
        return this.a + ": language=" + this.b + ", description=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
    }
}

