package com.iloen.melon.player.video;

import J8.w3;
import androidx.fragment.app.I;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.player.playlist.VideoPlaylistFragment;
import com.iloen.melon.utils.system.ScreenUtils;

public final class q implements Runnable {
    public final int a;
    public final I b;

    public q(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                VideoChatFragment videoChatFragment0 = (VideoChatFragment)this.b;
                w3 w30 = videoChatFragment0.f;
                if(w30 != null) {
                    int v = videoChatFragment0.getAdapter().getItemCount();
                    w30.o.scrollToPosition(v - 1);
                }
                return;
            }
            case 1: {
                VideoPlaylistFragment videoPlaylistFragment0 = VideoPlaylistFragment.Companion.newInstance();
                ((VideoMainFrameFragment)this.b).addFragment(videoPlaylistFragment0);
                return;
            }
            default: {
                VideoPlayerFragmentBase videoPlayerFragmentBase0 = (VideoPlayerFragmentBase)this.b;
                BottomSheetBehavior bottomSheetBehavior0 = videoPlayerFragmentBase0.l;
                if(bottomSheetBehavior0 != null) {
                    bottomSheetBehavior0.L((((Boolean)videoPlayerFragmentBase0.getVideoViewModel().isOrientationPortrait().getValue()).booleanValue() ? ScreenUtils.dipToPixel(videoPlayerFragmentBase0.getContext(), 72.0f) : ScreenUtils.dipToPixel(videoPlayerFragmentBase0.getContext(), 48.0f)));
                }
            }
        }
    }
}

