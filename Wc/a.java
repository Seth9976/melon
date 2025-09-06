package wc;

import Ic.I;
import Ic.K;
import Ic.Q;
import Ic.S;
import Ic.T;
import Ic.U;
import Ic.V;
import Ic.W;
import Ic.X;
import Ic.a0;
import Pc.e;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.kakao.tiara.data.ActionKind;
import k8.Y;
import kotlin.jvm.internal.q;
import p8.f;
import we.k;

public final class a implements k {
    public final int a;
    public final w b;
    public final e c;

    public a(w w0, e e0, int v) {
        this.a = v;
        this.b = w0;
        this.c = e0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        e e0 = this.c;
        w w0 = this.b;
        f f0 = (f)object0;
        switch(this.a) {
            case 0: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = w0.b.a(0x7F130DDF);  // string:tiara_common_layer1_album_spotlight_history "스포트라이트 히스토리"
                f0.C = ((V)e0).a.i;
                f0.e = ((V)e0).a.a;
                f0.f = w0.b.a(0x7F130EF3);  // string:tiara_meta_type_banner "배너"
                f0.g = ((V)e0).a.b;
                return f0;
            }
            case 1: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = w0.b.a(0x7F130DD7);  // string:tiara_common_layer1_album_hirising_history "하이라이징 히스토리"
                f0.C = ((I)e0).a.i;
                f0.e = ((I)e0).a.a;
                f0.f = w0.b.a(0x7F130EF3);  // string:tiara_meta_type_banner "배너"
                f0.g = ((I)e0).a.b;
                return f0;
            }
            case 2: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
                f0.d = ActionKind.PlayVideo;
                f0.y = w0.b.a(0x7F130DE1);  // string:tiara_common_layer1_album_video "이앨범의비디오"
                f0.c(((a0)e0).b + 1);
                f0.e = ((a0)e0).a.b;
                f0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
                f0.g = ((a0)e0).a.c;
                return f0;
            }
            case 3: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = w0.b.a(0x7F130DDA);  // string:tiara_common_layer1_album_magazine "이앨범의매거진"
                f0.c(((K)e0).b + 1);
                f0.e = ((K)e0).a.a == null ? "" : ((K)e0).a.a;
                f0.f = w0.b.a(0x7F130DFB);  // string:tiara_common_layer1_magazine "매거진"
                f0.g = ((K)e0).a.b;
                return f0;
            }
            case 4: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                f0.d = ActionKind.ClickContent;
                f0.y = w0.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.D = ((Q)e0).a.c;
                f0.c(((Q)e0).c + 1);
                f0.e = ((Q)e0).a.r;
                f0.f = w0.b.a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                f0.g = ((Q)e0).a.g;
                return f0;
            }
            case 5: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.E = ((U)e0).a.o;
                f0.y = w0.b.a(0x7F130E0F);  // string:tiara_common_layer1_song "곡"
                f0.c(((U)e0).b + 1);
                f0.e = w0.p();
                f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                f0.g = w0.q();
                return f0;
            }
            case 6: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = w0.b.a(0x7F130DE0);  // string:tiara_common_layer1_album_station "이앨범의스테이션"
                f0.c(((W)e0).c + 1);
                f0.e = ((W)e0).a;
                f0.f = w0.b.a(0x7F130E1A);  // string:tiara_common_layer1_station "스테이션"
                f0.g = ((W)e0).b;
                return f0;
            }
            case 7: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f0.d = ActionKind.PlayMusic;
                f0.y = w0.b.a(0x7F130DE0);  // string:tiara_common_layer1_album_station "이앨범의스테이션"
                f0.c(((X)e0).c + 1);
                f0.e = ((X)e0).a;
                f0.f = w0.b.a(0x7F130E1A);  // string:tiara_common_layer1_station "스테이션"
                f0.g = ((X)e0).b;
                return f0;
            }
            case 8: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f0.d = ActionKind.PlayMusic;
                f0.y = w0.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.D = ((T)e0).a.c;
                f0.c(((T)e0).b + 1);
                f0.e = ((T)e0).a.r;
                f0.f = w0.b.a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                f0.g = ((T)e0).a.g;
                return f0;
            }
            default: {
                q.g(f0, "$this$trackTiaraEventLog");
                f0.a = w0.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = w0.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.F = w0.b.a(0x7F130D56);  // string:tiara_click_copy_more_song "곡더보기"
                f0.D = ((S)e0).a.c;
                f0.c(((S)e0).b + 1);
                f0.e = ((S)e0).a.r;
                f0.f = w0.b.a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                f0.g = ((S)e0).a.g;
                return f0;
            }
        }
    }
}

