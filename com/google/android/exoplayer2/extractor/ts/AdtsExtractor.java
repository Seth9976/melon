package com.google.android.exoplayer2.extractor.ts;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AdtsExtractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_PACKET_SIZE = 0x800;
    private static final int MAX_SNIFF_BYTES = 0x2000;
    private static final int NUM_FRAMES_FOR_AVERAGE_FRAME_SIZE = 1000;
    private int averageFrameSize;
    private ExtractorOutput extractorOutput;
    private long firstFramePosition;
    private long firstSampleTimestampUs;
    private final int flags;
    private boolean hasCalculatedAverageFrameSize;
    private boolean hasOutputSeekMap;
    private final ParsableByteArray packetBuffer;
    private final AdtsReader reader;
    private final ParsableByteArray scratch;
    private final ParsableBitArray scratchBits;
    private boolean startedPacket;

    static {
        AdtsExtractor.FACTORY = new b(23);
    }

    public AdtsExtractor() {
        this(0);
    }

    public AdtsExtractor(int v) {
        this.flags = v;
        this.reader = new AdtsReader(true);
        this.packetBuffer = new ParsableByteArray(0x800);
        this.averageFrameSize = -1;
        this.firstFramePosition = -1L;
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(10);
        this.scratch = parsableByteArray0;
        this.scratchBits = new ParsableBitArray(parsableByteArray0.data);
    }

    public static Extractor[] a() {
        return AdtsExtractor.lambda$static$0();
    }

    private void calculateAverageFrameSize(ExtractorInput extractorInput0) {
        if(this.hasCalculatedAverageFrameSize) {
            return;
        }
        this.averageFrameSize = -1;
        extractorInput0.resetPeekPosition();
        long v = 0L;
        if(extractorInput0.getPosition() == 0L) {
            this.peekId3Header(extractorInput0);
        }
        int v1 = 0;
        int v2 = 0;
        try {
            while(extractorInput0.peekFully(this.scratch.data, 0, 2, true)) {
                this.scratch.setPosition(0);
                if(!AdtsReader.isAdtsSyncWord(this.scratch.readUnsignedShort())) {
                    goto label_25;
                }
                if(!extractorInput0.peekFully(this.scratch.data, 0, 4, true)) {
                    break;
                }
                this.scratchBits.setPosition(14);
                int v3 = this.scratchBits.readBits(13);
                if(v3 <= 6) {
                    this.hasCalculatedAverageFrameSize = true;
                    throw new ParserException("Malformed ADTS stream");
                }
                v += (long)v3;
                ++v2;
                if(v2 == 1000 || !extractorInput0.advancePeekPosition(v3 - 6, true)) {
                    break;
                }
            }
        label_23:
            v1 = v2;
        }
        catch(EOFException unused_ex) {
            goto label_23;
        }
    label_25:
        extractorInput0.resetPeekPosition();
        this.averageFrameSize = v1 > 0 ? ((int)(v / ((long)v1))) : -1;
        this.hasCalculatedAverageFrameSize = true;
    }

    private static int getBitrateFromFrameSize(int v, long v1) {
        return (int)(((long)(v * 8)) * 1000000L / v1);
    }

    private SeekMap getConstantBitrateSeekMap(long v) {
        int v1 = AdtsExtractor.getBitrateFromFrameSize(this.averageFrameSize, this.reader.getSampleDurationUs());
        return new ConstantBitrateSeekMap(v, this.firstFramePosition, v1, this.averageFrameSize);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        TrackIdGenerator tsPayloadReader$TrackIdGenerator0 = new TrackIdGenerator(0, 1);
        this.reader.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
        extractorOutput0.endTracks();
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new AdtsExtractor()};
    }

    private void maybeOutputSeekMap(long v, boolean z, boolean z1) {
        if(!this.hasOutputSeekMap) {
            boolean z2 = z && this.averageFrameSize > 0;
            if(!z2 || this.reader.getSampleDurationUs() != 0x8000000000000001L || z1) {
                ExtractorOutput extractorOutput0 = (ExtractorOutput)Assertions.checkNotNull(this.extractorOutput);
                if(!z2 || this.reader.getSampleDurationUs() == 0x8000000000000001L) {
                    extractorOutput0.seekMap(new Unseekable(0x8000000000000001L));
                }
                else {
                    extractorOutput0.seekMap(this.getConstantBitrateSeekMap(v));
                }
                this.hasOutputSeekMap = true;
            }
        }
    }

    private int peekId3Header(ExtractorInput extractorInput0) {
        int v = 0;
        while(true) {
            extractorInput0.peekFully(this.scratch.data, 0, 10);
            this.scratch.setPosition(0);
            if(this.scratch.readUnsignedInt24() != 4801587) {
                break;
            }
            this.scratch.skipBytes(3);
            int v1 = this.scratch.readSynchSafeInt();
            v += v1 + 10;
            extractorInput0.advancePeekPosition(v1);
        }
        extractorInput0.resetPeekPosition();
        extractorInput0.advancePeekPosition(v);
        if(this.firstFramePosition == -1L) {
            this.firstFramePosition = (long)v;
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        long v = extractorInput0.getLength();
        boolean z = (this.flags & 1) != 0 && v != -1L;
        if(z) {
            this.calculateAverageFrameSize(extractorInput0);
        }
        int v1 = extractorInput0.read(this.packetBuffer.data, 0, 0x800);
        this.maybeOutputSeekMap(v, z, v1 == -1);
        if(v1 == -1) {
            return -1;
        }
        this.packetBuffer.setPosition(0);
        this.packetBuffer.setLimit(v1);
        if(!this.startedPacket) {
            this.reader.packetStarted(this.firstSampleTimestampUs, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.packetBuffer);
        return 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.startedPacket = false;
        this.reader.seek();
        this.firstSampleTimestampUs = v1;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        int v3;
        int v2;
        int v = this.peekId3Header(extractorInput0);
        int v1 = v;
        while(true) {
            v2 = 0;
            v3 = 0;
        label_4:
            extractorInput0.peekFully(this.scratch.data, 0, 2);
            this.scratch.setPosition(0);
            if(AdtsReader.isAdtsSyncWord(this.scratch.readUnsignedShort())) {
                break;
            }
            extractorInput0.resetPeekPosition();
            ++v1;
            if(v1 - v >= 0x2000) {
                return false;
            }
            extractorInput0.advancePeekPosition(v1);
        }
        ++v2;
        if(v2 >= 4 && v3 > 0xBC) {
            return true;
        }
        extractorInput0.peekFully(this.scratch.data, 0, 4);
        this.scratchBits.setPosition(14);
        int v4 = this.scratchBits.readBits(13);
        if(v4 > 6) {
            extractorInput0.advancePeekPosition(v4 - 6);
            v3 += v4;
            goto label_4;
        }
        return false;
    }
}

