package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    static {
        PrivateCommand.CREATOR = new Parcelable.Creator() {
            public PrivateCommand createFromParcel(Parcel parcel0) {
                return new PrivateCommand(parcel0, null);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public PrivateCommand[] newArray(int v) {
                return new PrivateCommand[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private PrivateCommand(long v, byte[] arr_b, long v1) {
        this.ptsAdjustment = v1;
        this.identifier = v;
        this.commandBytes = arr_b;
    }

    private PrivateCommand(Parcel parcel0) {
        this.ptsAdjustment = parcel0.readLong();
        this.identifier = parcel0.readLong();
        this.commandBytes = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public PrivateCommand(Parcel parcel0, com.google.android.exoplayer2.metadata.scte35.PrivateCommand.1 privateCommand$10) {
        this(parcel0);
    }

    public static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray0, int v, long v1) {
        long v2 = parsableByteArray0.readUnsignedInt();
        byte[] arr_b = new byte[v - 4];
        parsableByteArray0.readBytes(arr_b, 0, v - 4);
        return new PrivateCommand(v2, arr_b, v1);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.ptsAdjustment);
        parcel0.writeLong(this.identifier);
        parcel0.writeByteArray(this.commandBytes);
    }
}

