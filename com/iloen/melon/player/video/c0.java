package com.iloen.melon.player.video;

import android.content.res.Resources;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.b;
import we.k;

public final class c0 implements k {
    public final TiaraLogType a;
    public final VideoMiniPlayer b;
    public final boolean c;
    public final boolean d;

    public c0(TiaraLogType videoPlayerFragmentBase$TiaraLogType0, VideoMiniPlayer videoMiniPlayer0, boolean z, boolean z1) {
        this.a = videoPlayerFragmentBase$TiaraLogType0;
        this.b = videoMiniPlayer0;
        this.c = z;
        this.d = z1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        int v;
        q.g(((b)object0), "$this$common");
        ((b)object0).a = "영상플레이어";
        Resources resources0 = this.b.getContext().getResources();
        if(this.c) {
            v = 0x7F131032;  // string:tiara_video_player_page_live_preview "영상플레이어_LIVE예고"
        }
        else {
            v = this.d ? 0x7F131031 : 0x7F131034;  // string:tiara_video_player_page_live_onair "영상플레이어_LIVE"
        }
        ((b)object0).b = resources0.getString(v);
        if(this.a == TiaraLogType.PLAY_VIDEO) {
            ((b)object0).c = ActionKind.PlayVideo;
        }
        return H.a;
    }
}

