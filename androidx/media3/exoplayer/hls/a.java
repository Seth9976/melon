package androidx.media3.exoplayer.hls;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new VariantInfo(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new VariantInfo[v];
    }
}

