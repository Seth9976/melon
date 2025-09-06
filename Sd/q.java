package sd;

import P0.d0;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import q8.b;
import we.k;

public final class q implements k {
    public final int a;
    public final ActionKind b;
    public final d0 c;

    public q(ActionKind actionKind0, d0 d00, int v) {
        this.a = v;
        this.b = actionKind0;
        this.c = d00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                kotlin.jvm.internal.q.g(((b)object0), "$this$common");
                ((b)object0).a = this.c.d(0x7F130E54);  // string:tiara_common_section_music_wave "뮤직웨이브"
                ((b)object0).b = this.c.d(0x7F130E48);  // string:tiara_common_page_music_wave_mini_player "뮤직웨이브_미니플레이어"
                ActionKind actionKind1 = this.b;
                if(actionKind1 != null) {
                    ((b)object0).c = actionKind1;
                }
                return H.a;
            }
            case 1: {
                kotlin.jvm.internal.q.g(((b)object0), "$this$common");
                ((b)object0).a = this.c.d(0x7F130E4C);  // string:tiara_common_section_dj_malrang_player "말랑이플레이어"
                ((b)object0).b = this.c.d(0x7F130E3D);  // string:tiara_common_page_dj_malrang_player "말랑이플레이어_재생화면"
                ActionKind actionKind2 = this.b;
                if(actionKind2 != null) {
                    ((b)object0).c = actionKind2;
                }
                return H.a;
            }
            default: {
                kotlin.jvm.internal.q.g(((b)object0), "$this$common");
                ((b)object0).a = this.c.d(0x7F130E53);  // string:tiara_common_section_music_player "곡플레이어"
                ((b)object0).b = this.c.d(0x7F130E44);  // string:tiara_common_page_music_player "곡플레이어_재생화면"
                ActionKind actionKind0 = this.b;
                if(actionKind0 != null) {
                    ((b)object0).c = actionKind0;
                }
                return H.a;
            }
        }
    }
}

