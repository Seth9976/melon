package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long v, long v1, MpegAudioHeader mpegAudioHeader0) {
        super(v, v1, mpegAudioHeader0.bitrate, mpegAudioHeader0.frameSize);
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override  // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long v) {
        return this.getTimeUsAtPosition(v);
    }
}

