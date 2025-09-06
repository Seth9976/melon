package j3;

import androidx.media3.common.b;

public final class j extends Exception {
    public final int a;
    public final boolean b;
    public final b c;

    public j(int v, b b0, boolean z) {
        super("AudioTrack write failed: " + v);
        this.b = z;
        this.a = v;
        this.c = b0;
    }
}

