package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.DjPlayListInfoBase;

public final class z implements View.OnClickListener {
    public final int a;
    public final VideoInfoAdapter b;
    public final DjPlayListInfoBase c;
    public final int d;

    public z(VideoInfoAdapter videoInfoAdapter0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = videoInfoAdapter0;
        this.c = djPlayListInfoBase0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = this.b.b;
            if(videoInfoFragment$VideoInfoClickListener0 != null) {
                videoInfoFragment$VideoInfoClickListener0.onDjPlay(this.c, this.d);
            }
            return;
        }
        VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = this.b.b;
        if(videoInfoFragment$VideoInfoClickListener1 != null) {
            videoInfoFragment$VideoInfoClickListener1.onDjItem(this.c, this.d);
        }
    }
}

