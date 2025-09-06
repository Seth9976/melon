package com.google.android.exoplayer2.ui;

public final class b implements Runnable {
    public final int a;
    public final PlayerControlView b;

    public b(PlayerControlView playerControlView0, int v) {
        this.a = v;
        this.b = playerControlView0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.hide();
            return;
        }
        this.b.updateProgress();
    }
}

