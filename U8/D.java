package u8;

import com.android.volley.VolleyError;
import com.iloen.melon.net.HttpResponse;

public final class d {
    public final e a;
    public final HttpResponse b;
    public final VolleyError c;

    public d(e e0, HttpResponse httpResponse0, VolleyError volleyError0) {
        this.a = e0;
        this.b = httpResponse0;
        this.c = volleyError0;
    }

    @Override
    public final String toString() {
        return va.e.b("NetworkResource - ", this.a.name());
    }
}

