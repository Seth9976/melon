package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;

@SuppressLint({"BanParcelableUsage"})
class StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int a;
    public int b;
    public int[] c;
    public boolean d;

    static {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.CREATOR = new T0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.b);
        parcel0.writeInt(((int)this.d));
        int[] arr_v = this.c;
        if(arr_v != null && arr_v.length > 0) {
            parcel0.writeInt(arr_v.length);
            parcel0.writeIntArray(this.c);
            return;
        }
        parcel0.writeInt(0);
    }
}

