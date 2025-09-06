package Bc;

import androidx.fragment.app.l0;
import com.iloen.melon.player.playlist.k;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.popup.b;
import d5.n;
import hc.l;
import ie.H;
import ie.m;
import kc.d3;
import kc.s2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import oe.c;
import pb.r;
import va.e;
import we.a;

public final class h {
    public final StringProviderImpl a;
    public final l b;

    public h(StringProviderImpl stringProviderImpl0, l l0) {
        this.a = stringProviderImpl0;
        this.b = l0;
        new LogU("PlayerUiHelper");
    }

    public final String a(String s) {
        return e.c(this.a.a(0x7F130AD2), " ", s);  // string:talkback_artist "아티스트"
    }

    public final m b(String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        String s1 = this.b.a();
        StringProviderImpl stringProviderImpl0 = this.a;
        if(s1.length() > 0) {
            stringBuilder0.append(stringProviderImpl0.a(0x7F130C1F));  // string:talkback_remote_connected "외부기기 연결됨"
            stringBuilder0.append(" ");
            stringBuilder0.append(s1);
            return new m(s1, stringBuilder0);
        }
        if(s != null && s.length() != 0) {
            stringBuilder0.append(this.a(s));
            return new m(s, stringBuilder0);
        }
        s = stringProviderImpl0.a(0x7F1310D6);  // string:unknown_artist_name "알 수 없는 아티스트"
        stringBuilder0.append(s);
        return new m(s, stringBuilder0);
    }

    public final m c(String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(s != null && s.length() != 0) {
            stringBuilder0.append(s);
            return new m(s, stringBuilder0);
        }
        s = this.a.a(0x7F1310D8);  // string:unknown_song_name "알 수 없는 곡"
        stringBuilder0.append(s);
        return new m(s, stringBuilder0);
    }

    public static m d(r r0) {
        switch((r0 == null ? -1 : f.a[r0.ordinal()])) {
            case 1: {
                return new m(0x7F0805A5, 0x7F130BC4);  // drawable:ic_player_dcf_more
            }
            case 2: {
                return new m(0x7F0805AA, 0x7F130BCA);  // drawable:ic_player_flac_more
            }
            case 3: {
                return new m(0x7F0805B1, 0x7F130BCC);  // drawable:ic_player_mp_3_more
            }
            case 4: {
                return new m(0x7F0805A6, 0x7F130BDE);  // drawable:ic_player_dolby_more
            }
            case 5: {
                return new m(0x7F0805AB, 0x7F130BDF);  // drawable:ic_player_flac_str_more
            }
            case 6: {
                return new m(0x7F08059D, 0x7F130BBC);  // drawable:ic_player_aac_128_more
            }
            case 7: {
                return new m(0x7F08059E, 0x7F130BBD);  // drawable:ic_player_aac_320_more
            }
            case 8: {
                return new m(0x7F08059F, 0x7F130BBE);  // drawable:ic_player_aac_96_more
            }
            case 9: {
                return new m(0x7F0805AF, 0x7F130BCE);  // drawable:ic_player_mp_3_192_more
            }
            case 10: {
                return new m(0x7F0805B0, 0x7F130BCF);  // drawable:ic_player_mp_3_320_more
            }
            case 11: {
                return new m(0x7F0805AE, 0x7F130BCD);  // drawable:ic_player_mp_3_128_more
            }
            default: {
                return new m(null, 0x7F130BD5);  // string:talkback_player_quality_setting "곡 음질 설정"
            }
        }
    }

    public final void e(l0 l00, a a0) {
        String s = this.a.a(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s1 = this.a.a(0x7F13090E);  // string:section_repeat_mode_release_content "반복재생 중입니다.\n\n반복재생 모드를 해제하시고 요청 작업을 
                                           // 진행하시겠습니까?"
        String s2 = this.a.a(0x7F130325);  // string:device_confirm "확인"
        b.x(l00, s, s1, false, false, this.a.a(0x7F130324), s2, a0, null, null, null, 3640);  // string:device_cancel "취소"
    }

    public final Object f(l0 l00, s2 s20, k k0, c c0) {
        k k1;
        l0 l01;
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.E;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.E = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Object object0 = g0.B;
        ne.a a0 = ne.a.a;
        switch(g0.E) {
            case 0: {
                n.D(object0);
                Flow flow0 = FlowKt.filterNotNull(((com.melon.playlist.b)((d3)s20).a).r);
                l01 = l00;
                g0.r = l01;
                g0.w = k0;
                g0.E = 1;
                object0 = FlowKt.first(flow0, g0);
                if(object0 == a0) {
                    return a0;
                }
                k1 = k0;
                break;
            }
            case 1: {
                k1 = g0.w;
                l0 l02 = g0.r;
                n.D(object0);
                l01 = l02;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s = this.a.a((((Boolean)object0).booleanValue() ? 0x7F130A3A : 0x7F130A3B));  // string:smart_playlist_switch_off_popup_desc "스마트 재생목록 설정을 끄고 기존 로컬 재생목록으로 변경하시겠습니까?"
        b.x(l01, this.a.a(0x7F1300D0), s, false, false, null, null, new d(0, k1), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
        return H.a;
    }
}

