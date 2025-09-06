package Nb;

import com.kakao.tiara.data.ActionKind;
import com.melon.playback.MelonIntentService;
import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import q8.b;
import we.k;

public final class h implements k {
    public final int a;
    public final boolean b;
    public final MelonIntentService c;

    public h(MelonIntentService melonIntentService0, boolean z, int v) {
        this.a = v;
        this.c = melonIntentService0;
        this.b = z;
        super();
    }

    public h(boolean z, MelonIntentService melonIntentService0, int v) {
        this.a = v;
        this.b = z;
        this.c = melonIntentService0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s = "";
        int v = 0x7F130DCB;  // string:tiara_common_action_name_play_music "음악재생"
        H h0 = H.a;
        MelonIntentService melonIntentService0 = this.c;
        boolean z = this.b;
        switch(this.a) {
            case 0: {
                q.g(((q8.h)object0), "$this$track");
                if(z) {
                    v = 0x7F130DC9;  // string:tiara_common_action_name_move_page "페이지이동"
                }
                String s1 = melonIntentService0.getString(v);
                if(s1 != null) {
                    s = s1;
                }
                ((q8.h)object0).a = s;
                return h0;
            }
            case 1: {
                q.g(((b)object0), "$this$common");
                ((b)object0).c = z ? ActionKind.ClickContent : ActionKind.PlayMusic;
                ((b)object0).a = "위젯";
                ((b)object0).b = "위젯_aos_z플립위젯";
                return h0;
            }
            case 2: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = "플레이어";
                ((a)object0).g = melonIntentService0.getString((z ? 0x7F130D76 : 0x7F130D1C));  // string:tiara_click_copy_player_pause "멈춤"
                return h0;
            }
            case 3: {
                q.g(((q8.h)object0), "$this$track");
                if(z) {
                    v = 0x7F130DC9;  // string:tiara_common_action_name_move_page "페이지이동"
                }
                String s2 = melonIntentService0.getString(v);
                if(s2 != null) {
                    s = s2;
                }
                ((q8.h)object0).a = s;
                return h0;
            }
            default: {
                q.g(((b)object0), "$this$common");
                ((b)object0).c = z ? ActionKind.ClickContent : ActionKind.PlayMusic;
                ((b)object0).a = "위젯";
                ((b)object0).b = "위젯_aos_바탕화면위젯";
                return h0;
            }
        }
    }
}

