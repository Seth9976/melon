package com.google.android.exoplayer2;

public final class b implements ListenerInvocation {
    public final int a;
    public final PlaybackParameters b;

    public b(PlaybackParameters playbackParameters0, int v) {
        this.a = v;
        this.b = playbackParameters0;
        super();
    }

    @Override  // com.google.android.exoplayer2.BasePlayer$ListenerInvocation
    public final void invokeListener(EventListener player$EventListener0) {
        if(this.a != 0) {
            ExoPlayerImpl.lambda$setPlaybackParameters$4(this.b, player$EventListener0);
            return;
        }
        ExoPlayerImpl.lambda$handlePlaybackParameters$5(this.b, player$EventListener0);
    }
}

