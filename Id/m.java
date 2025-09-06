package id;

import H0.e;
import androidx.lifecycle.f0;
import com.melon.ui.popup.b;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class m implements a {
    public final int a;
    public final o b;

    public m(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                e.w(this.b);
                return H.a;
            }
            case 1: {
                b.x(this.b.getChildFragmentManager(), this.b.getString(0x7F1300D0), this.b.getString(0x7F1308C2), false, false, null, null, new m(this.b, 2), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
                return H.a;
            }
            default: {
                w w0 = (w)this.b.getViewModel();
                w0.getClass();
                T2.a a0 = f0.h(w0);
                t t0 = new t(w0, null);
                BuildersKt__Builders_commonKt.launch$default(a0, w0.c, null, t0, 2, null);
                return H.a;
            }
        }
    }
}

