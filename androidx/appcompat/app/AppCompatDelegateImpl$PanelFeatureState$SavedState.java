package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
class AppCompatDelegateImpl.PanelFeatureState.SavedState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int a;
    public boolean b;
    public Bundle c;

    static {
        AppCompatDelegateImpl.PanelFeatureState.SavedState.CREATOR = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static AppCompatDelegateImpl.PanelFeatureState.SavedState a(Parcel parcel0, ClassLoader classLoader0) {
        AppCompatDelegateImpl.PanelFeatureState.SavedState appCompatDelegateImpl$PanelFeatureState$SavedState0 = new AppCompatDelegateImpl.PanelFeatureState.SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        appCompatDelegateImpl$PanelFeatureState$SavedState0.a = parcel0.readInt();
        boolean z = parcel0.readInt() == 1;
        appCompatDelegateImpl$PanelFeatureState$SavedState0.b = z;
        if(z) {
            appCompatDelegateImpl$PanelFeatureState$SavedState0.c = parcel0.readBundle(classLoader0);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeInt(((int)this.b));
        if(this.b) {
            parcel0.writeBundle(this.c);
        }
    }
}

