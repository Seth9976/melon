package Ec;

import Tf.o;
import a1.g;
import androidx.compose.runtime.b0;
import f1.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class j implements k {
    public final int a;
    public final int b;
    public final b0 c;
    public final k d;

    public j(int v, b0 b00, k k0) {
        this.a = 1;
        super();
        this.b = v;
        this.c = b00;
        this.d = k0;
    }

    public j(int v, k k0, b0 b00) {
        this.a = 0;
        super();
        this.b = v;
        this.d = k0;
        this.c = b00;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((x)object0), "new");
            g g0 = ((x)object0).a;
            String s = this.b <= 0 || g0.b.length() <= this.b ? o.g1(g0.b).toString() : o.d1(this.b, o.g1(g0.b).toString());
            x x0 = x.b(((x)object0), s);
            this.c.setValue(x0);
            this.d.invoke(s);
            return H.a;
        }
        q.g(((String)object0), "it");
        if(((String)object0).length() <= this.b) {
            this.c.setValue(((String)object0));
            k k0 = this.d;
            if(k0 != null) {
                k0.invoke(((String)object0));
            }
        }
        return H.a;
    }
}

