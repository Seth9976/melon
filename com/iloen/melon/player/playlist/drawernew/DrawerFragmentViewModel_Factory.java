package com.iloen.melon.player.playlist.drawernew;

import Pc.d;
import Ya.g;
import eb.n;
import eb.u;
import ge.b;
import k8.a;
import kc.s2;
import mb.k;
import ob.z;

public final class DrawerFragmentViewModel_Factory implements b {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final b h;

    public DrawerFragmentViewModel_Factory(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
        this.f = b5;
        this.g = b6;
        this.h = b7;
    }

    public static DrawerFragmentViewModel_Factory create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7) {
        return new DrawerFragmentViewModel_Factory(b0, b1, b2, b3, b4, b5, b6, b7);
    }

    public DrawerFragmentViewModel get() {
        DrawerFragmentViewModel drawerFragmentViewModel0 = DrawerFragmentViewModel_Factory.newInstance(((g)this.a.get()), ((k)this.b.get()), ((s2)this.c.get()), ((a)this.d.get()), ((z)this.e.get()), ((d)this.f.get()));
        drawerFragmentViewModel0.pvUseCase = (n)this.g.get();
        drawerFragmentViewModel0.screenCaptureUseCase = (u)this.h.get();
        return drawerFragmentViewModel0;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static DrawerFragmentViewModel newInstance(g g0, k k0, s2 s20, a a0, z z0, d d0) {
        return new DrawerFragmentViewModel(g0, k0, s20, a0, z0, d0);
    }
}

