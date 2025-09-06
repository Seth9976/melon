package w8;

import B2.a;
import E9.h;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class u implements n {
    public final int a;
    public final boolean b;
    public final float c;
    public final Context d;

    public u(boolean z, float f, Context context0, int v) {
        this.a = v;
        this.b = z;
        this.c = f;
        this.d = context0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                B2.n n0 = V4.u.G(this.c);
                h.g(new a((this.b ? 0x7F08029E : 0x7F08029D)), "다음곡", n0, 0, ((p)(((l)object0))), 0, 24);  // drawable:btn_widget_next_w
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            B2.n n1 = V4.u.G(this.c);
            h.g(new a((this.b ? 0x7F08028C : 0x7F08028B)), "이전곡", n1, 0, ((p)(((l)object0))), 0, 24);  // drawable:btn_widget_back_w
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

