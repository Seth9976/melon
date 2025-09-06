package com.google.android.exoplayer2.mediacodec;

import java.util.Comparator;

public final class a implements Comparator {
    public final ScoreProvider a;

    public a(ScoreProvider mediaCodecUtil$ScoreProvider0) {
        this.a = mediaCodecUtil$ScoreProvider0;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return MediaCodecUtil.lambda$sortByScore$3(this.a, object0, object1);
    }
}

