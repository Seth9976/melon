package Cc;

import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.e3;
import ie.H;
import we.n;

public final class a2 implements n {
    public final int a;
    public final e3 b;

    public a2(e3 e30) {
        this.a = 1;
        super();
        this.b = e30;
    }

    public a2(e3 e30, int v) {
        this.a = 0;
        super();
        this.b = e30;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                c1.y(this.b, ((p)(((l)object0))), 0);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        ((Integer)object1).getClass();
        c1.y(this.b, ((l)object0), 1);
        return H.a;
    }
}

