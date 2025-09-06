package com.google.android.exoplayer2;

public final class h implements ListenerInvocation {
    public final int a;
    public final PlaybackInfoUpdate b;

    public h(PlaybackInfoUpdate exoPlayerImpl$PlaybackInfoUpdate0, int v) {
        this.a = v;
        this.b = exoPlayerImpl$PlaybackInfoUpdate0;
        super();
    }

    @Override  // com.google.android.exoplayer2.BasePlayer$ListenerInvocation
    public final void invokeListener(EventListener player$EventListener0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$run$0(player$EventListener0);
                return;
            }
            case 1: {
                this.b.lambda$run$1(player$EventListener0);
                return;
            }
            case 2: {
                this.b.lambda$run$2(player$EventListener0);
                return;
            }
            case 3: {
                this.b.lambda$run$3(player$EventListener0);
                return;
            }
            case 4: {
                this.b.lambda$run$4(player$EventListener0);
                return;
            }
            case 5: {
                this.b.lambda$run$5(player$EventListener0);
                return;
            }
            default: {
                this.b.lambda$run$6(player$EventListener0);
            }
        }
    }
}

