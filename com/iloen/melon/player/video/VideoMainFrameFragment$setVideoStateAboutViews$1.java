package com.iloen.melon.player.video;

import androidx.constraintlayout.motion.widget.G;
import androidx.constraintlayout.motion.widget.MotionLayout;
import kotlin.Metadata;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\n\u0018\u00002\u00020\u0001J1\u0010\n\u001A\u00020\t2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ!\u0010\r\u001A\u00020\t2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\f\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u000F\u001A\u00020\t2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"com/iloen/melon/player/video/VideoMainFrameFragment$setVideoStateAboutViews$1", "Landroidx/constraintlayout/motion/widget/G;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "motionLayout", "", "startId", "endId", "", "progress", "Lie/H;", "onTransitionChange", "(Landroidx/constraintlayout/motion/widget/MotionLayout;IIF)V", "currentId", "onTransitionCompleted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;I)V", "onTransitionStarted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMainFrameFragment.setVideoStateAboutViews.1 extends G {
    public final VideoMainFrameFragment a;

    public VideoMainFrameFragment.setVideoStateAboutViews.1(VideoMainFrameFragment videoMainFrameFragment0) {
        this.a = videoMainFrameFragment0;
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public void onTransitionChange(MotionLayout motionLayout0, int v, int v1, float f) {
        VideoMainFrameFragment.access$getVideoViewModel(this.a).updateMotionProgress(new MotionProgress(v, v1, f));
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public void onTransitionCompleted(MotionLayout motionLayout0, int v) {
        VideoMainFrameFragment videoMainFrameFragment0 = this.a;
        VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateMotionProgress(new MotionProgress(0, 0, 0.0f, 7, null));
        Job job0 = VideoMainFrameFragment.access$getMotionEndingJob$p(videoMainFrameFragment0);
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateIsMotionPlaying(false);
        if(!VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isPipMode()) {
            VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateCurrentVideoStatus(VideoStatus.Companion.newInstance(v), "VideoMainframFragment - onTransitionCompleted");
        }
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public void onTransitionStarted(MotionLayout motionLayout0, int v, int v1) {
        VideoMainFrameFragment videoMainFrameFragment0 = this.a;
        VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateMotionProgress(new MotionProgress(0, 0, 0.0f, 7, null));
        Job job0 = VideoMainFrameFragment.access$getMotionEndingJob$p(videoMainFrameFragment0);
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateIsMotionPlaying(true);
        if(v == 0x7F0A0471 && v1 == 0x7F0A0808) {  // id:expand
            VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateControllerAllVisible(Boolean.FALSE);
        }
    }
}

