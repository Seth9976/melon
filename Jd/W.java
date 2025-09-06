package jd;

import androidx.lifecycle.f0;
import com.melon.ui.I4;
import com.melon.ui.b;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class w implements a {
    public final int a;
    public final I4 b;
    public final A c;

    public w(I4 i40, A a0) {
        this.a = 1;
        super();
        this.b = i40;
        this.c = a0;
    }

    public w(A a0, I4 i40) {
        this.a = 0;
        super();
        this.c = a0;
        this.b = i40;
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        A a0 = this.c;
        I4 i40 = this.b;
        if(this.a != 0) {
            if(((b)i40).b != null) {
                M0 m00 = (M0)a0.getViewModel();
                w w0 = new w(a0, i40);
                m00.getClass();
                BuildersKt__Builders_commonKt.launch$default(f0.h(m00), null, null, new m0(m00, w0, null), 3, null);
            }
            return h0;
        }
        a0.sendUserEvent(((b)i40).b);
        return h0;
    }
}

