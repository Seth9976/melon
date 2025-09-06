package androidx.media3.extractor.metadata.scte35;

import R3.e;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import e3.p;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;

    static {
        TimeSignalCommand.CREATOR = new e(0);
    }

    public TimeSignalCommand(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    public static long a(long v, p p0) {
        long v1 = (long)p0.u();
        return (0x80L & v1) == 0L ? 0x8000000000000001L : 0x1FFFFFFFFL & ((v1 & 1L) << 0x20 | p0.w()) + v;
    }

    @Override  // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SCTE-35 TimeSignalCommand { ptsTime=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", playbackPositionUs= ");
        return x.h(this.b, " }", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
    }
}

