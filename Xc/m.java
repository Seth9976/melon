package xc;

import Cb.i;
import Hc.P;
import Ic.J;
import Ic.z;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import m9.l;
import p8.f;
import wc.x;
import we.a;
import zd.b;

public final class m implements a {
    public final int a;
    public final s b;

    public m(s s0, int v) {
        this.a = v;
        this.b = s0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                ((x)this.b.getViewModel()).y(false);
                return H.a;
            }
            case 1: {
                s s0 = this.b;
                Object object0 = ((x)s0.getViewModel()).d.getValue();
                P p0 = object0 instanceof P ? ((P)object0) : null;
                if(p0 != null) {
                    s0.sendUserEvent(new J(!p0.b));
                }
                return H.a;
            }
            case 2: {
                s s1 = this.b;
                ((x)s1.getViewModel()).y(false);
                Object object1 = ((x)s1.getViewModel()).getUiState().getValue();
                P p1 = null;
                z z0 = object1 instanceof z ? ((z)object1) : null;
                if(z0 != null) {
                    Playable playable0 = (Playable)z0.d.invoke();
                    if(playable0 != null) {
                        Object object2 = ((x)s1.getViewModel()).d.getValue();
                        if(object2 instanceof P) {
                            p1 = (P)object2;
                        }
                        if(p1 != null) {
                            b b0 = new b(playable0);
                            l l0 = new l(28, s1, b0);
                            s1.c.z(s1, b0, l0);
                            f f0 = ((x)s1.getViewModel()).h();
                            if(f0 != null) {
                                f0.a = i.k(s1, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                                f0.d = ActionKind.ClickContent;
                                f0.y = i.k(s1, 0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
                                f0.F = i.k(s1, 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                                f0.a().track();
                            }
                        }
                    }
                }
                return H.a;
            }
            default: {
                this.b.requireActivity().getOnBackPressedDispatcher().c();
                return H.a;
            }
        }
    }
}

