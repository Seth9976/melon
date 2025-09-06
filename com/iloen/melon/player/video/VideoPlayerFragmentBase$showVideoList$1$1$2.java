package com.iloen.melon.player.video;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.custom.q;
import com.melon.net.res.common.MvInfoBase;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"com/iloen/melon/player/video/VideoPlayerFragmentBase$showVideoList$1$1$2", "Lcom/iloen/melon/custom/q;", "Lcom/melon/net/res/common/MvInfoBase;", "mvInfo", "", "position", "Lie/H;", "onPlay", "(Lcom/melon/net/res/common/MvInfoBase;I)V", "doCollapse", "()V", "", "isScrolling", "onScrolling", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlayerFragmentBase.showVideoList.1.1.2 implements q {
    public final VideoPlayerFragmentBase a;

    public VideoPlayerFragmentBase.showVideoList.1.1.2(VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        this.a = videoPlayerFragmentBase0;
    }

    @Override  // com.iloen.melon.custom.q
    public void doCollapse() {
        VideoPlayerFragmentBase.access$setVideoListBehaviorExpand(this.a, false);
    }

    @Override  // com.iloen.melon.custom.q
    public void onPlay(MvInfoBase mvInfoBase0, int v) {
        kotlin.jvm.internal.q.g(mvInfoBase0, "mvInfo");
        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.a;
        BottomSheetBehavior bottomSheetBehavior0 = VideoPlayerFragmentBase.access$getVideoListBehavior$p(videoPlayerFragmentBase0);
        if(bottomSheetBehavior0 != null && bottomSheetBehavior0.h0 == 4) {
            return;
        }
        String s = mvInfoBase0.mvId;
        String s1 = "";
        if(s == null) {
            s = "";
        }
        String s2 = mvInfoBase0.mvName;
        if(s2 != null) {
            s1 = s2;
        }
        VideoPlayerFragmentBase.access$sendTiaraLogCurationVideo(videoPlayerFragmentBase0, v, s, s1);
        videoPlayerFragmentBase0.playMvById(mvInfoBase0.mvId, "1000000550", true, false);
        VideoPlayerFragmentBase.access$setVideoListBehaviorExpand(videoPlayerFragmentBase0, false);
    }

    @Override  // com.iloen.melon.custom.q
    public void onScrolling(boolean z) {
    }
}

