package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class aa extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;

    static {
        aa.CREATOR = new t(0);
    }

    public aa(Parcel parcel0) {
        super(parcel0.readString());
        this.b = parcel0.readString();
        this.c = parcel0.readString();
    }

    public aa(String s, String s1, String s2) {
        super(s);
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return aa.class == class0 && this.a.equals(((aa)object0).a) && L7.p(this.b, ((aa)object0).b) && L7.p(this.c, ((aa)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(0x20F, 0x1F, this.a);
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // i.n.i.b.a.s.e.v9
    public final String toString() {
        return this.a + ": url=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
    }
}

