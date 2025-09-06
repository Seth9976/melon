package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    static {
        ParcelableVolumeInfo.CREATOR = new U(6);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(this.e);
        parcel0.writeInt(this.b);
    }
}

