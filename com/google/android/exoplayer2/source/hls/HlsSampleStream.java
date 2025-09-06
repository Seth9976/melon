package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;

final class HlsSampleStream implements SampleStream {
    private int sampleQueueIndex;
    private final HlsSampleStreamWrapper sampleStreamWrapper;
    private final int trackGroupIndex;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper0, int v) {
        this.sampleStreamWrapper = hlsSampleStreamWrapper0;
        this.trackGroupIndex = v;
        this.sampleQueueIndex = -1;
    }

    public void bindSampleQueue() {
        Assertions.checkArgument(this.sampleQueueIndex == -1);
        this.sampleQueueIndex = this.sampleStreamWrapper.bindSampleQueueToSampleStream(this.trackGroupIndex);
    }

    private boolean hasValidSampleQueueIndex() {
        return this.sampleQueueIndex != -3 && this.sampleQueueIndex != -2 && this.sampleQueueIndex != -1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.sampleQueueIndex == -3 || this.hasValidSampleQueueIndex() && this.sampleStreamWrapper.isReady(this.sampleQueueIndex);
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
        int v = this.sampleQueueIndex;
        switch(v) {
            case -3: {
                break;
            }
            case -2: {
                throw new SampleQueueMappingException(this.sampleStreamWrapper.getTrackGroups().get(this.trackGroupIndex).getFormat(0).sampleMimeType);
            }
            case -1: {
                this.sampleStreamWrapper.maybeThrowError();
                return;
            }
            default: {
                this.sampleStreamWrapper.maybeThrowError(v);
                break;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
        if(this.sampleQueueIndex == -3) {
            decoderInputBuffer0.addFlag(4);
            return -4;
        }
        return this.hasValidSampleQueueIndex() ? this.sampleStreamWrapper.readData(this.sampleQueueIndex, formatHolder0, decoderInputBuffer0, z) : -3;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long v) {
        return this.hasValidSampleQueueIndex() ? this.sampleStreamWrapper.skipData(this.sampleQueueIndex, v) : 0;
    }

    public void unbindSampleQueue() {
        if(this.sampleQueueIndex != -1) {
            this.sampleStreamWrapper.unbindSampleQueue(this.trackGroupIndex);
            this.sampleQueueIndex = -1;
        }
    }
}

