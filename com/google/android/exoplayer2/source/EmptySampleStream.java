package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public final class EmptySampleStream implements SampleStream {
    @Override  // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
        decoderInputBuffer0.setFlags(4);
        return -4;
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long v) {
        return 0;
    }
}

