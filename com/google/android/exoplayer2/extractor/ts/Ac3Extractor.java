package com.google.android.exoplayer2.extractor.ts;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac3Extractor implements Extractor {
    private static final int AC3_SYNC_WORD = 0xB77;
    public static final ExtractorsFactory FACTORY = null;
    private static final int MAX_SNIFF_BYTES = 0x2000;
    private static final int MAX_SYNC_FRAME_SIZE = 0xAE2;
    private final Ac3Reader reader;
    private final ParsableByteArray sampleData;
    private boolean startedPacket;

    static {
        Ac3Extractor.FACTORY = new b(21);
    }

    public Ac3Extractor() {
        this.reader = new Ac3Reader();
        this.sampleData = new ParsableByteArray(0xAE2);
    }

    public static Extractor[] a() {
        return Ac3Extractor.lambda$static$0();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        TrackIdGenerator tsPayloadReader$TrackIdGenerator0 = new TrackIdGenerator(0, 1);
        this.reader.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
        extractorOutput0.endTracks();
        extractorOutput0.seekMap(new Unseekable(0x8000000000000001L));
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new Ac3Extractor()};
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        int v = extractorInput0.read(this.sampleData.data, 0, 0xAE2);
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
            extractorInput0.peekFully(parsableByteArray0.data, 0, 6);
            parsableByteArray0.setPosition(0);
            if(parsableByteArray0.readUnsignedShort() == 0xB77) {
                ++v2;
                if(v2 >= 4) {
                    return true;
                }
                int v4 = Ac3Util.parseAc3SyncframeSize(parsableByteArray0.data);
                if(v4 == -1) {
                    return false;
                }
                extractorInput0.advancePeekPosition(v4 - 6);
            }
            else {
                extractorInput0.resetPeekPosition();
                ++v3;
                if(v3 - v >= 0x2000) {
                    return false;
                }
                extractorInput0.advancePeekPosition(v3);
                v2 = 0;
            }
        }
    }
}

