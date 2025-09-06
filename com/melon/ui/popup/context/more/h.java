package com.melon.ui.popup.context.more;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class h implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        return parcel0.readInt() == 0 ? new ToggleInfo(false) : new ToggleInfo(true);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ToggleInfo[v];
    }
}

