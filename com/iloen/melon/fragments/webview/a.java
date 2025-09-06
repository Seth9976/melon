package com.iloen.melon.fragments.webview;

import com.iloen.melon.playback.Playable;
import com.melon.ui.k2;
import we.k;

public final class a implements k {
    public final int a;
    public final MelonWebViewFragment b;
    public final Playable c;

    public a(MelonWebViewFragment melonWebViewFragment0, Playable playable0, int v) {
        this.a = v;
        this.b = melonWebViewFragment0;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? this.b.lambda$showContextPopupAlbum$11(this.c, ((k2)object0)) : this.b.lambda$showContextPopupSong$9(this.c, ((k2)object0));
    }
}

