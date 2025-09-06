package androidx.media3.session.legacy;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class d0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new CustomAction(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CustomAction[v];
    }
}

