package i.n.i.b.a.s.e;

import android.net.Uri;
import com.iloen.melon.custom.S0;
import java.util.ArrayList;

public final class y5 extends z5 {
    public final R4 f;
    public final S0 g;

    public y5(u u0, String s, j6 j60, ArrayList arrayList0) {
        super(u0, s, j60, arrayList0);
        Uri.parse(s);
        S0 s00 = null;
        R4 r40 = Long.compare(j60.e, 0L) > 0 ? new R4(null, j60.d, j60.e) : null;
        this.f = r40;
        if(r40 == null) {
            s00 = new S0(new R4(null, 0L, -1L), 25);
        }
        this.g = s00;
    }

    @Override  // i.n.i.b.a.s.e.z5
    public final String e() {
        return null;
    }

    @Override  // i.n.i.b.a.s.e.z5
    public final Wc f() {
        return this.g;
    }

    @Override  // i.n.i.b.a.s.e.z5
    public final R4 i() {
        return this.f;
    }
}

