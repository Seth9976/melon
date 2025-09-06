package Cc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.melon.ui.common.composable.PlayBgColorData;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class v2 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        int v = parcel0.readInt();
        int v1 = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v1);
        for(int v2 = 0; v2 != v1; ++v2) {
            arrayList0.add(parcel0.readInt());
        }
        return new PlayBgColorData(v, arrayList0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PlayBgColorData[v];
    }
}

