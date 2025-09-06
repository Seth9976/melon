package com.iloen.melon.player.video;

import Bd.F;
import androidx.compose.runtime.b0;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.net.v6x.common.LiveInfoBase.CARD;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.melon.net.res.common.LinkInfoBase;
import e1.m;
import ie.H;
import we.a;

public final class k implements a {
    public final int a;
    public final Object b;
    public final Object c;

    public k(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment1;
        LinkInfoBase linkInfoBase0;
        H h0 = H.a;
        String s = null;
        Object object0 = this.c;
        Object object1 = this.b;
        if(this.a != 0) {
            LiveDetailRes liveDetailRes0 = (LiveDetailRes)((b0)object1).getValue();
            if(liveDetailRes0 == null) {
                linkInfoBase0 = null;
            }
            else {
                Response liveDetailRes$Response0 = liveDetailRes0.response;
                if(liveDetailRes$Response0 == null) {
                    linkInfoBase0 = null;
                }
                else {
                    Live liveDetailRes$Response$Live0 = liveDetailRes$Response0.live;
                    if(liveDetailRes$Response$Live0 == null) {
                        linkInfoBase0 = null;
                    }
                    else {
                        CARD liveInfoBase$CARD0 = liveDetailRes$Response$Live0.card;
                        linkInfoBase0 = liveInfoBase$CARD0 == null ? null : liveInfoBase$CARD0.button;
                    }
                }
            }
            MelonLinkExecutor.open(MelonLinkInfo.b(linkInfoBase0));
            if(linkInfoBase0 != null) {
                s = linkInfoBase0.text;
            }
            m.F(new F(((VideoLivePreviewFragment)object0), s, linkInfoBase0, ((Playable)((VideoLivePreviewFragment)object0).L().getCurrentVideoPlayable().getValue()), 10)).track();
            return h0;
        }
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = ((VideoChatFragment)object1).a;
        if(videoSongListBottomSheetFragment0 != null) {
            videoSongListBottomSheetFragment0.dismiss();
        }
        if(((RESPONSE)object0) == null) {
            videoSongListBottomSheetFragment1 = null;
        }
        else {
            videoSongListBottomSheetFragment1 = new VideoSongListBottomSheetFragment(((VideoChatFragment)object1).f0(), ((RESPONSE)object0));
            videoSongListBottomSheetFragment1.setParentFragment(((VideoChatFragment)object1));
        }
        FragmentActivity fragmentActivity0 = ((VideoChatFragment)object1).getActivity();
        if(fragmentActivity0 != null) {
            l0 l00 = fragmentActivity0.getSupportFragmentManager();
            if(l00 != null) {
                if(videoSongListBottomSheetFragment1 != null) {
                    videoSongListBottomSheetFragment1.show(l00, "VideoSongListBottomSheetFragment");
                }
                ((VideoChatFragment)object1).a = videoSongListBottomSheetFragment1;
            }
        }
        SONG liveTimedMetaSongRes$SONG0 = ((RESPONSE)object0) == null ? null : VideoChatFragment.g0(((RESPONSE)object0));
        String s1 = liveTimedMetaSongRes$SONG0 == null ? null : liveTimedMetaSongRes$SONG0.songId;
        String s2 = liveTimedMetaSongRes$SONG0 == null ? null : ((VideoChatFragment)object1).getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        if(liveTimedMetaSongRes$SONG0 != null) {
            s = liveTimedMetaSongRes$SONG0.songName;
        }
        VideoChatFragment.j0(((VideoChatFragment)object1), null, null, s1, s2, s, null, 35);
        return h0;
    }
}

