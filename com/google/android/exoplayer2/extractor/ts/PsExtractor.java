package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PsExtractor implements Extractor {
    static final class PesReader {
        private static final int PES_SCRATCH_SIZE = 0x40;
        private boolean dtsFlag;
        private int extendedHeaderLength;
        private final ElementaryStreamReader pesPayloadReader;
        private final ParsableBitArray pesScratch;
        private boolean ptsFlag;
        private boolean seenFirstDts;
        private long timeUs;
        private final TimestampAdjuster timestampAdjuster;

        public PesReader(ElementaryStreamReader elementaryStreamReader0, TimestampAdjuster timestampAdjuster0) {
            this.pesPayloadReader = elementaryStreamReader0;
            this.timestampAdjuster = timestampAdjuster0;
            this.pesScratch = new ParsableBitArray(new byte[0x40]);
        }

        public void consume(ParsableByteArray parsableByteArray0) {
            parsableByteArray0.readBytes(this.pesScratch.data, 0, 3);
            this.pesScratch.setPosition(0);
            this.parseHeader();
            parsableByteArray0.readBytes(this.pesScratch.data, 0, this.extendedHeaderLength);
            this.pesScratch.setPosition(0);
            this.parseHeaderExtension();
            this.pesPayloadReader.packetStarted(this.timeUs, 4);
            this.pesPayloadReader.consume(parsableByteArray0);
            this.pesPayloadReader.packetFinished();
        }

        private void parseHeader() {
            this.pesScratch.skipBits(8);
            this.ptsFlag = this.pesScratch.readBit();
            this.dtsFlag = this.pesScratch.readBit();
            this.pesScratch.skipBits(6);
            this.extendedHeaderLength = this.pesScratch.readBits(8);
        }

        private void parseHeaderExtension() {
            this.timeUs = 0L;
            if(this.ptsFlag) {
                this.pesScratch.skipBits(4);
                long v = ((long)this.pesScratch.readBits(3)) << 30;
                this.pesScratch.skipBits(1);
                int v1 = this.pesScratch.readBits(15);
                this.pesScratch.skipBits(1);
                long v2 = v | ((long)(v1 << 15)) | ((long)this.pesScratch.readBits(15));
                this.pesScratch.skipBits(1);
                if(!this.seenFirstDts && this.dtsFlag) {
                    this.pesScratch.skipBits(4);
                    long v3 = ((long)this.pesScratch.readBits(3)) << 30;
                    this.pesScratch.skipBits(1);
                    int v4 = this.pesScratch.readBits(15);
                    this.pesScratch.skipBits(1);
                    long v5 = v3 | ((long)(v4 << 15)) | ((long)this.pesScratch.readBits(15));
                    this.pesScratch.skipBits(1);
                    this.timestampAdjuster.adjustTsTimestamp(v5);
                    this.seenFirstDts = true;
                }
                this.timeUs = this.timestampAdjuster.adjustTsTimestamp(v2);
            }
        }

        public void seek() {
            this.seenFirstDts = false;
            this.pesPayloadReader.seek();
        }
    }

    public static final int AUDIO_STREAM = 0xC0;
    public static final int AUDIO_STREAM_MASK = 0xE0;
    public static final ExtractorsFactory FACTORY = null;
    private static final long MAX_SEARCH_LENGTH = 0x100000L;
    private static final long MAX_SEARCH_LENGTH_AFTER_AUDIO_AND_VIDEO_FOUND = 0x2000L;
    private static final int MAX_STREAM_ID_PLUS_ONE = 0x100;
    static final int MPEG_PROGRAM_END_CODE = 441;
    static final int PACKET_START_CODE_PREFIX = 1;
    static final int PACK_START_CODE = 442;
    public static final int PRIVATE_STREAM_1 = 0xBD;
    static final int SYSTEM_HEADER_START_CODE = 443;
    public static final int VIDEO_STREAM = 0xE0;
    public static final int VIDEO_STREAM_MASK = 0xF0;
    private final PsDurationReader durationReader;
    private boolean foundAllTracks;
    private boolean foundAudioTrack;
    private boolean foundVideoTrack;
    private boolean hasOutputSeekMap;
    private long lastTrackPosition;
    private ExtractorOutput output;
    private PsBinarySearchSeeker psBinarySearchSeeker;
    private final ParsableByteArray psPacketBuffer;
    private final SparseArray psPayloadReaders;
    private final TimestampAdjuster timestampAdjuster;

    static {
        PsExtractor.FACTORY = new b(24);
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0L));
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster0) {
        this.timestampAdjuster = timestampAdjuster0;
        this.psPacketBuffer = new ParsableByteArray(0x1000);
        this.psPayloadReaders = new SparseArray();
        this.durationReader = new PsDurationReader();
    }

    public static Extractor[] a() {
        return PsExtractor.lambda$static$0();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.output = extractorOutput0;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new PsExtractor()};
    }

    private void maybeOutputSeekMap(long v) {
        if(!this.hasOutputSeekMap) {
            this.hasOutputSeekMap = true;
            if(this.durationReader.getDurationUs() != 0x8000000000000001L) {
                PsBinarySearchSeeker psBinarySearchSeeker0 = new PsBinarySearchSeeker(this.durationReader.getScrTimestampAdjuster(), this.durationReader.getDurationUs(), v);
                this.psBinarySearchSeeker = psBinarySearchSeeker0;
                this.output.seekMap(psBinarySearchSeeker0.getSeekMap());
                return;
            }
            this.output.seekMap(new Unseekable(this.durationReader.getDurationUs()));
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        Ac3Reader ac3Reader0;
        long v = extractorInput0.getLength();
        int v1 = Long.compare(v, -1L);
        if(v1 != 0 && !this.durationReader.isDurationReadFinished()) {
            return this.durationReader.readDuration(extractorInput0, positionHolder0);
        }
        this.maybeOutputSeekMap(v);
        if(this.psBinarySearchSeeker != null && this.psBinarySearchSeeker.isSeeking()) {
            return this.psBinarySearchSeeker.handlePendingSeek(extractorInput0, positionHolder0);
        }
        extractorInput0.resetPeekPosition();
        long v2 = v1 == 0 ? -1L : v - extractorInput0.getPeekPosition();
        if(Long.compare(v2, -1L) != 0 && v2 < 4L) {
            return -1;
        }
        if(!extractorInput0.peekFully(this.psPacketBuffer.data, 0, 4, true)) {
            return -1;
        }
        this.psPacketBuffer.setPosition(0);
        int v3 = this.psPacketBuffer.readInt();
        if(v3 == 441) {
            return -1;
        }
        switch(v3) {
            case 442: {
                extractorInput0.peekFully(this.psPacketBuffer.data, 0, 10);
                this.psPacketBuffer.setPosition(9);
                extractorInput0.skipFully((this.psPacketBuffer.readUnsignedByte() & 7) + 14);
                return 0;
            }
            case 443: {
                extractorInput0.peekFully(this.psPacketBuffer.data, 0, 2);
                this.psPacketBuffer.setPosition(0);
                extractorInput0.skipFully(this.psPacketBuffer.readUnsignedShort() + 6);
                return 0;
            }
            default: {
                if((v3 & 0xFFFFFF00) >> 8 != 1) {
                    extractorInput0.skipFully(1);
                    return 0;
                }
                PesReader psExtractor$PesReader0 = (PesReader)this.psPayloadReaders.get(v3 & 0xFF);
                if(!this.foundAllTracks) {
                    if(psExtractor$PesReader0 == null) {
                        if((v3 & 0xFF) == 0xBD) {
                            ac3Reader0 = new Ac3Reader();
                            this.foundAudioTrack = true;
                            this.lastTrackPosition = extractorInput0.getPosition();
                        }
                        else if((v3 & 0xE0) == 0xC0) {
                            ac3Reader0 = new MpegAudioReader();
                            this.foundAudioTrack = true;
                            this.lastTrackPosition = extractorInput0.getPosition();
                        }
                        else if((v3 & 0xF0) == 0xE0) {
                            ac3Reader0 = new H262Reader();
                            this.foundVideoTrack = true;
                            this.lastTrackPosition = extractorInput0.getPosition();
                        }
                        else {
                            ac3Reader0 = null;
                        }
                        if(ac3Reader0 != null) {
                            TrackIdGenerator tsPayloadReader$TrackIdGenerator0 = new TrackIdGenerator(v3 & 0xFF, 0x100);
                            ac3Reader0.createTracks(this.output, tsPayloadReader$TrackIdGenerator0);
                            psExtractor$PesReader0 = new PesReader(ac3Reader0, this.timestampAdjuster);
                            this.psPayloadReaders.put(v3 & 0xFF, psExtractor$PesReader0);
                        }
                    }
                    long v4 = !this.foundAudioTrack || !this.foundVideoTrack ? 0x100000L : this.lastTrackPosition + 0x2000L;
                    if(extractorInput0.getPosition() > v4) {
                        this.foundAllTracks = true;
                        this.output.endTracks();
                    }
                }
                extractorInput0.peekFully(this.psPacketBuffer.data, 0, 2);
                this.psPacketBuffer.setPosition(0);
                int v5 = this.psPacketBuffer.readUnsignedShort();
                if(psExtractor$PesReader0 == null) {
                    extractorInput0.skipFully(v5 + 6);
                    return 0;
                }
                this.psPacketBuffer.reset(v5 + 6);
                extractorInput0.readFully(this.psPacketBuffer.data, 0, v5 + 6);
                this.psPacketBuffer.setPosition(6);
                psExtractor$PesReader0.consume(this.psPacketBuffer);
                this.psPacketBuffer.setLimit(this.psPacketBuffer.capacity());
                return 0;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        if(this.timestampAdjuster.getTimestampOffsetUs() == 0x8000000000000001L || this.timestampAdjuster.getFirstSampleTimestampUs() != 0L && this.timestampAdjuster.getFirstSampleTimestampUs() != v1) {
            this.timestampAdjuster.reset();
            this.timestampAdjuster.setFirstSampleTimestampUs(v1);
        }
        PsBinarySearchSeeker psBinarySearchSeeker0 = this.psBinarySearchSeeker;
        if(psBinarySearchSeeker0 != null) {
            psBinarySearchSeeker0.setSeekTargetUs(v1);
        }
        for(int v2 = 0; v2 < this.psPayloadReaders.size(); ++v2) {
            ((PesReader)this.psPayloadReaders.valueAt(v2)).seek();
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        byte[] arr_b = new byte[14];
        extractorInput0.peekFully(arr_b, 0, 14);
        if(442 != ((arr_b[0] & 0xFF) << 24 | (arr_b[1] & 0xFF) << 16 | (arr_b[2] & 0xFF) << 8 | arr_b[3] & 0xFF)) {
            return false;
        }
        if((arr_b[4] & 0xC4) != 68) {
            return false;
        }
        if((arr_b[6] & 4) != 4) {
            return false;
        }
        if((arr_b[8] & 4) != 4) {
            return false;
        }
        if((arr_b[9] & 1) != 1) {
            return false;
        }
        if((arr_b[12] & 3) != 3) {
            return false;
        }
        extractorInput0.advancePeekPosition(arr_b[13] & 7);
        extractorInput0.peekFully(arr_b, 0, 3);
        return 1 == ((arr_b[0] & 0xFF) << 16 | (arr_b[1] & 0xFF) << 8 | arr_b[2] & 0xFF);
    }
}

