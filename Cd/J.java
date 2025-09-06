package cd;

import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import ie.H;
import java.util.List;
import we.a;

public final class j implements a {
    public final int a;
    public final r b;
    public final List c;
    public final a0 d;

    public j(r r0, List list0, a0 a00, int v) {
        this.a = v;
        this.b = r0;
        this.c = list0;
        this.d = a00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            int v = ((K0)this.d).m();
            x x0 = new x(((Chart)this.c.get(v)));
            this.b.c.invoke(x0);
            return H.a;
        }
        int v1 = ((K0)this.d).m();
        v v2 = new v(((Chart)this.c.get(v1)));
        this.b.c.invoke(v2);
        return H.a;
    }
}

