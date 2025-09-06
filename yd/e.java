package yd;

import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import ie.H;
import w0.h;
import we.a;
import we.k;
import zd.A;
import zd.Q;

public final class e implements a {
    public final int a;
    public final h b;
    public final MelonBottomSheetItem c;
    public final k d;
    public final int e;
    public final Q f;

    public e(h h0, MelonBottomSheetItem melonBottomSheetItem0, k k0, int v, Q q0, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = melonBottomSheetItem0;
        this.d = k0;
        this.e = v;
        this.f = q0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            MelonBottomSheetItem melonBottomSheetItem0 = this.c;
            if(melonBottomSheetItem0.e) {
                A a0 = new A(this.e, melonBottomSheetItem0, this.f);
                this.d.invoke(a0);
            }
            return H.a;
        }
        h.a(this.b);
        MelonBottomSheetItem melonBottomSheetItem1 = this.c;
        if(melonBottomSheetItem1.e) {
            A a1 = new A(this.e, melonBottomSheetItem1, this.f);
            this.d.invoke(a1);
        }
        return H.a;
    }
}

