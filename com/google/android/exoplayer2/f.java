package com.google.android.exoplayer2;

public final class f implements ListenerInvocation {
    public final int a;

    public f(int v) {
        this.a = v;
    }

    @Override  // com.google.android.exoplayer2.BasePlayer$ListenerInvocation
    public final void invokeListener(EventListener player$EventListener0) {
        ExoPlayerImpl.lambda$setRepeatMode$1(this.a, player$EventListener0);
    }
}

