package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class SpliceInfoSectionReader implements SectionPayloadReader {
    private boolean formatDeclared;
    private TrackOutput output;
    private TimestampAdjuster timestampAdjuster;

    @Override  // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void consume(ParsableByteArray parsableByteArray0) {
        if(!this.formatDeclared) {
            if(this.timestampAdjuster.getTimestampOffsetUs() == 0x8000000000000001L) {
                return;
            }
            this.output.format(Format.createSampleFormat(null, "application/x-scte35", this.timestampAdjuster.getTimestampOffsetUs()));
            this.formatDeclared = true;
        }
        int v = parsableByteArray0.bytesLeft();
        this.output.sampleData(parsableByteArray0, v);
        this.output.sampleMetadata(this.timestampAdjuster.getLastAdjustedTimestampUs(), 1, v, 0, null);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster0, ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        this.timestampAdjuster = timestampAdjuster0;
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 4);
        this.output = trackOutput0;
        trackOutput0.format(Format.createSampleFormat(tsPayloadReader$TrackIdGenerator0.getFormatId(), "application/x-scte35", null, -1, null));
    }
}

