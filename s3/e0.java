package s3;

import ea.c;
import h3.e;

public final class e0 implements V {
    public final V a;
    public final long b;

    public e0(V v0, long v1) {
        this.a = v0;
        this.b = v1;
    }

    @Override  // s3.V
    public final int b(c c0, e e0, int v) {
        int v1 = this.a.b(c0, e0, v);
        if(v1 == -4) {
            e0.g += this.b;
        }
        return v1;
    }

    @Override  // s3.V
    public final boolean isReady() {
        return this.a.isReady();
    }

    @Override  // s3.V
    public final void maybeThrowError() {
        this.a.maybeThrowError();
    }

    @Override  // s3.V
    public final int skipData(long v) {
        return this.a.skipData(v - this.b);
    }
}

