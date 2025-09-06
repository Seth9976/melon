package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class k9 implements b {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;

    static {
        k9.CREATOR = new t(15);
    }

    public k9(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
    }

    public k9(String s, String s1) {
        this.a = s;
        this.b = s1;
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
            return k9.class == class0 && this.a.equals(((k9)object0).a) && this.b.equals(((k9)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + x.b(0x20F, 0x1F, this.a);
    }

    @Override
    public final String toString() {
        return "VC: " + this.a + "=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
    }
}

