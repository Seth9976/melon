package o3;

import android.media.LoudnessCodecController.OnLoudnessCodecUpdateListener;
import android.media.MediaCodec;
import android.os.Bundle;
import d5.m;

public final class g implements LoudnessCodecController.OnLoudnessCodecUpdateListener {
    public final m a;

    public g(m m0) {
        this.a = m0;
    }

    @Override  // android.media.LoudnessCodecController$OnLoudnessCodecUpdateListener
    public final Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec0, Bundle bundle0) {
        ((h)this.a.c).getClass();
        return bundle0;
    }
}

