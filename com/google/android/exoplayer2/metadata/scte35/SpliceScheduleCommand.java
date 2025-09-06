package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        private ComponentSplice(int v, long v1) {
            this.componentTag = v;
            this.utcSpliceTime = v1;
        }

        public ComponentSplice(int v, long v1, com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1 spliceScheduleCommand$10) {
            this(v, v1);
        }

        private static ComponentSplice createFromParcel(Parcel parcel0) {
            return new ComponentSplice(parcel0.readInt(), parcel0.readLong());
        }

        private void writeToParcel(Parcel parcel0) {
            parcel0.writeInt(this.componentTag);
            parcel0.writeLong(this.utcSpliceTime);
        }
    }

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        private Event(long v, boolean z, boolean z1, boolean z2, List list0, long v1, boolean z3, long v2, int v3, int v4, int v5) {
            this.spliceEventId = v;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z1;
            this.programSpliceFlag = z2;
            this.componentSpliceList = Collections.unmodifiableList(list0);
            this.utcSpliceTime = v1;
            this.autoReturn = z3;
            this.breakDurationUs = v2;
            this.uniqueProgramId = v3;
            this.availNum = v4;
            this.availsExpected = v5;
        }

        private Event(Parcel parcel0) {
            this.spliceEventId = parcel0.readLong();
            boolean z = false;
            this.spliceEventCancelIndicator = parcel0.readByte() == 1;
            this.outOfNetworkIndicator = parcel0.readByte() == 1;
            this.programSpliceFlag = parcel0.readByte() == 1;
            int v = parcel0.readInt();
            ArrayList arrayList0 = new ArrayList(v);
            for(int v1 = 0; v1 < v; ++v1) {
                arrayList0.add(ComponentSplice.createFromParcel(parcel0));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList0);
            this.utcSpliceTime = parcel0.readLong();
            if(parcel0.readByte() == 1) {
                z = true;
            }
            this.autoReturn = z;
            this.breakDurationUs = parcel0.readLong();
            this.uniqueProgramId = parcel0.readInt();
            this.availNum = parcel0.readInt();
            this.availsExpected = parcel0.readInt();
        }

        public static Event access$300(Parcel parcel0) {
            return Event.createFromParcel(parcel0);
        }

        public static Event access$400(ParsableByteArray parsableByteArray0) {
            return Event.parseFromSection(parsableByteArray0);
        }

        public static void access$500(Event spliceScheduleCommand$Event0, Parcel parcel0) {
            spliceScheduleCommand$Event0.writeToParcel(parcel0);
        }

        private static Event createFromParcel(Parcel parcel0) {
            return new Event(parcel0);
        }

        private static Event parseFromSection(ParsableByteArray parsableByteArray0) {
            long v = parsableByteArray0.readUnsignedInt();
            boolean z = (parsableByteArray0.readUnsignedByte() & 0x80) != 0;
            ArrayList arrayList0 = new ArrayList();
            if(!z) {
                int v1 = parsableByteArray0.readUnsignedByte();
                boolean z1 = (v1 & 0x80) != 0;
                boolean z2 = (v1 & 0x40) != 0;
                long v2 = z2 ? parsableByteArray0.readUnsignedInt() : 0x8000000000000001L;
                if(!z2) {
                    int v3 = parsableByteArray0.readUnsignedByte();
                    ArrayList arrayList1 = new ArrayList(v3);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        arrayList1.add(new ComponentSplice(parsableByteArray0.readUnsignedByte(), parsableByteArray0.readUnsignedInt(), null));
                    }
                    arrayList0 = arrayList1;
                }
                if((v1 & 0x20) != 0) {
                    long v5 = (long)parsableByteArray0.readUnsignedByte();
                    return (0x80L & v5) == 0L ? new Event(v, false, z1, z2, arrayList0, v2, false, ((v5 & 1L) << 0x20 | parsableByteArray0.readUnsignedInt()) * 1000L / 90L, parsableByteArray0.readUnsignedShort(), parsableByteArray0.readUnsignedByte(), parsableByteArray0.readUnsignedByte()) : new Event(v, false, z1, z2, arrayList0, v2, true, ((v5 & 1L) << 0x20 | parsableByteArray0.readUnsignedInt()) * 1000L / 90L, parsableByteArray0.readUnsignedShort(), parsableByteArray0.readUnsignedByte(), parsableByteArray0.readUnsignedByte());
                }
                return new Event(v, false, z1, z2, arrayList0, v2, false, 0x8000000000000001L, parsableByteArray0.readUnsignedShort(), parsableByteArray0.readUnsignedByte(), parsableByteArray0.readUnsignedByte());
            }
            return new Event(v, true, false, false, arrayList0, 0x8000000000000001L, false, 0x8000000000000001L, 0, 0, 0);
        }

        private void writeToParcel(Parcel parcel0) {
            parcel0.writeLong(this.spliceEventId);
            parcel0.writeByte(((byte)this.spliceEventCancelIndicator));
            parcel0.writeByte(((byte)this.outOfNetworkIndicator));
            parcel0.writeByte(((byte)this.programSpliceFlag));
            int v = this.componentSpliceList.size();
            parcel0.writeInt(v);
            for(int v1 = 0; v1 < v; ++v1) {
                ((ComponentSplice)this.componentSpliceList.get(v1)).writeToParcel(parcel0);
            }
            parcel0.writeLong(this.utcSpliceTime);
            parcel0.writeByte(((byte)this.autoReturn));
            parcel0.writeLong(this.breakDurationUs);
            parcel0.writeInt(this.uniqueProgramId);
            parcel0.writeInt(this.availNum);
            parcel0.writeInt(this.availsExpected);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final List events;

    static {
        SpliceScheduleCommand.CREATOR = new Parcelable.Creator() {
            public SpliceScheduleCommand createFromParcel(Parcel parcel0) {
                return new SpliceScheduleCommand(parcel0, null);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public SpliceScheduleCommand[] newArray(int v) {
                return new SpliceScheduleCommand[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private SpliceScheduleCommand(Parcel parcel0) {
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(Event.access$300(parcel0));
        }
        this.events = Collections.unmodifiableList(arrayList0);
    }

    public SpliceScheduleCommand(Parcel parcel0, com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1 spliceScheduleCommand$10) {
        this(parcel0);
    }

    private SpliceScheduleCommand(List list0) {
        this.events = Collections.unmodifiableList(list0);
    }

    public static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedByte();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(Event.access$400(parsableByteArray0));
        }
        return new SpliceScheduleCommand(arrayList0);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = this.events.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            Event.access$500(((Event)this.events.get(v2)), parcel0);
        }
    }
}

