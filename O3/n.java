package o3;

import androidx.media3.common.b;

public final class n extends Exception {
    public final String a;
    public final boolean b;
    public final m c;
    public final String d;

    public n(b b0, s s0, boolean z, int v) {
        this("Decoder init failed: [" + v + "], " + b0, s0, b0.n, z, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (v >= 0 ? "" : "neg_") + Math.abs(v));
    }

    public n(String s, Throwable throwable0, String s1, boolean z, m m0, String s2) {
        super(s, throwable0);
        this.a = s1;
        this.b = z;
        this.c = m0;
        this.d = s2;
    }
}

