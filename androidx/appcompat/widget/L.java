package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class l implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState actionMenuPresenter$SavedState0 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        actionMenuPresenter$SavedState0.a = parcel0.readInt();
        return actionMenuPresenter$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

