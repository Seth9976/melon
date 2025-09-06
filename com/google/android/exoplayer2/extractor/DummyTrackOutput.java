package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;

public final class DummyTrackOutput implements TrackOutput {
    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format0) {
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput0, int v, boolean z) {
        int v1 = extractorInput0.skip(v);
        if(v1 == -1) {
            if(!z) {
                throw new EOFException();
            }
            return -1;
        }
        return v1;
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray0, int v) {
        parsableByteArray0.skipBytes(v);
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long v, int v1, int v2, int v3, CryptoData trackOutput$CryptoData0) {
    }
}

