package com.facebook;

public final class h implements Runnable {
    public final Callback a;
    public final long b;
    public final long c;

    public h(OnProgressCallback graphRequest$OnProgressCallback0, long v, long v1) {
        this.a = graphRequest$OnProgressCallback0;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final void run() {
        RequestProgress.reportProgress$lambda$0(this.a, this.b, this.c);
    }
}

