package com.iloen.melon.player.playlist;

import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.b;
import q8.c;
import q8.h;
import we.k;

public final class p implements k {
    public final int a;
    public final VideoPlaylistFragment b;

    public p(VideoPlaylistFragment videoPlaylistFragment0, int v) {
        this.a = v;
        this.b = videoPlaylistFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        VideoPlaylistFragment videoPlaylistFragment0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a.put("menuid", "1000002969");
                Object object1 = new o(videoPlaylistFragment0, 1).invoke();
                ((c)object0).a.put("Player Type", object1);
                return h0;
            }
            case 1: {
                q.g(((h)object0), "$this$track");
                String s = videoPlaylistFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                if(s == null) {
                    s = "";
                }
                ((h)object0).a = s;
                return h0;
            }
            default: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a = videoPlaylistFragment0.getString(0x7F131035);  // string:tiara_video_player_section "영상플레이어"
                ((b)object0).b = videoPlaylistFragment0.getString(0x7F131033);  // string:tiara_video_player_page_playlist "영상플레이어_비디오재생목록"
                ((b)object0).c = ActionKind.ClickContent;
                return h0;
            }
        }
    }
}

