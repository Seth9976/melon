package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.exoplayer2.SimpleExoPlayer;

@Deprecated
public final class SimpleExoPlayerView extends PlayerView {
    public SimpleExoPlayerView(Context context0) {
        super(context0);
    }

    public SimpleExoPlayerView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public SimpleExoPlayerView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Deprecated
    public static void switchTargetView(SimpleExoPlayer simpleExoPlayer0, SimpleExoPlayerView simpleExoPlayerView0, SimpleExoPlayerView simpleExoPlayerView1) {
        PlayerView.switchTargetView(simpleExoPlayer0, simpleExoPlayerView0, simpleExoPlayerView1);
    }
}

