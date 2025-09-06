package i.n.i.b.a.s.e;

public final class ma extends Exception {
    public final String a;
    public final boolean b;
    public final K9 c;
    public final String d;

    public ma(u u0, yb yb0, boolean z, int v) {
        this("Decoder init failed: [" + v + "], " + u0, yb0, u0.l, z, null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (v >= 0 ? "" : "neg_") + Math.abs(v));
    }

    public ma(String s, Throwable throwable0, String s1, boolean z, K9 k90, String s2) {
        super(s, throwable0);
        this.a = s1;
        this.b = z;
        this.c = k90;
        this.d = s2;
    }
}

