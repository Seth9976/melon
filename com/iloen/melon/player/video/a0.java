package com.iloen.melon.player.video;

import android.view.View.OnLayoutChangeListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.iloen.melon.MusicBrowserActivity;

public final class a0 implements View.OnLayoutChangeListener {
    public final VideoMainFrameFragment a;

    public a0(VideoMainFrameFragment videoMainFrameFragment0) {
        this.a = videoMainFrameFragment0;
    }

    @Override  // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        VideoMainFrameFragment videoMainFrameFragment0 = this.a;
        if(!videoMainFrameFragment0.o().isPipMode()) {
            FragmentActivity fragmentActivity0 = videoMainFrameFragment0.getActivity();
            MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
            if(musicBrowserActivity0 == null || !musicBrowserActivity0.isTabAndMiniPlayerVisibilityAnimationPlaying()) {
                videoMainFrameFragment0.o().updateScreenHeight(v3 - v1);
                ((LiveViewModel)videoMainFrameFragment0.h.getValue()).setLiveBottomSheetMaxWidthForSeparated(videoMainFrameFragment0.getBinding().m.getWidth());
            }
        }
    }
}

