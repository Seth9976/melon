package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.player.playlist.drawernew.model.DrawerAlyac;
import com.melon.ui.K4;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class d implements k {
    public final int a;
    public final Object b;

    public d(Object object0, int v) {
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
                q.g(((DrawerAlyac)object0), "it");
                ((k)object1).invoke(((DrawerAlyac)object0));
                return h0;
            }
            case 1: {
                q.g(((DrawerAlyac)object0), "it");
                ((k)object1).invoke(((DrawerAlyac)object0));
                return h0;
            }
            default: {
                q.g(((K4)object0), "it");
                return (K4)object1;
            }
        }
    }
}

