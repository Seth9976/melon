package androidx.media3.session.legacy;

import X2.b;
import X2.h;
import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService.Result;

public final class r extends b {
    public final s c;
    public final s d;

    public r(s s0, Context context0) {
        this.d = s0;
        this.c = s0;
        super(s0, context0);
    }

    @Override  // android.service.media.MediaBrowserService
    public final void onLoadChildren(String s, MediaBrowserService.Result mediaBrowserService$Result0, Bundle bundle0) {
        V.f(bundle0);
        h h0 = new h(mediaBrowserService$Result0, 1);
        q q0 = new q(this.d, s, h0, bundle0);
        this.d.f.f = this.d.f.c;
        this.d.f.e(s, q0, bundle0);
        this.d.f.f = null;
    }

    @Override  // android.service.media.MediaBrowserService
    public final void onLoadItem(String s, MediaBrowserService.Result mediaBrowserService$Result0) {
        o o0 = new o(1, s, new h(mediaBrowserService$Result0, 1));
        this.c.e.f = this.c.e.c;
        this.c.e.f(s, o0);
        this.c.e.f = null;
    }
}

