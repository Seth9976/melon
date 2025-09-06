package xc;

import Cb.i;
import Hc.P;
import Ic.J;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import m9.l;
import p8.f;
import wc.x;
import we.a;
import zd.b;

public final class u implements a {
    public final int a;
    public final z b;

    public u(z z0, int v) {
        this.a = v;
        this.b = z0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                z z0 = this.b;
                Object object0 = ((x)z0.getViewModel()).d.getValue();
                P p0 = object0 instanceof P ? ((P)object0) : null;
                if(p0 != null) {
                    z0.sendUserEvent(new J(!p0.b));
                }
                return H.a;
            }
            case 1: {
                this.b.requireActivity().getOnBackPressedDispatcher().c();
                return H.a;
            }
            case 2: {
                z z1 = this.b;
                ((x)z1.getViewModel()).y(false);
                Object object1 = ((x)z1.getViewModel()).getUiState().getValue();
                P p1 = null;
                Ic.z z2 = object1 instanceof Ic.z ? ((Ic.z)object1) : null;
                if(z2 != null) {
                    Playable playable0 = (Playable)z2.d.invoke();
                    if(playable0 != null) {
                        Object object2 = ((x)z1.getViewModel()).d.getValue();
                        if(object2 instanceof P) {
                            p1 = (P)object2;
                        }
                        if(p1 != null) {
                            b b0 = new b(playable0);
                            l l0 = new l(29, z1, b0);
                            z1.c.z(z1, b0, l0);
                            f f0 = ((x)z1.getViewModel()).h();
                            if(f0 != null) {
                                f0.a = i.k(z1, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                                f0.d = ActionKind.ClickContent;
                                f0.y = i.k(z1, 0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
                                f0.F = i.k(z1, 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                                f0.a().track();
                            }
                        }
                    }
                }
                return H.a;
            }
            default: {
                ((x)this.b.getViewModel()).y(false);
                return H.a;
            }
        }
    }
}

