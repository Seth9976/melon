package i.n.i.b.a.s.e;

import android.net.Uri;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Map;

public final class ye implements D0 {
    public final D0 a;
    public long b;
    public Uri c;
    public Map d;
    public String e;

    public ye(D0 d00) {
        d00.getClass();
        this.a = d00;
        this.c = Uri.EMPTY;
        this.d = Collections.EMPTY_MAP;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        String s;
        this.c = w20.b;
        this.d = Collections.EMPTY_MAP;
        long v = this.a.b(w20);
        Uri uri0 = this.a.c();
        uri0.getClass();
        this.c = uri0;
        this.d = this.a.e();
        try {
            s = null;
            s = InetAddress.getByName(this.c.getHost()).getHostAddress();
        }
        catch(Exception unused_ex) {
        }
        this.e = s;
        return v;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.a.c();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        this.a.close();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Map e() {
        return this.a.e();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void l(g0 g00) {
        g00.getClass();
        this.a.l(g00);
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        int v2 = this.a.o(arr_b, v, v1);
        if(v2 != -1) {
            this.b += (long)v2;
        }
        return v2;
    }
}

