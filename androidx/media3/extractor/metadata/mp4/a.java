package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        ArrayList arrayList0 = new ArrayList();
        parcel0.readList(arrayList0, Segment.class.getClassLoader());
        return new SlowMotionData(arrayList0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SlowMotionData[v];
    }
}

