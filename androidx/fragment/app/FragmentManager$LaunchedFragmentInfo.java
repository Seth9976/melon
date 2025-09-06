package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
class FragmentManager.LaunchedFragmentInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public String a;
    public int b;

    static {
        FragmentManager.LaunchedFragmentInfo.CREATOR = new b(2);
    }

    public FragmentManager.LaunchedFragmentInfo(String s, int v) {
        this.a = s;
        this.b = v;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeInt(this.b);
    }
}

