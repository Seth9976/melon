package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final long playbackPositionUs;
    public final long ptsTime;

    static {
        TimeSignalCommand.CREATOR = new Parcelable.Creator() {
            public TimeSignalCommand createFromParcel(Parcel parcel0) {
                return new TimeSignalCommand(parcel0.readLong(), parcel0.readLong(), null);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public TimeSignalCommand[] newArray(int v) {
                return new TimeSignalCommand[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private TimeSignalCommand(long v, long v1) {
        this.ptsTime = v;
        this.playbackPositionUs = v1;
    }

    public TimeSignalCommand(long v, long v1, com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.1 timeSignalCommand$10) {
        this(v, v1);
    }

    public static TimeSignalCommand parseFromSection(ParsableByteArray parsableByteArray0, long v, TimestampAdjuster timestampAdjuster0) {
        long v1 = TimeSignalCommand.parseSpliceTime(parsableByteArray0, v);
        return new TimeSignalCommand(v1, timestampAdjuster0.adjustTsTimestamp(v1));
    }

    public static long parseSpliceTime(ParsableByteArray parsableByteArray0, long v) {
        long v1 = (long)parsableByteArray0.readUnsignedByte();
        return (0x80L & v1) == 0L ? 0x8000000000000001L : 0x1FFFFFFFFL & ((v1 & 1L) << 0x20 | parsableByteArray0.readUnsignedInt()) + v;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.ptsTime);
        parcel0.writeLong(this.playbackPositionUs);
    }
}

