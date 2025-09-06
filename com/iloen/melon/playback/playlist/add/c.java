package com.iloen.melon.playback.playlist.add;

import android.app.Activity;
import ob.z;

public final class c implements Runnable {
    public final int a;
    public final Activity b;
    public final AddToPlaylist c;
    public final Activity d;
    public final Object e;

    public c(Activity activity0, AddAllBan addFailType$AddAllBan0, AddToPlaylist addToPlaylist0, Activity activity1) {
        this.a = 1;
        super();
        this.b = activity0;
        this.e = addFailType$AddAllBan0;
        this.c = addToPlaylist0;
        this.d = activity1;
    }

    public c(Activity activity0, z z0, Activity activity1, AddToPlaylist addToPlaylist0) {
        this.a = 0;
        super();
        this.b = activity0;
        this.e = z0;
        this.d = activity1;
        this.c = addToPlaylist0;
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.invokeSuspend$lambda$4(this.b, ((AddFailType)this.e), this.c, this.d);
            return;
        }
        com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.invokeSuspend$lambda$1(this.b, ((z)this.e), this.d, this.c);
    }
}

