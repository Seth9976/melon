package androidx.compose.foundation.lazy.layout;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"BanParcelableUsage"})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyKey;", "Landroid/os/Parcelable;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class DefaultLazyKey implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final int a;

    static {
        DefaultLazyKey.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public DefaultLazyKey(int v) {
        this.a = v;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DefaultLazyKey ? this.a == ((DefaultLazyKey)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return o.q(new StringBuilder("DefaultLazyKey(index="), this.a, ')');
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
    }
}

