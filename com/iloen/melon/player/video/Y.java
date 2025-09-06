package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class y implements View.OnClickListener {
    public final int a;
    public final VideoInfoAdapter b;
    public final SongInfoBase c;
    public final int d;

    public y(VideoInfoAdapter videoInfoAdapter0, SongInfoBase songInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = videoInfoAdapter0;
        this.c = songInfoBase0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = this.b.b;
                if(videoInfoFragment$VideoInfoClickListener1 != null) {
                    videoInfoFragment$VideoInfoClickListener1.onSongAlbum((this.c.albumId == null ? "" : this.c.albumId), this.d);
                }
                return;
            }
            case 1: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener2 = this.b.b;
                if(videoInfoFragment$VideoInfoClickListener2 != null) {
                    videoInfoFragment$VideoInfoClickListener2.onSongPlay(this.c, this.d);
                }
                return;
            }
            default: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = this.b.b;
                if(videoInfoFragment$VideoInfoClickListener0 != null) {
                    videoInfoFragment$VideoInfoClickListener0.onSongInfo(this.c, this.d);
                }
            }
        }
    }
}

