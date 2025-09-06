package com.iloen.melon.player.video;

import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.b;
import q8.h;
import we.k;

public final class g0 implements k {
    public final int a;
    public final TiaraLogType b;
    public final VideoPlayerFragmentBase c;

    public g0(TiaraLogType videoPlayerFragmentBase$TiaraLogType0, VideoPlayerFragmentBase videoPlayerFragmentBase0) {
        this.a = 1;
        super();
        this.b = videoPlayerFragmentBase$TiaraLogType0;
        this.c = videoPlayerFragmentBase0;
    }

    public g0(VideoPlayerFragmentBase videoPlayerFragmentBase0, TiaraLogType videoPlayerFragmentBase$TiaraLogType0) {
        this.a = 0;
        super();
        this.c = videoPlayerFragmentBase0;
        this.b = videoPlayerFragmentBase$TiaraLogType0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.c;
        TiaraLogType videoPlayerFragmentBase$TiaraLogType0 = this.b;
        if(this.a != 0) {
            q.g(((b)object0), "$this$common");
            ((b)object0).a = videoPlayerFragmentBase0.getString(0x7F131035);  // string:tiara_video_player_section "영상플레이어"
            ((b)object0).b = VideoPlayerFragmentBase.e0(videoPlayerFragmentBase0);
            if(videoPlayerFragmentBase$TiaraLogType0 == TiaraLogType.PLAY_VIDEO) {
                ((b)object0).c = ActionKind.PlayVideo;
            }
            return h0;
        }
        q.g(((h)object0), "$this$track");
        String s = videoPlayerFragmentBase0.getString((videoPlayerFragmentBase$TiaraLogType0 == TiaraLogType.PLAY_VIDEO ? 0x7F130DCC : 0x7F130DC9));  // string:tiara_common_action_name_play_video "영상재생"
        if(s == null) {
            s = "";
        }
        ((h)object0).a = s;
        return h0;
    }
}

