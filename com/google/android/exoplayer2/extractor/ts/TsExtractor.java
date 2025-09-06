package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TsExtractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    class PatReader implements SectionPayloadReader {
        private final ParsableBitArray patScratch;

        public PatReader() {
            this.patScratch = new ParsableBitArray(new byte[4]);
        }

        @Override  // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray0) {
            if(parsableByteArray0.readUnsignedByte() == 0 && (parsableByteArray0.readUnsignedByte() & 0x80) != 0) {
                parsableByteArray0.skipBytes(6);
                int v = parsableByteArray0.bytesLeft();
                for(int v1 = 0; v1 < v / 4; ++v1) {
                    parsableByteArray0.readBytes(this.patScratch, 4);
                    int v2 = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if(v2 == 0) {
                        this.patScratch.skipBits(13);
                    }
                    else {
                        int v3 = this.patScratch.readBits(13);
                        SectionReader sectionReader0 = new SectionReader(new PmtReader(TsExtractor.this, v3));
                        TsExtractor.this.tsPayloadReaders.put(v3, sectionReader0);
                        TsExtractor.access$108(TsExtractor.this);
                    }
                }
                if(TsExtractor.this.mode != 2) {
                    TsExtractor.this.tsPayloadReaders.remove(0);
                }
            }
        }

        @Override  // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster0, ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        }
    }

    class PmtReader implements SectionPayloadReader {
        private static final int TS_PMT_DESC_AC3 = 106;
        private static final int TS_PMT_DESC_DTS = 0x7B;
        private static final int TS_PMT_DESC_DVBSUBS = 89;
        private static final int TS_PMT_DESC_DVB_EXT = 0x7F;
        private static final int TS_PMT_DESC_DVB_EXT_AC4 = 21;
        private static final int TS_PMT_DESC_EAC3 = 0x7A;
        private static final int TS_PMT_DESC_ISO639_LANG = 10;
        private static final int TS_PMT_DESC_REGISTRATION = 5;
        private final int pid;
        private final ParsableBitArray pmtScratch;
        private final SparseIntArray trackIdToPidScratch;
        private final SparseArray trackIdToReaderScratch;

        public PmtReader(int v) {
            this.pmtScratch = new ParsableBitArray(new byte[5]);
            this.trackIdToReaderScratch = new SparseArray();
            this.trackIdToPidScratch = new SparseIntArray();
            this.pid = v;
        }

        @Override  // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray0) {
            TimestampAdjuster timestampAdjuster0;
            int v = 0;
            if(parsableByteArray0.readUnsignedByte() == 2) {
                if(TsExtractor.this.mode == 1 || TsExtractor.this.mode == 2 || TsExtractor.this.remainingPmts == 1) {
                    timestampAdjuster0 = (TimestampAdjuster)TsExtractor.this.timestampAdjusters.get(0);
                }
                else {
                    timestampAdjuster0 = new TimestampAdjuster(((TimestampAdjuster)TsExtractor.this.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                    TsExtractor.this.timestampAdjusters.add(timestampAdjuster0);
                }
                if((parsableByteArray0.readUnsignedByte() & 0x80) != 0) {
                    parsableByteArray0.skipBytes(1);
                    int v1 = parsableByteArray0.readUnsignedShort();
                    parsableByteArray0.skipBytes(3);
                    parsableByteArray0.readBytes(this.pmtScratch, 2);
                    this.pmtScratch.skipBits(3);
                    int v2 = this.pmtScratch.readBits(13);
                    TsExtractor.this.pcrPid = v2;
                    parsableByteArray0.readBytes(this.pmtScratch, 2);
                    this.pmtScratch.skipBits(4);
                    parsableByteArray0.skipBytes(this.pmtScratch.readBits(12));
                    if(TsExtractor.this.mode == 2 && TsExtractor.this.id3Reader == null) {
                        EsInfo tsPayloadReader$EsInfo0 = new EsInfo(21, null, null, Util.EMPTY_BYTE_ARRAY);
                        TsPayloadReader tsPayloadReader0 = TsExtractor.this.payloadReaderFactory.createPayloadReader(21, tsPayloadReader$EsInfo0);
                        TsExtractor.this.id3Reader = tsPayloadReader0;
                        TrackIdGenerator tsPayloadReader$TrackIdGenerator0 = new TrackIdGenerator(v1, 21, 0x2000);
                        TsExtractor.this.id3Reader.init(timestampAdjuster0, TsExtractor.this.output, tsPayloadReader$TrackIdGenerator0);
                    }
                    this.trackIdToReaderScratch.clear();
                    this.trackIdToPidScratch.clear();
                    int v3 = parsableByteArray0.bytesLeft();
                    while(v3 > 0) {
                        parsableByteArray0.readBytes(this.pmtScratch, 5);
                        int v4 = this.pmtScratch.readBits(8);
                        this.pmtScratch.skipBits(3);
                        int v5 = this.pmtScratch.readBits(13);
                        this.pmtScratch.skipBits(4);
                        int v6 = this.pmtScratch.readBits(12);
                        EsInfo tsPayloadReader$EsInfo1 = this.readEsInfo(parsableByteArray0, v6);
                        if(v4 == 6) {
                            v4 = tsPayloadReader$EsInfo1.streamType;
                        }
                        v3 -= v6 + 5;
                        int v7 = TsExtractor.this.mode == 2 ? v4 : v5;
                        if(!TsExtractor.this.trackIds.get(v7)) {
                            TsPayloadReader tsPayloadReader1 = TsExtractor.this.mode != 2 || v4 != 21 ? TsExtractor.this.payloadReaderFactory.createPayloadReader(v4, tsPayloadReader$EsInfo1) : TsExtractor.this.id3Reader;
                            if(TsExtractor.this.mode != 2 || v5 < this.trackIdToPidScratch.get(v7, 0x2000)) {
                                this.trackIdToPidScratch.put(v7, v5);
                                this.trackIdToReaderScratch.put(v7, tsPayloadReader1);
                            }
                        }
                    }
                    int v8 = this.trackIdToPidScratch.size();
                    for(int v9 = 0; v9 < v8; ++v9) {
                        int v10 = this.trackIdToPidScratch.keyAt(v9);
                        int v11 = this.trackIdToPidScratch.valueAt(v9);
                        TsExtractor.this.trackIds.put(v10, true);
                        TsExtractor.this.trackPids.put(v11, true);
                        TsPayloadReader tsPayloadReader2 = (TsPayloadReader)this.trackIdToReaderScratch.valueAt(v9);
                        if(tsPayloadReader2 != null) {
                            if(tsPayloadReader2 != TsExtractor.this.id3Reader) {
                                TrackIdGenerator tsPayloadReader$TrackIdGenerator1 = new TrackIdGenerator(v1, v10, 0x2000);
                                tsPayloadReader2.init(timestampAdjuster0, TsExtractor.this.output, tsPayloadReader$TrackIdGenerator1);
                            }
                            TsExtractor.this.tsPayloadReaders.put(v11, tsPayloadReader2);
                        }
                    }
                    if(TsExtractor.this.mode != 2) {
                        TsExtractor.this.tsPayloadReaders.remove(this.pid);
                        TsExtractor tsExtractor0 = TsExtractor.this;
                        if(tsExtractor0.mode != 1) {
                            v = TsExtractor.this.remainingPmts - 1;
                        }
                        tsExtractor0.remainingPmts = v;
                        if(TsExtractor.this.remainingPmts == 0) {
                            TsExtractor.this.output.endTracks();
                            TsExtractor.this.tracksEnded = true;
                        }
                    }
                    else if(!TsExtractor.this.tracksEnded) {
                        TsExtractor.this.output.endTracks();
                        TsExtractor.this.remainingPmts = 0;
                        TsExtractor.this.tracksEnded = true;
                    }
                }
            }
        }

        @Override  // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster0, ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        }

        private EsInfo readEsInfo(ParsableByteArray parsableByteArray0, int v) {
            int v1 = parsableByteArray0.getPosition();
            int v2 = v + v1;
            int v3 = -1;
            String s = null;
            List list0 = null;
            while(parsableByteArray0.getPosition() < v2) {
                int v4 = parsableByteArray0.readUnsignedByte();
                int v5 = parsableByteArray0.getPosition() + parsableByteArray0.readUnsignedByte();
                switch(v4) {
                    case 5: {
                        long v6 = parsableByteArray0.readUnsignedInt();
                        if(v6 == 1094921523L) {
                            v3 = 0x81;
                        }
                        else if(v6 == 1161904947L) {
                            v3 = 0x87;
                        }
                        else if(v6 == 1094921524L) {
                            v3 = 0xAC;
                        }
                        else if(v6 == 1212503619L) {
                            v3 = 36;
                        }
                        break;
                    }
                    case 10: {
                        s = parsableByteArray0.readString(3).trim();
                        break;
                    }
                    case 89: {
                        ArrayList arrayList0 = new ArrayList();
                        while(parsableByteArray0.getPosition() < v5) {
                            String s1 = parsableByteArray0.readString(3).trim();
                            int v7 = parsableByteArray0.readUnsignedByte();
                            byte[] arr_b = new byte[4];
                            parsableByteArray0.readBytes(arr_b, 0, 4);
                            arrayList0.add(new DvbSubtitleInfo(s1, v7, arr_b));
                        }
                        list0 = arrayList0;
                        v3 = 89;
                        break;
                    }
                    case 106: {
                        v3 = 0x81;
                        break;
                    }
                    case 0x7A: {
                        v3 = 0x87;
                        break;
                    }
                    case 0x7B: {
                        v3 = 0x8A;
                        break;
                    }
                    case 0x7F: {
                        if(parsableByteArray0.readUnsignedByte() == 21) {
                            v3 = 0xAC;
                        }
                    }
                }
                parsableByteArray0.skipBytes(v5 - parsableByteArray0.getPosition());
            }
            parsableByteArray0.setPosition(v2);
            return new EsInfo(v3, s, list0, Arrays.copyOfRange(parsableByteArray0.data, v1, v2));
        }
    }

    private static final long AC3_FORMAT_IDENTIFIER = 1094921523L;
    private static final long AC4_FORMAT_IDENTIFIER = 1094921524L;
    private static final int BUFFER_SIZE = 9400;
    private static final long E_AC3_FORMAT_IDENTIFIER = 1161904947L;
    public static final ExtractorsFactory FACTORY = null;
    private static final long HEVC_FORMAT_IDENTIFIER = 1212503619L;
    private static final int MAX_PID_PLUS_ONE = 0x2000;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    private static final int SNIFF_TS_PACKET_COUNT = 5;
    public static final int TS_PACKET_SIZE = 0xBC;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 0x81;
    public static final int TS_STREAM_TYPE_AC4 = 0xAC;
    public static final int TS_STREAM_TYPE_DTS = 0x8A;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 0x87;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 0x86;
    public static final int TS_SYNC_BYTE = 71;
    private int bytesSinceLastSync;
    private final SparseIntArray continuityCounters;
    private final TsDurationReader durationReader;
    private boolean hasOutputSeekMap;
    private TsPayloadReader id3Reader;
    private final int mode;
    private ExtractorOutput output;
    private final Factory payloadReaderFactory;
    private int pcrPid;
    private boolean pendingSeekToStart;
    private int remainingPmts;
    private final List timestampAdjusters;
    private final SparseBooleanArray trackIds;
    private final SparseBooleanArray trackPids;
    private boolean tracksEnded;
    private TsBinarySearchSeeker tsBinarySearchSeeker;
    private final ParsableByteArray tsPacketBuffer;
    private final SparseArray tsPayloadReaders;

    static {
        TsExtractor.FACTORY = new b(25);
    }

    public TsExtractor() {
        this(0);
    }

    public TsExtractor(int v) {
        this(1, v);
    }

    public TsExtractor(int v, int v1) {
        this(v, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(v1));
    }

    public TsExtractor(int v, TimestampAdjuster timestampAdjuster0, Factory tsPayloadReader$Factory0) {
        this.payloadReaderFactory = (Factory)Assertions.checkNotNull(tsPayloadReader$Factory0);
        this.mode = v;
        if(v == 1 || v == 2) {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster0);
        }
        else {
            ArrayList arrayList0 = new ArrayList();
            this.timestampAdjusters = arrayList0;
            arrayList0.add(timestampAdjuster0);
        }
        this.tsPacketBuffer = new ParsableByteArray(new byte[9400], 0);
        this.trackIds = new SparseBooleanArray();
        this.trackPids = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray();
        this.continuityCounters = new SparseIntArray();
        this.durationReader = new TsDurationReader();
        this.pcrPid = -1;
        this.resetPayloadReaders();
    }

    public static Extractor[] a() {
        return TsExtractor.lambda$static$0();
    }

    public static int access$108(TsExtractor tsExtractor0) {
        int v = tsExtractor0.remainingPmts;
        tsExtractor0.remainingPmts = v + 1;
        return v;
    }

    private boolean fillBufferWithAtLeastOnePacket(ExtractorInput extractorInput0) {
        byte[] arr_b = this.tsPacketBuffer.data;
        if(9400 - this.tsPacketBuffer.getPosition() < 0xBC) {
            int v = this.tsPacketBuffer.bytesLeft();
            if(v > 0) {
                System.arraycopy(arr_b, this.tsPacketBuffer.getPosition(), arr_b, 0, v);
            }
            this.tsPacketBuffer.reset(arr_b, v);
        }
        while(this.tsPacketBuffer.bytesLeft() < 0xBC) {
            int v1 = this.tsPacketBuffer.limit();
            int v2 = extractorInput0.read(arr_b, v1, 9400 - v1);
            if(v2 == -1) {
                return false;
            }
            this.tsPacketBuffer.setLimit(v1 + v2);
        }
        return true;
    }

    private int findEndOfFirstTsPacketInBuffer() {
        int v = this.tsPacketBuffer.getPosition();
        int v1 = this.tsPacketBuffer.limit();
        int v2 = TsUtil.findSyncBytePosition(this.tsPacketBuffer.data, v, v1);
        this.tsPacketBuffer.setPosition(v2);
        if(v2 + 0xBC > v1) {
            int v3 = v2 - v + this.bytesSinceLastSync;
            this.bytesSinceLastSync = v3;
            if(this.mode == 2 && v3 > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
            return v2 + 0xBC;
        }
        this.bytesSinceLastSync = 0;
        return v2 + 0xBC;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.output = extractorOutput0;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new TsExtractor()};
    }

    private void maybeOutputSeekMap(long v) {
        if(!this.hasOutputSeekMap) {
            this.hasOutputSeekMap = true;
            if(this.durationReader.getDurationUs() != 0x8000000000000001L) {
                TsBinarySearchSeeker tsBinarySearchSeeker0 = new TsBinarySearchSeeker(this.durationReader.getPcrTimestampAdjuster(), this.durationReader.getDurationUs(), v, this.pcrPid);
                this.tsBinarySearchSeeker = tsBinarySearchSeeker0;
                this.output.seekMap(tsBinarySearchSeeker0.getSeekMap());
                return;
            }
            this.output.seekMap(new Unseekable(this.durationReader.getDurationUs()));
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        long v = extractorInput0.getLength();
        if(this.tracksEnded) {
            if(v != -1L && this.mode != 2 && !this.durationReader.isDurationReadFinished()) {
                return this.durationReader.readDuration(extractorInput0, positionHolder0, this.pcrPid);
            }
            this.maybeOutputSeekMap(v);
            if(this.pendingSeekToStart) {
                this.pendingSeekToStart = false;
                this.seek(0L, 0L);
                if(extractorInput0.getPosition() != 0L) {
                    positionHolder0.position = 0L;
                    return 1;
                }
            }
            if(this.tsBinarySearchSeeker != null && this.tsBinarySearchSeeker.isSeeking()) {
                return this.tsBinarySearchSeeker.handlePendingSeek(extractorInput0, positionHolder0);
            }
        }
        if(!this.fillBufferWithAtLeastOnePacket(extractorInput0)) {
            return -1;
        }
        int v1 = this.findEndOfFirstTsPacketInBuffer();
        int v2 = this.tsPacketBuffer.limit();
        if(v1 > v2) {
            return 0;
        }
        int v3 = this.tsPacketBuffer.readInt();
        if((0x800000 & v3) != 0) {
            this.tsPacketBuffer.setPosition(v1);
            return 0;
        }
        int v4 = (0x400000 & v3) == 0 ? 0 : 1;
        int v5 = (0x1FFF00 & v3) >> 8;
        TsPayloadReader tsPayloadReader0 = (v3 & 16) == 0 ? null : ((TsPayloadReader)this.tsPayloadReaders.get(v5));
        if(tsPayloadReader0 == null) {
            this.tsPacketBuffer.setPosition(v1);
            return 0;
        }
        if(this.mode != 2) {
            int v6 = this.continuityCounters.get(v5, (v3 & 15) - 1);
            this.continuityCounters.put(v5, v3 & 15);
            if(v6 == (v3 & 15)) {
                this.tsPacketBuffer.setPosition(v1);
                return 0;
            }
            if((v3 & 15) != (v6 + 1 & 15)) {
                tsPayloadReader0.seek();
            }
        }
        if((v3 & 0x20) != 0) {
            int v7 = this.tsPacketBuffer.readUnsignedByte();
            v4 |= ((this.tsPacketBuffer.readUnsignedByte() & 0x40) == 0 ? 0 : 2);
            this.tsPacketBuffer.skipBytes(v7 - 1);
        }
        boolean z = this.tracksEnded;
        if(this.shouldConsumePacketPayload(v5)) {
            this.tsPacketBuffer.setLimit(v1);
            tsPayloadReader0.consume(this.tsPacketBuffer, v4);
            this.tsPacketBuffer.setLimit(v2);
        }
        if(this.mode != 2 && !z && this.tracksEnded && v != -1L) {
            this.pendingSeekToStart = true;
        }
        this.tsPacketBuffer.setPosition(v1);
        return 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray sparseArray0 = this.payloadReaderFactory.createInitialPayloadReaders();
        int v = sparseArray0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = sparseArray0.keyAt(v1);
            TsPayloadReader tsPayloadReader0 = (TsPayloadReader)sparseArray0.valueAt(v1);
            this.tsPayloadReaders.put(v2, tsPayloadReader0);
        }
        SectionReader sectionReader0 = new SectionReader(new PatReader(this));
        this.tsPayloadReaders.put(0, sectionReader0);
        this.id3Reader = null;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        Assertions.checkState(this.mode != 2);
        int v2 = this.timestampAdjusters.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            TimestampAdjuster timestampAdjuster0 = (TimestampAdjuster)this.timestampAdjusters.get(v3);
            if(timestampAdjuster0.getTimestampOffsetUs() == 0x8000000000000001L || timestampAdjuster0.getTimestampOffsetUs() != 0L && timestampAdjuster0.getFirstSampleTimestampUs() != v1) {
                timestampAdjuster0.reset();
                timestampAdjuster0.setFirstSampleTimestampUs(v1);
            }
        }
        if(v1 != 0L) {
            TsBinarySearchSeeker tsBinarySearchSeeker0 = this.tsBinarySearchSeeker;
            if(tsBinarySearchSeeker0 != null) {
                tsBinarySearchSeeker0.setSeekTargetUs(v1);
            }
        }
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        for(int v4 = 0; v4 < this.tsPayloadReaders.size(); ++v4) {
            ((TsPayloadReader)this.tsPayloadReaders.valueAt(v4)).seek();
        }
        this.bytesSinceLastSync = 0;
    }

    // 去混淆评级： 低(20)
    private boolean shouldConsumePacketPayload(int v) {
        return this.mode == 2 || this.tracksEnded || !this.trackPids.get(v, false);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        byte[] arr_b = this.tsPacketBuffer.data;
        extractorInput0.peekFully(arr_b, 0, 940);
        int v = 0;
    label_3:
        while(v < 0xBC) {
            int v1 = 0;
            while(v1 < 5) {
                if(arr_b[v1 * 0xBC + v] == 71) {
                    ++v1;
                    continue;
                }
                ++v;
                continue label_3;
            }
            extractorInput0.skipFully(v);
            return true;
        }
        return false;
    }
}

