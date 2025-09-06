package s3;

import I6.V;
import androidx.media3.exoplayer.K;
import java.util.List;

public final class l implements X {
    public final X a;
    public final V b;

    public l(X x0, List list0) {
        this.a = x0;
        this.b = V.p(list0);
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        return this.a.b(k0);
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        return this.a.getBufferedPositionUs();
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        return this.a.getNextLoadPositionUs();
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.a.isLoading();
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        this.a.reevaluateBuffer(v);
    }
}

