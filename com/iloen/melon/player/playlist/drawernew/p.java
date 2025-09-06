package com.iloen.melon.player.playlist.drawernew;

import Lb.c;
import ie.H;
import kotlin.jvm.internal.q;
import oc.U;
import oc.c0;
import we.k;

public final class p implements k {
    public final int a;
    public final DrawerSongFragmentViewModel b;

    public p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, int v) {
        this.a = v;
        this.b = drawerSongFragmentViewModel0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((c)object0), "uiEvent");
                drawerSongFragmentViewModel0.sendUiEvent(((c)object0));
                return h0;
            }
            case 1: {
                q.g(((c0)object0), "state");
                drawerSongFragmentViewModel0.i(((c0)object0));
                return h0;
            }
            case 2: {
                DrawerSongFragmentViewModel.access$afterDeleteTask(drawerSongFragmentViewModel0, ((U)object0), true);
                return h0;
            }
            default: {
                DrawerSongFragmentViewModel.access$afterDeleteTask(drawerSongFragmentViewModel0, ((U)object0), false);
                return h0;
            }
        }
    }
}

