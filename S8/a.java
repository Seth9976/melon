package s8;

import E9.w;
import Eb.f;
import com.iloen.melon.api.data.local.ResponseCacheDatabase_Impl;
import com.iloen.melon.playback.playlist.db.d;
import m9.l;

public final class a {
    public final ResponseCacheDatabase_Impl a;
    public final f b;

    public a(ResponseCacheDatabase_Impl responseCacheDatabase_Impl0) {
        this.a = responseCacheDatabase_Impl0;
        this.b = new f(12);
    }

    public final b a(String s) {
        d d0 = new d(s, 25);
        return (b)w.N(this.a, true, false, d0);
    }

    public final void b(b b0) {
        l l0 = new l(10, this, b0);
        w.N(this.a, false, true, l0);
    }
}

