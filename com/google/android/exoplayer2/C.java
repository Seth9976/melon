package com.google.android.exoplayer2;

public final class c implements ListenerInvocation {
    public final boolean a;

    public c(boolean z) {
        this.a = z;
    }

    @Override  // com.google.android.exoplayer2.BasePlayer$ListenerInvocation
    public final void invokeListener(EventListener player$EventListener0) {
        ExoPlayerImpl.lambda$setShuffleModeEnabled$2(this.a, player$EventListener0);
    }
}

