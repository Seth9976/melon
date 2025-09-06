package Ic;

import com.melon.ui.x4;
import ie.H;
import je.p;
import pc.G0;
import we.a;

public final class h0 implements a {
    public final int a;
    public final A0 b;

    public h0(A0 a00, int v) {
        this.a = v;
        this.b = a00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s2;
        H h0 = H.a;
        A0 a00 = this.b;
        switch(this.a) {
            case 0: {
                a00.w(false);
                a00.y(a00.b.a(0x7F130030), "", "");  // string:airbridge_all "전체"
                return h0;
            }
            case 1: {
                a00.w(true);
                a00.y(a00.b.a(0x7F13004D), "", "");  // string:airbridge_shuffle "셔플"
                return h0;
            }
            case 2: {
                String s = a00.p();
                String s1 = a00.r();
                n n0 = a00.q();
                if(n0 == null) {
                    s2 = "";
                }
                else {
                    s2 = n0.e.size() == 1 ? ((o)p.k0(n0.e)).a : "";
                }
                G0 g00 = new G0(8, null, s, s1, s2);
                a00.sendUiEvent(new x4(a00.getMenuId(), g00, false));
                a00.trackTiaraEventLog(new i0(a00, 0));
                a00.y(a00.b.a(0x7F130049), "", "");  // string:airbridge_mixup "믹스업"
                return h0;
            }
            case 3: {
                a00.onUserEvent(Ic.H.a);
                return h0;
            }
            case 4: {
                a00.onUserEvent(N.a);
                return h0;
            }
            case 5: {
                a00.onUserEvent(L.a);
                return h0;
            }
            case 6: {
                a00.onUserEvent(P.a);
                return h0;
            }
            case 7: {
                a00.onUserEvent(Y.a);
                return h0;
            }
            case 8: {
                a00.onUserEvent(E.a);
                return h0;
            }
            default: {
                a00.onUserEvent(b0.a);
                return h0;
            }
        }
    }
}

