package w3;

import android.net.Uri;
import e3.b;
import g3.f;
import g3.j;
import g3.w;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import jeb.synthetic.FIN;
import s3.q;

public final class m implements h {
    public final long a;
    public final j b;
    public final int c;
    public final w d;
    public final l e;
    public volatile Object f;

    public m(f f0, Uri uri0, l l0) {
        Map map0 = Collections.EMPTY_MAP;
        b.l(uri0, "The uri must be set.");
        j j0 = new j(uri0, 1, null, map0, 0L, -1L, null, 1);
        super();
        this.d = new w(f0);
        this.b = j0;
        this.c = 4;
        this.e = l0;
        this.a = q.c.getAndIncrement();
    }

    @Override  // w3.h
    public final void cancelLoad() {
    }

    @Override  // w3.h
    public final void load() {
        this.d.b = 0L;
        g3.h h0 = new g3.h(this.d, this.b);
        int v = FIN.finallyOpen$NT();
        h0.h();
        Uri uri0 = this.d.a.getUri();
        uri0.getClass();
        this.f = this.e.f(uri0, h0);
        try {
            FIN.finallyCodeBegin$NT(v);
            h0.close();
            FIN.finallyCodeEnd$NT(v);
        }
        catch(IOException unused_ex) {
        }
    }
}

