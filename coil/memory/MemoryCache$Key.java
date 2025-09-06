package coil.memory;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import java.util.Map.Entry;
import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil/memory/MemoryCache$Key", "Landroid/os/Parcelable;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class MemoryCache.Key implements Parcelable {
    @Deprecated
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final Map b;

    static {
        MemoryCache.Key.CREATOR = new e(28);
    }

    public MemoryCache.Key(String s) {
        this(s, x.a);
    }

    public MemoryCache.Key(String s, Map map0) {
        this.a = s;
        this.b = map0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof MemoryCache.Key && q.b(this.a, ((MemoryCache.Key)object0).a) && q.b(this.b, ((MemoryCache.Key)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Key(key=" + this.a + ", extras=" + this.b + ')';
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeInt(this.b.size());
        for(Object object0: this.b.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            String s1 = (String)((Map.Entry)object0).getValue();
            parcel0.writeString(s);
            parcel0.writeString(s1);
        }
    }
}

