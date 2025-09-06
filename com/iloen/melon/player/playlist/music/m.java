package com.iloen.melon.player.playlist.music;

import Lb.c;
import com.melon.ui.K4;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class m implements k {
    public final int a;
    public final Object b;

    public m(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                K4 k40 = (K4)object0;
                return (Success)object1;
            }
            case 1: {
                q.g(((c)object0), "uiEvent");
                ((MusicPlaylistViewModel)object1).sendUiEvent(((c)object0));
                return h0;
            }
            default: {
                q.g(((c)object0), "uiEvent");
                ((SmartPlaylistViewModel)object1).sendUiEvent(((c)object0));
                return h0;
            }
        }
    }
}

