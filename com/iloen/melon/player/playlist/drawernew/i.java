package com.iloen.melon.player.playlist.drawernew;

import ie.H;
import we.k;

public final class i implements k {
    public final int a;
    public final DrawerSongFragment b;

    public i(DrawerSongFragment drawerSongFragment0, int v) {
        this.a = v;
        this.b = drawerSongFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        DrawerSongFragment drawerSongFragment0 = this.b;
        int v = (int)(((Integer)object0));
        switch(this.a) {
            case 0: {
                ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).updateUserEvent(new OnClickSongMore(v));
                return h0;
            }
            case 1: {
                ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).updateUserEvent(new OnClickSong(v));
                return h0;
            }
            default: {
                ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).updateUserEvent(new OnClickThumb(v));
                return h0;
            }
        }
    }
}

