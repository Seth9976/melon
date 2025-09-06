package androidx.compose.foundation.lazy.layout;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class e implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new DefaultLazyKey(parcel0.readInt());
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new DefaultLazyKey[v];
    }
}

