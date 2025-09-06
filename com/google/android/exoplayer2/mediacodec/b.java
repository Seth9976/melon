package com.google.android.exoplayer2.mediacodec;

public final class b implements ScoreProvider {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider
    public final int getScore(Object object0) {
        return this.a == 0 ? MediaCodecUtil.lambda$applyWorkarounds$1(((MediaCodecInfo)object0)) : MediaCodecUtil.lambda$applyWorkarounds$2(((MediaCodecInfo)object0));
    }
}

