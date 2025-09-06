package com.iloen.melon.popup;

import Ub.s;
import ge.b;
import kc.s2;
import ob.z;

public final class RemoteConnectPopupViewModel_Factory implements b {
    public final b a;
    public final b b;
    public final b c;

    public RemoteConnectPopupViewModel_Factory(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static RemoteConnectPopupViewModel_Factory create(b b0, b b1, b b2) {
        return new RemoteConnectPopupViewModel_Factory(b0, b1, b2);
    }

    public RemoteConnectPopupViewModel get() {
        return RemoteConnectPopupViewModel_Factory.newInstance(((s)this.a.get()), ((s2)this.b.get()), ((z)this.c.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static RemoteConnectPopupViewModel newInstance(s s0, s2 s20, z z0) {
        return new RemoteConnectPopupViewModel(s0, s20, z0);
    }
}

