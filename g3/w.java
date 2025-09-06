package g3;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

public final class w implements f {
    public final f a;
    public long b;
    public Uri c;
    public Map d;

    public w(f f0) {
        f0.getClass();
        this.a = f0;
        this.c = Uri.EMPTY;
        this.d = Collections.EMPTY_MAP;
    }

    @Override  // g3.f
    public final void close() {
        this.a.close();
    }

    @Override  // g3.f
    public final Map getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.a.getUri();
    }

    @Override  // g3.f
    public final long p(j j0) {
        f f0;
        try {
            f0 = this.a;
            this.c = j0.a;
            this.d = Collections.EMPTY_MAP;
            return f0.p(j0);
        }
        finally {
            Uri uri0 = f0.getUri();
            if(uri0 != null) {
                this.c = uri0;
            }
            this.d = f0.getResponseHeaders();
        }
    }

    @Override  // g3.f
    public final void r(x x0) {
        x0.getClass();
        this.a.r(x0);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        int v2 = this.a.read(arr_b, v, v1);
        if(v2 != -1) {
            this.b += (long)v2;
        }
        return v2;
    }
}

