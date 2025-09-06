package com.iloen.melon.player.video;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.custom.H1;
import com.iloen.melon.custom.VideoOverlayView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\"\u0010\r\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"com/iloen/melon/player/video/VideoPlayerFragmentBase$setUpGestureView$2", "Lcom/iloen/melon/custom/H1;", "Lie/H;", "onLastSeekComplete", "()V", "onDoubleTabAnimationStart", "", "isShowProgress", "onDoubleTabAnimationEnd", "(Z)V", "onSimpleClick", "a", "Z", "isShowControllerResume", "()Z", "setShowControllerResume", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlayerFragmentBase.setUpGestureView.2 implements H1 {
    public boolean a;
    public final VideoPlayerFragmentBase b;
    public final VideoOverlayView c;

    public VideoPlayerFragmentBase.setUpGestureView.2(VideoPlayerFragmentBase videoPlayerFragmentBase0, VideoOverlayView videoOverlayView0) {
        this.b = videoPlayerFragmentBase0;
        this.c = videoOverlayView0;
    }

    public final boolean isShowControllerResume() {
        return this.a;
    }

    @Override  // com.iloen.melon.custom.H1
    public void onDoubleTabAnimationEnd(boolean z) {
        boolean z1 = ((Boolean)this.b.getVideoViewModel().getControllerAllVisible().getValue()).booleanValue();
        this.b.getVideoViewModel().updateControllerAllVisible(Boolean.valueOf(this.a || z1));
    }

    @Override  // com.iloen.melon.custom.H1
    public void onDoubleTabAnimationStart() {
        this.a = !this.b.getPlayerUseCase().n() && ((Boolean)this.b.getVideoViewModel().getControllerAllVisible().getValue()).booleanValue();
        this.b.getVideoViewModel().updateControllerAllVisible(Boolean.FALSE);
    }

    @Override  // com.iloen.melon.custom.H1
    public void onLastSeekComplete() {
    }

    @Override  // com.iloen.melon.custom.H1
    public void onSimpleClick() {
        if(!this.c.V) {
            VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.b;
            boolean z = ((Boolean)videoPlayerFragmentBase0.getVideoViewModel().getControllerAllVisible().getValue()).booleanValue();
            BottomSheetBehavior bottomSheetBehavior0 = VideoPlayerFragmentBase.access$getVideoListBehavior$p(videoPlayerFragmentBase0);
            if(bottomSheetBehavior0 != null && bottomSheetBehavior0.h0 == 3) {
                VideoPlayerFragmentBase.access$setVideoListBehaviorExpand(videoPlayerFragmentBase0, false);
                return;
            }
            videoPlayerFragmentBase0.getVideoViewModel().updateControllerAllVisible(Boolean.valueOf(!z));
        }
    }

    public final void setShowControllerResume(boolean z) {
        this.a = z;
    }
}

