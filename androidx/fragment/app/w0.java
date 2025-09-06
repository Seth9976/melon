package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class w0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState fragmentTabHost$SavedState0 = new SavedState(parcel0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;)V
        fragmentTabHost$SavedState0.a = parcel0.readString();
        return fragmentTabHost$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

