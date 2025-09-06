package g3;

import android.net.Uri;
import android.util.Base64;
import b3.I;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public final class d extends b {
    public j e;
    public byte[] f;
    public int g;
    public int h;

    @Override  // g3.f
    public final void close() {
        if(this.f != null) {
            this.f = null;
            this.b();
        }
        this.e = null;
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.e == null ? null : this.e.a;
    }

    @Override  // g3.f
    public final long p(j j0) {
        this.c();
        this.e = j0;
        long v = j0.f;
        Uri uri0 = j0.a.normalizeScheme();
        String s = uri0.getScheme();
        e3.b.d("data".equals(s), "Unsupported scheme: " + s);
        String[] arr_s = uri0.getSchemeSpecificPart().split(",", -1);
        if(arr_s.length != 2) {
            throw new I(0, "Unexpected URI format: " + uri0, null, true);
        }
        String s1 = arr_s[1];
        if(arr_s[0].contains(";base64")) {
            try {
                this.f = Base64.decode(s1, 0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                throw new I(0, "Error while parsing Base64 encoded string: " + s1, illegalArgumentException0, true);
            }
        }
        else {
            this.f = URLDecoder.decode(s1, "US-ASCII").getBytes(StandardCharsets.UTF_8);
        }
        long v1 = j0.e;
        byte[] arr_b = this.f;
        if(v1 <= ((long)arr_b.length)) {
            this.g = (int)v1;
            int v2 = arr_b.length - ((int)v1);
            this.h = v2;
            int v3 = Long.compare(v, -1L);
            if(v3 != 0) {
                this.h = (int)Math.min(v2, v);
            }
            this.d(j0);
            return v3 == 0 ? ((long)this.h) : v;
        }
        this.f = null;
        throw new g(2008);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        int v2 = this.h;
        if(v2 == 0) {
            return -1;
        }
        int v3 = Math.min(v1, v2);
        System.arraycopy(this.f, this.g, arr_b, v, v3);
        this.g += v3;
        this.h -= v3;
        this.a(v3);
        return v3;
    }
}

