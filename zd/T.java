package zd;

import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.k2;
import ie.H;
import w0.h;
import we.a;
import we.k;

public final class t implements a {
    public final int a;
    public final h b;
    public final m c;
    public final k d;

    public t(h h0, m m0, k k0, int v) {
        this.a = v;
        this.b = h0;
        this.c = m0;
        this.d = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            m m0 = this.c;
            if(m0.l()) {
                k2 k20 = m0.u();
                k k0 = this.d;
                if(k20 != null) {
                    k0.invoke(new D(k20));
                    return H.a;
                }
                k0.invoke(E.a);
            }
            return H.a;
        }
        h.a(this.b);
        m m1 = this.c;
        if(m1.w()) {
            C c0 = new C(m1.v());
            this.d.invoke(c0);
            return H.a;
        }
        ToastManager.showShort(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
        return H.a;
    }
}

