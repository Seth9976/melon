package com.iloen.melon.playback.playlist.smartplaylist;

import we.k;

public final class a implements k {
    public final String a;
    public final DrawerPlaylistInfo b;
    public final String c;
    public final String d;
    public final boolean e;

    public a(String s, DrawerPlaylistInfo drawerPlaylistInfo0, String s1, String s2, boolean z) {
        this.a = s;
        this.b = drawerPlaylistInfo0;
        this.c = s1;
        this.d = s2;
        this.e = z;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return DrawerPlaylistInfoKt.compareToViewMode$lambda$0(this.a, this.b, this.c, this.d, this.e, ((StringBuilder)object0));
    }
}

