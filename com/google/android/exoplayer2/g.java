package com.google.android.exoplayer2;

public final class g implements ListenerInvocation {
    public final int a;

    public g(int v) {
        this.a = v;
        super();
    }

    @Override  // com.google.android.exoplayer2.BasePlayer$ListenerInvocation
    public final void invokeListener(EventListener player$EventListener0) {
        if(this.a != 0) {
            player$EventListener0.onSeekProcessed();
            return;
        }
        ExoPlayerImpl.lambda$seekTo$3(player$EventListener0);
    }
}

