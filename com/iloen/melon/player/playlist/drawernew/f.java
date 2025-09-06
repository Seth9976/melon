package com.iloen.melon.player.playlist.drawernew;

import com.melon.ui.K4;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.c0;
import we.k;

public final class f implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public f(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Object object1 = this.c;
        Object object2 = this.b;
        if(this.a != 0) {
            ((DrawerSongFragment)object2).sendUserEvent(new OnCheckSong(((c0)object1), ((int)(((Integer)object0)))));
            return H.a;
        }
        q.g(((K4)object0), "it");
        ((DrawerFragmentViewModel)object2).e("fetchDrawerPlytList() offlineMode", ((List)object1));
        return Idle.INSTANCE;
    }
}

