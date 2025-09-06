package com.google.android.exoplayer2.extractor.mp4;

final class DefaultSampleValues {
    public final int duration;
    public final int flags;
    public final int sampleDescriptionIndex;
    public final int size;

    public DefaultSampleValues(int v, int v1, int v2, int v3) {
        this.sampleDescriptionIndex = v;
        this.duration = v1;
        this.size = v2;
        this.flags = v3;
    }
}

