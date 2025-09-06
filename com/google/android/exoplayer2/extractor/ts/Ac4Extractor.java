package com.google.android.exoplayer2.extractor.ts;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac4Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = null;
    private static final int FRAME_HEADER_SIZE = 7;
    private static final int MAX_SNIFF_BYTES = 0x2000;
    private static final int READ_BUFFER_SIZE = 0x4000;
    private final Ac4Reader reader;
    private final ParsableByteArray sampleData;
    private boolean startedPacket;

    static {
        Ac4Extractor.FACTORY = new b(22);
    }

    public Ac4Extractor() {
        this.reader = new Ac4Reader();
        this.sampleData = new ParsableByteArray(0x4000);
    }

    public static Extractor[] a() {
        return Ac4Extractor.lambda$static$0();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        TrackIdGenerator tsPayloadReader$TrackIdGenerator0 = new TrackIdGenerator(0, 1);
        this.reader.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
        extractorOutput0.endTracks();
        extractorOutput0.seekMap(new Unseekable(0x8000000000000001L));
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new Ac4Extractor()};
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        int v = extractorInput0.read(this.sampleData.data, 0, 0x4000);
        if(v == -1) {
            return -1;
        }
        this.sampleData.setPosition(0);
        this.sampleData.setLimit(v);
        if(!this.startedPacket) {
            this.reader.packetStarted(0L, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.sampleData);
        return 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.startedPacket = false;
        this.reader.seek();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(10);
        int v = 0;
        while(true) {
            extractorInput0.peekFully(parsableByteArray0.data, 0, 10);
            parsableByteArray0.setPosition(0);
            if(parsableByteArray0.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray0.skipBytes(3);
            int v1 = parsableByteArray0.readSynchSafeInt();
            v += v1 + 10;
            extractorInput0.advancePeekPosition(v1);
        }
        extractorInput0.resetPeekPosition();
        extractorInput0.advancePeekPosition(v);
        int v2 = 0;
        int v3 = v;
        while(true) {
            extractorInput0.peekFully(parsableByteArray0.data, 0, 7);
            parsableByteArray0.setPosition(0);
            int v4 = parsableByteArray0.readUnsignedShort();
            if(v4 != 0xAC40 && v4 != 44097) {
                extractorInput0.resetPeekPosition();
                ++v3;
                if(v3 - v >= 0x2000) {
                    return false;
                }
                extractorInput0.advancePeekPosition(v3);
                v2 = 0;
            }
            else {
                ++v2;
                if(v2 >= 4) {
                    return true;
                }
                int v5 = Ac4Util.parseAc4SyncframeSize(parsableByteArray0.data, v4);
                if(v5 == -1) {
                    return false;
                }
                extractorInput0.advancePeekPosition(v5 - 7);
            }
        }
    }
}

