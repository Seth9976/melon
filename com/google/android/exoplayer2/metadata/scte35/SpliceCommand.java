package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class SpliceCommand implements Entry {
    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        String s = this.getClass().getSimpleName();
        return s.length() == 0 ? new String("SCTE-35 splice command: type=") : "SCTE-35 splice command: type=" + s;
    }
}

