package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ea implements b {
    public static final Parcelable.Creator CREATOR;
    public final float a;
    public final int b;

    static {
        ea.CREATOR = new t(6);
    }

    public ea(float f, int v) {
        this.a = f;
        this.b = v;
    }

    public ea(Parcel parcel0) {
        this.a = parcel0.readFloat();
        this.b = parcel0.readInt();
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
            return ea.class == class0 && this.a == ((ea)object0).a && this.b == ((ea)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() + 0x20F) * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        return "smta: captureFrameRate=" + this.a + ", svcTemporalLayerCount=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeFloat(this.a);
        parcel0.writeInt(this.b);
    }
}

