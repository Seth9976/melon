package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final ArrayList a;
    public final ArrayList b;

    static {
        BackStackState.CREATOR = new b(1);
    }

    public BackStackState(Parcel parcel0) {
        this.a = parcel0.createStringArrayList();
        this.b = parcel0.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeStringList(this.a);
        parcel0.writeTypedList(this.b);
    }
}

