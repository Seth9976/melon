package androidx.media3.session.legacy;

import E9.t;
import android.os.IBinder.DeathRecipient;
import java.util.HashMap;

public final class n implements IBinder.DeathRecipient {
    public final String a;
    public final int b;
    public final int c;
    public final b0 d;
    public final y e;
    public final HashMap f;
    public final MediaBrowserServiceCompat g;

    public n(MediaBrowserServiceCompat mediaBrowserServiceCompat0, String s, int v, int v1, z z0) {
        this.g = mediaBrowserServiceCompat0;
        this.f = new HashMap();
        this.a = s;
        this.b = v;
        this.c = v1;
        this.d = new b0(s, v, v1);
        this.e = z0;
    }

    @Override  // android.os.IBinder$DeathRecipient
    public final void binderDied() {
        t t0 = new t(this, 9);
        this.g.g.post(t0);
    }
}

