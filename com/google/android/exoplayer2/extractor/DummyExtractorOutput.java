package com.google.android.exoplayer2.extractor;

public final class DummyExtractorOutput implements ExtractorOutput {
    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap0) {
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int v, int v1) {
        return new DummyTrackOutput();
    }
}

