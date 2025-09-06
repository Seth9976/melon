package ud;

import De.I;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import td.L;
import we.a;

public final class w implements a {
    public final int a;
    public final C b;

    public w(C c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.sendUserEvent(j0.a);
                return H.a;
            }
            case 1: {
                this.b.n();
                return H.a;
            }
            case 2: {
                this.b.sendUserEvent(r0.a);
                return H.a;
            }
            case 3: {
                this.b.sendUserEvent(s0.a);
                return H.a;
            }
            case 4: {
                C c0 = this.b;
                FragmentActivity fragmentActivity0 = c0.getActivity();
                if(fragmentActivity0 != null) {
                    l0 l00 = fragmentActivity0.getSupportFragmentManager();
                    if(l00 != null) {
                        MelonBottomSheetBaseFragment melonBottomSheetBaseFragment0 = c0.i;
                        if(melonBottomSheetBaseFragment0 != null) {
                            melonBottomSheetBaseFragment0.dismiss();
                        }
                        h0 h00 = (h0)((R0)c0.getViewModel()).l.getValue();
                        String s = h00 == null ? null : h00.a;
                        if(s != null && s.length() != 0) {
                            a0 a00 = new a0();
                            a00.a = new L(1, c0, C.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17);
                            a00.show(l00, "CastPlayerProgramBottomSheetFragment");
                            a00.setDismissListener(c0.j);
                            c0.i = a00;
                            return H.a;
                        }
                        ToastManager.show(0x7F130388);  // string:empty_cast_info "캐스트 회차 정보가 없습니다."
                    }
                }
                return H.a;
            }
            case 5: {
                this.b.sendUserEvent(q0.a);
                return H.a;
            }
            case 6: {
                this.b.sendUserEvent(ud.l0.a);
                return H.a;
            }
            case 7: {
                this.b.sendUserEvent(p0.a);
                return H.a;
            }
            case 8: {
                I.S(this.b);
                return H.a;
            }
            default: {
                this.b.sendUserEvent(k0.a);
                return H.a;
            }
        }
    }
}

