package bd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import ie.H;
import we.a;
import we.n;

public final class h implements n {
    public final int a;
    public final Content b;
    public final boolean c;
    public final a d;

    public h(Content flexibleRes$RESPONSE$Flexible$Content0, boolean z, a a0, int v, int v1) {
        this.a = v1;
        this.b = flexibleRes$RESPONSE$Flexible$Content0;
        this.c = z;
        this.d = a0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).getClass();
        if(this.a != 0) {
            l.a(this.b, this.c, this.d, ((androidx.compose.runtime.l)object0), 1);
            return H.a;
        }
        i.a(this.b, this.c, this.d, ((androidx.compose.runtime.l)object0), 1);
        return H.a;
    }
}

