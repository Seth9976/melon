package com.melon.ui.popup.context.more;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class e implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        int v = parcel0.readInt();
        String s = parcel0.readString();
        return parcel0.readInt() == 0 ? new CheckedItemInfo(v, s, false) : new CheckedItemInfo(v, s, true);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CheckedItemInfo[v];
    }
}

