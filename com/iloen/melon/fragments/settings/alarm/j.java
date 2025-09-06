package com.iloen.melon.fragments.settings.alarm;

import O.F;
import we.a;

public final class j implements a {
    public final int a;
    public final F b;

    public j(F f0, int v) {
        this.a = v;
        this.b = f0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? Boolean.valueOf(SettingMusicAlarmListFragment.P(this.b)) : Boolean.valueOf(SettingMusicAlarmListFragment.U(this.b));
    }
}

