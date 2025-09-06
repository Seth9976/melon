package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;

public final class SpliceInfoDecoder implements MetadataDecoder {
    private static final int TYPE_PRIVATE_COMMAND = 0xFF;
    private static final int TYPE_SPLICE_INSERT = 5;
    private static final int TYPE_SPLICE_NULL = 0;
    private static final int TYPE_SPLICE_SCHEDULE = 4;
    private static final int TYPE_TIME_SIGNAL = 6;
    private final ParsableByteArray sectionData;
    private final ParsableBitArray sectionHeader;
    private TimestampAdjuster timestampAdjuster;

    public SpliceInfoDecoder() {
        this.sectionData = new ParsableByteArray();
        this.sectionHeader = new ParsableBitArray();
    }

    @Override  // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer0) {
        SpliceNullCommand spliceNullCommand0;
        ByteBuffer byteBuffer0 = (ByteBuffer)Assertions.checkNotNull(metadataInputBuffer0.data);
        if(this.timestampAdjuster == null || metadataInputBuffer0.subsampleOffsetUs != this.timestampAdjuster.getTimestampOffsetUs()) {
            TimestampAdjuster timestampAdjuster0 = new TimestampAdjuster(metadataInputBuffer0.timeUs);
            this.timestampAdjuster = timestampAdjuster0;
            timestampAdjuster0.adjustSampleTimestamp(metadataInputBuffer0.timeUs - metadataInputBuffer0.subsampleOffsetUs);
        }
        byte[] arr_b = byteBuffer0.array();
        int v = byteBuffer0.limit();
        this.sectionData.reset(arr_b, v);
        this.sectionHeader.reset(arr_b, v);
        this.sectionHeader.skipBits(39);
        long v1 = ((long)this.sectionHeader.readBits(1)) << 0x20 | ((long)this.sectionHeader.readBits(0x20));
        this.sectionHeader.skipBits(20);
        int v2 = this.sectionHeader.readBits(12);
        int v3 = this.sectionHeader.readBits(8);
        this.sectionData.skipBytes(14);
        switch(v3) {
            case 0: {
                spliceNullCommand0 = new SpliceNullCommand();
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            case 4: {
                spliceNullCommand0 = SpliceScheduleCommand.parseFromSection(this.sectionData);
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            case 5: {
                spliceNullCommand0 = SpliceInsertCommand.parseFromSection(this.sectionData, v1, this.timestampAdjuster);
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            case 6: {
                spliceNullCommand0 = TimeSignalCommand.parseFromSection(this.sectionData, v1, this.timestampAdjuster);
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            case 0xFF: {
                spliceNullCommand0 = PrivateCommand.parseFromSection(this.sectionData, v2, v1);
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            default: {
                return new Metadata(new Entry[0]);
            }
        }
    }
}

