package o3;

import H6.k;
import P0.c0;
import android.os.HandlerThread;

public final class b implements k {
    public final int a;
    public final int b;

    public b(int v, int v1) {
        this.a = v1;
        this.b = v;
        super();
    }

    @Override  // H6.k
    public final Object get() {
        return this.a == 0 ? new HandlerThread(c0.p(this.b, "ExoPlayer:MediaCodecAsyncAdapter:")) : new HandlerThread(c0.p(this.b, "ExoPlayer:MediaCodecQueueingThread:"));
    }
}

