package com.iloen.melon.popup;

import Xd.a;
import ge.b;
import ob.z;

public final class InstantPlayPopup_MembersInjector implements a {
    public final b a;

    public InstantPlayPopup_MembersInjector(b b0) {
        this.a = b0;
    }

    public static a create(b b0) {
        return new InstantPlayPopup_MembersInjector(b0);
    }

    public void injectMembers(InstantPlayPopup instantPlayPopup0) {
        InstantPlayPopup_MembersInjector.injectPlayerUseCase(instantPlayPopup0, ((z)this.a.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((InstantPlayPopup)object0));
    }

    public static void injectPlayerUseCase(InstantPlayPopup instantPlayPopup0, z z0) {
        instantPlayPopup0.playerUseCase = z0;
    }
}

