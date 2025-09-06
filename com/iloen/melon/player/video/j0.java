package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.q;

public final class j0 implements View.OnClickListener {
    public final int a;
    public final VideoPlayerFragmentBase b;

    public j0(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v) {
        this.a = v;
        this.b = videoPlayerFragmentBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                int v = this.b.getVideoViewModel().isFullScreen() ? 0x7F130D75 : 0x7F130D70;  // string:tiara_click_copy_player_normalscreen "축소"
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this.b, v, null, false, 6, null);
                this.b.getVideoViewModel().toggleFullScreenMode();
                this.b.getVideoViewModel().updateControllerAllVisible(Boolean.TRUE);
                q.e(view0, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView)view0).setImageResource((this.b.getVideoViewModel().isFullScreen() ? 0x7F08022F : 0x7F08022E));  // drawable:btn_player_fullscreen_exit
                return;
            }
            case 1: {
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this.b, 0x7F130D72, null, false, 6, null);  // string:tiara_click_copy_player_minimize "최소화"
                this.b.getVideoViewModel().updateCurrentVideoStatus(VideoStatus.MiniMode, "VideoPlayerFramentBase - close click()");
                return;
            }
            case 2: {
                this.b.getVideoViewModel().updateCurrentVideoStatus(VideoStatus.Expand, "VideoPlayerFragmentBase - mini onClick");
                return;
            }
            default: {
                this.b.performMoreClick();
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this.b, 0x7F130D73, null, false, 6, null);  // string:tiara_click_copy_player_more "더보기"
            }
        }
    }
}

