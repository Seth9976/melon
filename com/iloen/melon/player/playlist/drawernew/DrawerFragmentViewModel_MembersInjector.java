package com.iloen.melon.player.playlist.drawernew;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class DrawerFragmentViewModel_MembersInjector implements a {
    public final b a;
    public final b b;

    public DrawerFragmentViewModel_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new DrawerFragmentViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(DrawerFragmentViewModel drawerFragmentViewModel0) {
        drawerFragmentViewModel0.pvUseCase = (n)this.a.get();
        drawerFragmentViewModel0.screenCaptureUseCase = (u)this.b.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((DrawerFragmentViewModel)object0));
    }
}

