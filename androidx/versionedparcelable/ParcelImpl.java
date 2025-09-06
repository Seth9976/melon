package androidx.versionedparcelable;

import P4.c;
import P4.d;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import y.a;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final d a;

    static {
        ParcelImpl.CREATOR = new a(23);
    }

    public ParcelImpl(d d0) {
        this.a = d0;
    }

    public ParcelImpl(Parcel parcel0) {
        this.a = new c(parcel0).h();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new c(parcel0).l(this.a);
    }
}

