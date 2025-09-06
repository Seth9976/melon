package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class i implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState nestedScrollView$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        nestedScrollView$SavedState0.a = parcel0.readInt();
        return nestedScrollView$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

