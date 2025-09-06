package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class SeiReader {
    private final List closedCaptionFormats;
    private final TrackOutput[] outputs;

    public SeiReader(List list0) {
        this.closedCaptionFormats = list0;
        this.outputs = new TrackOutput[list0.size()];
    }

    public void consume(long v, ParsableByteArray parsableByteArray0) {
        CeaUtil.consume(v, parsableByteArray0, this.outputs);
    }

    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        for(int v = 0; v < this.outputs.length; ++v) {
            tsPayloadReader$TrackIdGenerator0.generateNewId();
            TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 3);
            Format format0 = (Format)this.closedCaptionFormats.get(v);
            String s = String.valueOf(format0.sampleMimeType);
            Assertions.checkArgument("application/cea-608".equals(format0.sampleMimeType) || "application/cea-708".equals(format0.sampleMimeType), (s.length() == 0 ? new String("Invalid closed caption mime type provided: ") : "Invalid closed caption mime type provided: " + s));
            trackOutput0.format(Format.createTextSampleFormat((format0.id == null ? tsPayloadReader$TrackIdGenerator0.getFormatId() : format0.id), format0.sampleMimeType, null, -1, format0.selectionFlags, format0.language, format0.accessibilityChannel, null, 0x7FFFFFFFFFFFFFFFL, format0.initializationData));
            this.outputs[v] = trackOutput0;
        }
    }
}

