package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

public final class o implements Parcelable.ClassLoaderCreator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        SavedState viewPager2$SavedState0 = new SavedState(parcel0, null);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V
        viewPager2$SavedState0.a = parcel0.readInt();
        viewPager2$SavedState0.b = parcel0.readInt();
        viewPager2$SavedState0.c = parcel0.readParcelable(null);
        return viewPager2$SavedState0;
    }

    @Override  // android.os.Parcelable$ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
        SavedState viewPager2$SavedState0 = new SavedState(parcel0, classLoader0);  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V
        viewPager2$SavedState0.a = parcel0.readInt();
        viewPager2$SavedState0.b = parcel0.readInt();
        viewPager2$SavedState0.c = parcel0.readParcelable(classLoader0);
        return viewPager2$SavedState0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SavedState[v];
    }
}

