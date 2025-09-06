package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class ib implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;

    static {
        ib.CREATOR = new t(12);
    }

    public ib(int v) {
        if((v & 2) != 0) {
            v |= 1;
        }
        this.a = v;
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
            return ib.class == class0 && this.a == ((ib)object0).a;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
    }
}

