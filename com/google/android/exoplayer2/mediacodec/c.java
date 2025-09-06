package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;

public final class c implements ScoreProvider {
    public final Format a;

    public c(Format format0) {
        this.a = format0;
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider
    public final int getScore(Object object0) {
        return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(this.a, ((MediaCodecInfo)object0));
    }
}

