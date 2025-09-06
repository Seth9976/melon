package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public ArrayList a;
    public ArrayList b;
    public BackStackRecordState[] c;
    public int d;
    public String e;
    public ArrayList f;
    public ArrayList g;
    public ArrayList h;

    static {
        FragmentManagerState.CREATOR = new b(3);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeStringList(this.a);
        parcel0.writeStringList(this.b);
        parcel0.writeTypedArray(this.c, v);
        parcel0.writeInt(this.d);
        parcel0.writeString(this.e);
        parcel0.writeStringList(this.f);
        parcel0.writeTypedList(this.g);
        parcel0.writeTypedList(this.h);
    }
}

