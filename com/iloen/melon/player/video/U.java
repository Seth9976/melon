package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;

public final class u implements View.OnClickListener {
    public final int a;
    public final VideoInfoAdapter b;
    public final Playable c;

    public u(VideoInfoAdapter videoInfoAdapter0, Playable playable0, int v) {
        this.a = v;
        this.b = videoInfoAdapter0;
        this.c = playable0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = this.b.b;
            if(videoInfoFragment$VideoInfoClickListener0 != null) {
                videoInfoFragment$VideoInfoClickListener0.onInfoShare(this.c);
            }
            return;
        }
        VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = this.b.b;
        if(videoInfoFragment$VideoInfoClickListener1 != null) {
            videoInfoFragment$VideoInfoClickListener1.onInfoDownload(this.c);
        }
    }
}

