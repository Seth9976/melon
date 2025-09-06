package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;

public final class e0 implements View.OnClickListener {
    public final int a;
    public final VideoMiniPlayer b;

    public e0(VideoMiniPlayer videoMiniPlayer0, int v) {
        this.a = v;
        this.b = videoMiniPlayer0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            VideoMiniPlayer.b(this.b);
            return;
        }
        VideoMiniPlayer.a(this.b);
    }
}

