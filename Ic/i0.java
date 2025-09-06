package Ic;

import Jc.B;
import Jc.I0;
import Jc.M;
import Jc.Z;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import k8.Y;
import kotlin.jvm.internal.q;
import p8.f;
import we.k;
import ye.a;

public final class i0 implements k {
    public final int a;
    public final A0 b;

    public i0(A0 a00, int v) {
        this.a = v;
        this.b = a00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        A0 a00 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((f)object0), "$this$trackTiaraEventLog");
                ((f)object0).a = a00.b.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((f)object0).d = ActionKind.PlayMusic;
                ((f)object0).y = a00.b.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                ((f)object0).F = a00.b.a(0x7F130D53);  // string:tiara_click_copy_mixup "믹스업"
                ((f)object0).e = a00.p();
                ((f)object0).f = Y.i(ContsTypeCode.ALBUM_MIXUP, "code(...)");
                ((f)object0).g = a00.r();
                ((f)object0).W = "1000003099";
                return (f)object0;
            }
            case 1: {
                a00.x(((Boolean)object0).booleanValue());
                return h0;
            }
            case 2: {
                q.g(((Z)object0), "uiState");
                a00.onUserEvent(new V(((Z)object0)));
                return h0;
            }
            case 3: {
                q.g(((M)object0), "uiState");
                a00.onUserEvent(new I(((M)object0)));
                return h0;
            }
            case 4: {
                q.g(((I0)object0), "uiState");
                a00.onUserEvent(new Ic.Z(a.Z(((I0)object0).g)));
                return h0;
            }
            default: {
                q.g(((B)object0), "uiState");
                a00.onUserEvent(new Ic.B(((B)object0)));
                return h0;
            }
        }
    }
}

