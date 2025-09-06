package com.google.android.exoplayer2.extractor.wav;

final class WavHeader {
    public final int averageBytesPerSecond;
    public final int bitsPerSample;
    public final int blockSize;
    public final byte[] extraData;
    public final int formatType;
    public final int frameRateHz;
    public final int numChannels;

    public WavHeader(int v, int v1, int v2, int v3, int v4, int v5, byte[] arr_b) {
        this.formatType = v;
        this.numChannels = v1;
        this.frameRateHz = v2;
        this.averageBytesPerSecond = v3;
        this.blockSize = v4;
        this.bitsPerSample = v5;
        this.extraData = arr_b;
    }
}

