package m9;

import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import we.k;

public final class j implements k {
    public final int a;
    public final MixUpPlaylistTiaraLogHelper b;
    public final String c;

    public j(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, String s, int v) {
        this.a = v;
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.c = s;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        a a0 = (a)object0;
        switch(this.a) {
            case 0: {
                q.g(a0, "$this$click");
                a0.a = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                a0.g = this.b.a(0x7F130D92);  // string:tiara_click_copy_select "선택"
                a0.e = this.c;
                return H.a;
            }
            case 1: {
                q.g(a0, "$this$click");
                a0.a = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                a0.g = this.b.a(0x7F130D92);  // string:tiara_click_copy_select "선택"
                a0.e = this.c;
                return H.a;
            }
            case 2: {
                q.g(a0, "$this$click");
                a0.a = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                a0.g = this.b.a(0x7F130FA3);  // string:tiara_playlist_move_my_order "순서변경"
                a0.e = this.c;
                return H.a;
            }
            case 3: {
                q.g(a0, "$this$click");
                a0.a = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                a0.g = this.b.a(0x7F130D92);  // string:tiara_click_copy_select "선택"
                a0.e = this.c;
                return H.a;
            }
            case 4: {
                q.g(a0, "$this$click");
                a0.a = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                a0.g = this.b.a(0x7F130DAF);  // string:tiara_click_copy_unselect "선택취소"
                a0.e = this.c;
                return H.a;
            }
            default: {
                q.g(a0, "$this$click");
                a0.a = this.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                a0.g = this.b.a(0x7F130D54);  // string:tiara_click_copy_more "더보기"
                a0.e = this.c;
                return H.a;
            }
        }
    }
}

