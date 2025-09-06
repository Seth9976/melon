package l4;

import android.support.v4.media.session.MediaSessionCompat;

public final class e {
    public final MediaSessionCompat a;
    public d b;
    public final h c;

    public e(h h0, MediaSessionCompat mediaSessionCompat0) {
        this.c = h0;
        this.a = mediaSessionCompat0;
    }

    public final void a() {
        this.a.setPlaybackToLocal(this.c.o.e);
        this.b = null;
    }
}

