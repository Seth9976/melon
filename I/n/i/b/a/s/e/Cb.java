package i.n.i.b.a.s.e;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class cb implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final Uri b;
    public final byte[] c;

    static {
        cb.CREATOR = new t(4);
    }

    public cb(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = Uri.parse(parcel0.readString());
        this.c = parcel0.createByteArray();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b.toString());
        parcel0.writeByteArray(this.c);
    }
}

