package androidx.media3.session.legacy;

import X2.b;
import android.os.Bundle;

public class s extends p {
    public final MediaBrowserServiceCompat e;
    public final MediaBrowserServiceCompat f;

    public s(MediaBrowserServiceCompat mediaBrowserServiceCompat0) {
        this.f = mediaBrowserServiceCompat0;
        this.e = mediaBrowserServiceCompat0;
        super(mediaBrowserServiceCompat0);
    }

    @Override  // androidx.media3.session.legacy.p
    public final void n(Bundle bundle0, String s) {
        if(bundle0 != null) {
            b b0 = (b)this.b;
            b0.getClass();
            b0.notifyChildrenChanged(s, bundle0);
            return;
        }
        super.n(null, s);
    }
}

