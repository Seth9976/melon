package com.google.android.exoplayer2;

public final class e implements ListenerInvocation {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;

    public e(boolean z, boolean z1, int v, boolean z2, int v1, boolean z3, boolean z4) {
        this.a = z;
        this.b = z1;
        this.c = v;
        this.d = z2;
        this.e = v1;
        this.f = z3;
        this.g = z4;
    }

    @Override  // com.google.android.exoplayer2.BasePlayer$ListenerInvocation
    public final void invokeListener(EventListener player$EventListener0) {
        ExoPlayerImpl.lambda$setPlayWhenReady$0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, player$EventListener0);
    }
}

