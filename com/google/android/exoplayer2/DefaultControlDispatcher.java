package com.google.android.exoplayer2;

public class DefaultControlDispatcher implements ControlDispatcher {
    @Override  // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(Player player0, int v, long v1) {
        player0.seekTo(v, v1);
        return true;
    }

    @Override  // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(Player player0, boolean z) {
        player0.setPlayWhenReady(z);
        return true;
    }

    @Override  // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(Player player0, int v) {
        player0.setRepeatMode(v);
        return true;
    }

    @Override  // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(Player player0, boolean z) {
        player0.setShuffleModeEnabled(z);
        return true;
    }

    @Override  // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchStop(Player player0, boolean z) {
        player0.stop(z);
        return true;
    }
}

