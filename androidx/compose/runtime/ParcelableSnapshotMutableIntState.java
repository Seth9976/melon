package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p0.c;
import p0.h;
import p0.m;

@SuppressLint({"BanParcelableUsage"})
@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "Landroidx/compose/runtime/K0;", "Landroid/os/Parcelable;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ParcelableSnapshotMutableIntState extends K0 implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;

    static {
        ParcelableSnapshotMutableIntState.CREATOR = new e0(2);
    }

    public ParcelableSnapshotMutableIntState(int v) {
        h h0 = m.k();
        J0 j00 = new J0(h0.g(), v);
        if(!(h0 instanceof c)) {
            j00.b = new J0(1L, v);
        }
        this.b = j00;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.m());
    }
}

