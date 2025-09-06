package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.ResultReceiver;

@SuppressLint({"BanParcelableUsage"})
final class MediaSessionCompat.ResultReceiverWrapper implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public ResultReceiver a;

    static {
        MediaSessionCompat.ResultReceiverWrapper.CREATOR = new U(0);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        this.a.writeToParcel(parcel0, v);
    }
}

