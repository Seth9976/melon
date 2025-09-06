package com.iloen.melon.player.playlist;

import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import q8.b;
import q8.h;
import we.k;

public final class l implements k {
    public final int a;
    public final PlaylistMainTiaraLogHelper b;

    public l(PlaylistMainTiaraLogHelper playlistMainTiaraLogHelper0, int v) {
        this.a = v;
        this.b = playlistMainTiaraLogHelper0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = this.b.a(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
                ((a)object0).g = this.b.a(0x7F130FF2);  // string:tiara_smartplaylist_copy_add "추가"
                return H.a;
            }
            case 1: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a = this.b.a(0x7F130E4C);  // string:tiara_common_section_dj_malrang_player "말랑이플레이어"
                ((b)object0).b = this.b.a(0x7F130E3D);  // string:tiara_common_page_dj_malrang_player "말랑이플레이어_재생화면"
                ((b)object0).c = ActionKind.ClickContent;
                return H.a;
            }
            case 2: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = this.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                return H.a;
            }
            case 3: {
                q.g(((b)object0), "$this$common");
                ((b)object0).a = this.b.a(0x7F130E53);  // string:tiara_common_section_music_player "곡플레이어"
                ((b)object0).b = this.b.a(0x7F130E44);  // string:tiara_common_page_music_player "곡플레이어_재생화면"
                ((b)object0).c = ActionKind.ClickContent;
                return H.a;
            }
            case 4: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = this.b.a(0x7F130F9F);  // string:tiara_playlist_controller_layer1 "재생목록패널"
                return H.a;
            }
            case 5: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = this.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                return H.a;
            }
            case 6: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = this.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                return H.a;
            }
            case 7: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = this.b.a(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
                ((a)object0).g = this.b.a(0x7F130FAA);  // string:tiara_playlist_tab_copy_search "검색"
                return H.a;
            }
            case 8: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = this.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                return H.a;
            }
            default: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = this.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                return H.a;
            }
        }
    }
}

