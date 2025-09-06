package com.iloen.melon.player.video;

import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.b;
import q8.c;
import q8.h;
import u8.d;
import we.k;

public final class i0 implements k {
    public final int a;
    public final VideoPlayerFragmentBase b;

    public i0(VideoPlayerFragmentBase videoPlayerFragmentBase0, int v) {
        this.a = v;
        this.b = videoPlayerFragmentBase0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        VideoPlayerFragmentBase videoPlayerFragmentBase0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((h)object0), "$this$track");
                String s = videoPlayerFragmentBase0.getString(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
                if(s == null) {
                    s = "";
                }
                ((h)object0).a = s;
                return h0;
            }
            case 1: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a = videoPlayerFragmentBase0.getString(0x7F131035);  // string:tiara_video_player_section "영상플레이어"
                ((b)object0).b = VideoPlayerFragmentBase.f0(videoPlayerFragmentBase0);
                ((b)object0).c = ActionKind.PlayVideo;
                return h0;
            }
            case 2: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a(new k0(videoPlayerFragmentBase0, 0));
                String s1 = videoPlayerFragmentBase0.getVideoViewModel().getPlayerType();
                ((c)object0).a.put("Player Type", s1);
                return h0;
            }
            default: {
                d d0 = (d)object0;
                videoPlayerFragmentBase0.dismissProgressDialog();
                videoPlayerFragmentBase0.showMoreBottomSheet();
                return h0;
            }
        }
    }
}

