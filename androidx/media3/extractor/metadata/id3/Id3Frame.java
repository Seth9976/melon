package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata.Entry;

public abstract class Id3Frame implements Entry {
    public final String a;

    public Id3Frame(String s) {
        this.a = s;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return this.a;
    }
}

