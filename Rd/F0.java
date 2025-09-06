package rd;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerPageData;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class f0 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        boolean z1;
        q.g(parcel0, "parcel");
        ArrayList arrayList0 = parcel0.createStringArrayList();
        String s = parcel0.readString();
        String s1 = parcel0.readString();
        boolean z = false;
        if(parcel0.readInt() != 0) {
            z = true;
        }
        z1 = true;
        int v = parcel0.readInt();
        if(parcel0.readInt() == 0) {
            z1 = false;
        }
        return new DjMalrangPlayerPageData(arrayList0, s, s1, z, v, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new DjMalrangPlayerPageData[v];
    }
}

