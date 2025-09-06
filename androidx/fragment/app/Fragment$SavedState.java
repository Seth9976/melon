package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
public class Fragment.SavedState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Bundle a;

    static {
        Fragment.SavedState.CREATOR = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public Fragment.SavedState(Bundle bundle0) {
        this.a = bundle0;
    }

    public Fragment.SavedState(Parcel parcel0, ClassLoader classLoader0) {
        Bundle bundle0 = parcel0.readBundle();
        this.a = bundle0;
        if(classLoader0 != null && bundle0 != null) {
            bundle0.setClassLoader(classLoader0);
        }
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeBundle(this.a);
    }
}

