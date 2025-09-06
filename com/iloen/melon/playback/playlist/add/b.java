package com.iloen.melon.playback.playlist.add;

import android.app.Activity;
import ob.z;
import we.a;

public final class b implements a {
    public final z a;
    public final Activity b;
    public final AddToPlaylist c;

    public b(z z0, Activity activity0, AddToPlaylist addToPlaylist0) {
        this.a = z0;
        this.b = activity0;
        this.c = addToPlaylist0;
    }

    @Override  // we.a
    public final Object invoke() {
        return com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.invokeSuspend$lambda$1$lambda$0(this.a, this.b, this.c);
    }
}

