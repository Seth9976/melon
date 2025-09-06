package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class fb implements Parcelable, Comparable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final int b;
    public final int c;

    static {
        fb.CREATOR = new t(8);
    }

    public fb() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    public fb(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readInt();
        this.c = parcel0.readInt();
    }

    @Override
    public final int compareTo(Object object0) {
        int v = this.a - ((fb)object0).a;
        if(v == 0) {
            v = this.b - ((fb)object0).b;
            return v == 0 ? this.c - ((fb)object0).c : v;
        }
        return v;
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
            return fb.class == class0 && this.a == ((fb)object0).a && this.b == ((fb)object0).b && this.c == ((fb)object0).c;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return (this.a * 0x1F + this.b) * 0x1F + this.c;
    }

    @Override
    public final String toString() {
        return this.a + "." + this.b + "." + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.b);
        parcel0.writeInt(this.c);
    }
}

