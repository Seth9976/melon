package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class l1 implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        ArrayList arrayList0 = new ArrayList();
        parcel0.readList(arrayList0, b.class.getClassLoader());
        return new da(arrayList0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new da[v];
    }
}

