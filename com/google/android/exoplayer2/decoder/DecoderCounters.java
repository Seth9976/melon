package com.google.android.exoplayer2.decoder;

public final class DecoderCounters {
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedBufferCount;
    public int droppedToKeyframeCount;
    public int inputBufferCount;
    public int maxConsecutiveDroppedBufferCount;
    public int renderedOutputBufferCount;
    public int skippedInputBufferCount;
    public int skippedOutputBufferCount;

    public void ensureUpdated() {
        synchronized(this) {
        }
    }

    public void merge(DecoderCounters decoderCounters0) {
        this.decoderInitCount += decoderCounters0.decoderInitCount;
        this.decoderReleaseCount += decoderCounters0.decoderReleaseCount;
        this.inputBufferCount += decoderCounters0.inputBufferCount;
        this.skippedInputBufferCount += decoderCounters0.skippedInputBufferCount;
        this.renderedOutputBufferCount += decoderCounters0.renderedOutputBufferCount;
        this.skippedOutputBufferCount += decoderCounters0.skippedOutputBufferCount;
        this.droppedBufferCount += decoderCounters0.droppedBufferCount;
        this.maxConsecutiveDroppedBufferCount = Math.max(this.maxConsecutiveDroppedBufferCount, decoderCounters0.maxConsecutiveDroppedBufferCount);
        this.droppedToKeyframeCount += decoderCounters0.droppedToKeyframeCount;
    }
}

