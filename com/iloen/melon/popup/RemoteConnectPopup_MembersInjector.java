package com.iloen.melon.popup;

import Pc.d;
import Xd.a;
import ge.b;

public final class RemoteConnectPopup_MembersInjector implements a {
    public final b a;

    public RemoteConnectPopup_MembersInjector(b b0) {
        this.a = b0;
    }

    public static a create(b b0) {
        return new RemoteConnectPopup_MembersInjector(b0);
    }

    public void injectMembers(RemoteConnectPopup remoteConnectPopup0) {
        RemoteConnectPopup_MembersInjector.injectStringProvider(remoteConnectPopup0, ((d)this.a.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((RemoteConnectPopup)object0));
    }

    public static void injectStringProvider(RemoteConnectPopup remoteConnectPopup0, d d0) {
        remoteConnectPopup0.stringProvider = d0;
    }
}

