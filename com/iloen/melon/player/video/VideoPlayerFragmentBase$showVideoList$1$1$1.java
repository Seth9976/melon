package com.iloen.melon.player.video;

import android.view.View;
import com.iloen.melon.custom.ControllerVideoListView;
import com.iloen.melon.utils.log.LogU;
import i6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"com/iloen/melon/player/video/VideoPlayerFragmentBase$showVideoList$1$1$1", "Li6/a;", "Landroid/view/View;", "bottomSheet", "", "newState", "Lie/H;", "onStateChanged", "(Landroid/view/View;I)V", "", "slideOffset", "onSlide", "(Landroid/view/View;F)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlayerFragmentBase.showVideoList.1.1.1 extends a {
    public final ControllerVideoListView a;
    public final VideoPlayerFragmentBase b;

    public VideoPlayerFragmentBase.showVideoList.1.1.1(ControllerVideoListView controllerVideoListView0, VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        this.a = controllerVideoListView0;
        this.b = videoPlayerFragmentBase0;
    }

    @Override  // i6.a
    public void onSlide(View view0, float f) {
        q.g(view0, "bottomSheet");
        LogU.debug$default(this.b.getLog(), "onSlide = " + f, null, false, 6, null);
    }

    @Override  // i6.a
    public void onStateChanged(View view0, int v) {
        q.g(view0, "bottomSheet");
        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.b;
        ControllerVideoListView controllerVideoListView0 = this.a;
        switch(v) {
            case 1: {
                controllerVideoListView0.b(false);
                videoPlayerFragmentBase0.getVideoViewModel().updateVideoListDraggingOrExpanded(true);
                return;
            }
            case 3: {
                controllerVideoListView0.setEnableScroll(true);
                controllerVideoListView0.b(true);
                videoPlayerFragmentBase0.getVideoViewModel().updateVideoListDraggingOrExpanded(true);
                VideoPlayerFragmentBase.access$updateControllerVisibleWithFadeOut(videoPlayerFragmentBase0, false);
                VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this.b, 0x7F130D6F, null, false, 6, null);  // string:tiara_click_copy_player_curationvideo "추천영상"
                return;
            }
            case 4: {
                controllerVideoListView0.setEnableScroll(false);
                videoPlayerFragmentBase0.getVideoViewModel().updateVideoListDraggingOrExpanded(false);
                VideoPlayerFragmentBase.access$updateControllerVisibleWithFadeOut(videoPlayerFragmentBase0, true);
                controllerVideoListView0.b(false);
            }
        }
    }
}

