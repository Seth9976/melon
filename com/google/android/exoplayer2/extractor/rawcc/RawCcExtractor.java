package com.google.android.exoplayer2.extractor.rawcc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class RawCcExtractor implements Extractor {
    private static final int HEADER_ID = 0x52434301;
    private static final int HEADER_SIZE = 8;
    private static final int SCRATCH_SIZE = 9;
    private static final int STATE_READING_HEADER = 0;
    private static final int STATE_READING_SAMPLES = 2;
    private static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
    private static final int TIMESTAMP_SIZE_V0 = 4;
    private static final int TIMESTAMP_SIZE_V1 = 8;
    private final ParsableByteArray dataScratch;
    private final Format format;
    private int parserState;
    private int remainingSampleCount;
    private int sampleBytesWritten;
    private long timestampUs;
    private TrackOutput trackOutput;
    private int version;

    public RawCcExtractor(Format format0) {
        this.format = format0;
        this.dataScratch = new ParsableByteArray(9);
        this.parserState = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        extractorOutput0.seekMap(new Unseekable(0x8000000000000001L));
        this.trackOutput = extractorOutput0.track(0, 3);
        extractorOutput0.endTracks();
        this.trackOutput.format(this.format);
    }

    private boolean parseHeader(ExtractorInput extractorInput0) {
        this.dataScratch.reset();
        if(extractorInput0.readFully(this.dataScratch.data, 0, 8, true)) {
            if(this.dataScratch.readInt() != 0x52434301) {
                throw new IOException("Input not RawCC");
            }
            this.version = this.dataScratch.readUnsignedByte();
            return true;
        }
        return false;
    }

    private void parseSamples(ExtractorInput extractorInput0) {
        while(this.remainingSampleCount > 0) {
            this.dataScratch.reset();
            extractorInput0.readFully(this.dataScratch.data, 0, 3);
            this.trackOutput.sampleData(this.dataScratch, 3);
            this.sampleBytesWritten += 3;
            --this.remainingSampleCount;
        }
        int v = this.sampleBytesWritten;
        if(v > 0) {
            this.trackOutput.sampleMetadata(this.timestampUs, 1, v, 0, null);
        }
    }

    private boolean parseTimestampAndSampleCount(ExtractorInput extractorInput0) {
        this.dataScratch.reset();
        int v = this.version;
        if(v == 0) {
            if(!extractorInput0.readFully(this.dataScratch.data, 0, 5, true)) {
                return false;
            }
            this.timestampUs = this.dataScratch.readUnsignedInt() * 1000L / 45L;
        }
        else if(v == 1) {
            if(!extractorInput0.readFully(this.dataScratch.data, 0, 9, true)) {
                return false;
            }
            this.timestampUs = this.dataScratch.readLong();
        }
        else {
            throw new ParserException("Unsupported version number: " + this.version);
        }
        this.remainingSampleCount = this.dataScratch.readUnsignedByte();
        this.sampleBytesWritten = 0;
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        while(true) {
            int v = this.parserState;
            if(v != 0) {
                switch(v) {
                    case 1: {
                        if(this.parseTimestampAndSampleCount(extractorInput0)) {
                            this.parserState = 2;
                            continue;
                        }
                        this.parserState = 0;
                        return -1;
                    }
                    case 2: {
                        this.parseSamples(extractorInput0);
                        this.parserState = 1;
                        return 0;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
            if(!this.parseHeader(extractorInput0)) {
                break;
            }
            this.parserState = 1;
        }
        return -1;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.parserState = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        this.dataScratch.reset();
        extractorInput0.peekFully(this.dataScratch.data, 0, 8);
        return this.dataScratch.readInt() == 0x52434301;
    }
}

