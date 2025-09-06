package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import y.a;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;

    static {
        SpliceNullCommand.CREATOR = new a(28);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
    }
}

