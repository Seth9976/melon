package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"BanParcelableUsage"})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "T", "Landroidx/compose/runtime/O0;", "Landroid/os/Parcelable;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ParcelableSnapshotMutableState extends O0 implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;

    static {
        ParcelableSnapshotMutableState.CREATOR = new f0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1;
        parcel0.writeValue(this.getValue());
        P0 p00 = this.b;
        if(q.b(p00, V.c)) {
            v1 = 0;
        }
        else if(q.b(p00, V.f)) {
            v1 = 1;
        }
        else if(q.b(p00, V.d)) {
            v1 = 2;
        }
        else {
            throw new IllegalStateException("Only known types of MutableState\'s SnapshotMutationPolicy are supported");
        }
        parcel0.writeInt(v1);
    }
}

