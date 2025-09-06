package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.Metadata.Entry;

public abstract class SpliceCommand implements Entry {
    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "SCTE-35 splice command: type=" + this.getClass().getSimpleName();
    }
}

