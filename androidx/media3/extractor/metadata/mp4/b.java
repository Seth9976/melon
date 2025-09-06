package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class b implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new Segment(parcel0.readLong(), parcel0.readLong(), parcel0.readInt());
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Segment[v];
    }
}

