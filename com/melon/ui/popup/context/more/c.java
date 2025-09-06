package com.melon.ui.popup.context.more;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.constants.AddPosition;
import kotlin.jvm.internal.q;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        return parcel0.readInt() == 0 ? new AddPositionInfo(null) : new AddPositionInfo(AddPosition.valueOf(parcel0.readString()));
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new AddPositionInfo[v];
    }
}

