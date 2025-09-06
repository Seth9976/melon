package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        private ComponentSplice(int v, long v1, long v2) {
            this.componentTag = v;
            this.componentSplicePts = v1;
            this.componentSplicePlaybackPositionUs = v2;
        }

        public ComponentSplice(int v, long v1, long v2, com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1 spliceInsertCommand$10) {
            this(v, v1, v2);
        }

        public static ComponentSplice createFromParcel(Parcel parcel0) {
            return new ComponentSplice(parcel0.readInt(), parcel0.readLong(), parcel0.readLong());
        }

        public void writeToParcel(Parcel parcel0) {
            parcel0.writeInt(this.componentTag);
            parcel0.writeLong(this.componentSplicePts);
            parcel0.writeLong(this.componentSplicePlaybackPositionUs);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    static {
        SpliceInsertCommand.CREATOR = new Parcelable.Creator() {
            public SpliceInsertCommand createFromParcel(Parcel parcel0) {
                return new SpliceInsertCommand(parcel0, null);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public SpliceInsertCommand[] newArray(int v) {
                return new SpliceInsertCommand[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private SpliceInsertCommand(long v, boolean z, boolean z1, boolean z2, boolean z3, long v1, long v2, List list0, boolean z4, long v3, int v4, int v5, int v6) {
        this.spliceEventId = v;
        this.spliceEventCancelIndicator = z;
        this.outOfNetworkIndicator = z1;
        this.programSpliceFlag = z2;
        this.spliceImmediateFlag = z3;
        this.programSplicePts = v1;
        this.programSplicePlaybackPositionUs = v2;
        this.componentSpliceList = Collections.unmodifiableList(list0);
        this.autoReturn = z4;
        this.breakDurationUs = v3;
        this.uniqueProgramId = v4;
        this.availNum = v5;
        this.availsExpected = v6;
    }

    private SpliceInsertCommand(Parcel parcel0) {
        this.spliceEventId = parcel0.readLong();
        boolean z = false;
        this.spliceEventCancelIndicator = parcel0.readByte() == 1;
        this.outOfNetworkIndicator = parcel0.readByte() == 1;
        this.programSpliceFlag = parcel0.readByte() == 1;
        this.spliceImmediateFlag = parcel0.readByte() == 1;
        this.programSplicePts = parcel0.readLong();
        this.programSplicePlaybackPositionUs = parcel0.readLong();
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(ComponentSplice.createFromParcel(parcel0));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList0);
        if(parcel0.readByte() == 1) {
            z = true;
        }
        this.autoReturn = z;
        this.breakDurationUs = parcel0.readLong();
        this.uniqueProgramId = parcel0.readInt();
        this.availNum = parcel0.readInt();
        this.availsExpected = parcel0.readInt();
    }

    public SpliceInsertCommand(Parcel parcel0, com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1 spliceInsertCommand$10) {
        this(parcel0);
    }

    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray0, long v, TimestampAdjuster timestampAdjuster0) {
        boolean z3;
        long v9;
        int v8;
        long v1 = parsableByteArray0.readUnsignedInt();
        boolean z = (parsableByteArray0.readUnsignedByte() & 0x80) != 0;
        List list0 = Collections.EMPTY_LIST;
        long v2 = 0x8000000000000001L;
        if(!z) {
            int v3 = parsableByteArray0.readUnsignedByte();
            boolean z1 = (v3 & 0x40) != 0;
            boolean z2 = (v3 & 16) != 0;
            long v4 = !z1 || z2 ? 0x8000000000000001L : TimeSignalCommand.parseSpliceTime(parsableByteArray0, v);
            if(!z1) {
                int v5 = parsableByteArray0.readUnsignedByte();
                ArrayList arrayList0 = new ArrayList(v5);
                int v6 = 0;
                while(v6 < v5) {
                    int v7 = parsableByteArray0.readUnsignedByte();
                    if(z2) {
                        v8 = v5;
                        v9 = 0x8000000000000001L;
                    }
                    else {
                        v8 = v5;
                        v9 = TimeSignalCommand.parseSpliceTime(parsableByteArray0, v);
                    }
                    arrayList0.add(new ComponentSplice(v7, v9, timestampAdjuster0.adjustTsTimestamp(v9), null));
                    ++v6;
                    v5 = v8;
                }
                list0 = arrayList0;
            }
            if((v3 & 0x20) == 0) {
                z3 = false;
            }
            else {
                long v10 = (long)parsableByteArray0.readUnsignedByte();
                v2 = ((v10 & 1L) << 0x20 | parsableByteArray0.readUnsignedInt()) * 1000L / 90L;
                z3 = (0x80L & v10) != 0L;
            }
            int v11 = parsableByteArray0.readUnsignedShort();
            int v12 = parsableByteArray0.readUnsignedByte();
            int v13 = parsableByteArray0.readUnsignedByte();
            return new SpliceInsertCommand(v1, false, (v3 & 0x80) != 0, z1, z2, v4, timestampAdjuster0.adjustTsTimestamp(v4), list0, z3, v2, v11, v12, v13);
        }
        return new SpliceInsertCommand(v1, true, false, false, false, 0x8000000000000001L, timestampAdjuster0.adjustTsTimestamp(0x8000000000000001L), list0, false, 0x8000000000000001L, 0, 0, 0);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.spliceEventId);
        parcel0.writeByte(((byte)this.spliceEventCancelIndicator));
        parcel0.writeByte(((byte)this.outOfNetworkIndicator));
        parcel0.writeByte(((byte)this.programSpliceFlag));
        parcel0.writeByte(((byte)this.spliceImmediateFlag));
        parcel0.writeLong(this.programSplicePts);
        parcel0.writeLong(this.programSplicePlaybackPositionUs);
        int v1 = this.componentSpliceList.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            ((ComponentSplice)this.componentSpliceList.get(v2)).writeToParcel(parcel0);
        }
        parcel0.writeByte(((byte)this.autoReturn));
        parcel0.writeLong(this.breakDurationUs);
        parcel0.writeInt(this.uniqueProgramId);
        parcel0.writeInt(this.availNum);
        parcel0.writeInt(this.availsExpected);
    }
}

