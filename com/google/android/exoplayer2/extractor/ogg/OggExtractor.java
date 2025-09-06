package com.google.android.exoplayer2.extractor.ogg;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public class OggExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = null;
    private static final int MAX_VERIFICATION_BYTES = 8;
    private ExtractorOutput output;
    private StreamReader streamReader;
    private boolean streamReaderInitialized;

    static {
        OggExtractor.FACTORY = new b(20);
    }

    public static Extractor[] a() {
        return OggExtractor.lambda$static$0();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.output = extractorOutput0;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new OggExtractor()};
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        if(this.streamReader == null) {
            if(!this.sniffInternal(extractorInput0)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            extractorInput0.resetPeekPosition();
        }
        if(!this.streamReaderInitialized) {
            TrackOutput trackOutput0 = this.output.track(0, 1);
            this.output.endTracks();
            this.streamReader.init(this.output, trackOutput0);
            this.streamReaderInitialized = true;
        }
        return this.streamReader.read(extractorInput0, positionHolder0);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    private static ParsableByteArray resetPosition(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.setPosition(0);
        return parsableByteArray0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        StreamReader streamReader0 = this.streamReader;
        if(streamReader0 != null) {
            streamReader0.seek(v, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        try {
            return this.sniffInternal(extractorInput0);
        }
        catch(ParserException unused_ex) {
            return false;
        }
    }

    private boolean sniffInternal(ExtractorInput extractorInput0) {
        OggPageHeader oggPageHeader0 = new OggPageHeader();
        if(oggPageHeader0.populate(extractorInput0, true) && (oggPageHeader0.type & 2) == 2) {
            int v = Math.min(oggPageHeader0.bodySize, 8);
            ParsableByteArray parsableByteArray0 = new ParsableByteArray(v);
            extractorInput0.peekFully(parsableByteArray0.data, 0, v);
            if(FlacReader.verifyBitstreamType(OggExtractor.resetPosition(parsableByteArray0))) {
                this.streamReader = new FlacReader();
                return true;
            }
            if(VorbisReader.verifyBitstreamType(OggExtractor.resetPosition(parsableByteArray0))) {
                this.streamReader = new VorbisReader();
                return true;
            }
            if(OpusReader.verifyBitstreamType(OggExtractor.resetPosition(parsableByteArray0))) {
                this.streamReader = new OpusReader();
                return true;
            }
        }
        return false;
    }
}

