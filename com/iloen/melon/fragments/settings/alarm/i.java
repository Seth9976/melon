package com.iloen.melon.fragments.settings.alarm;

import androidx.compose.runtime.l;
import we.n;

public final class i implements n {
    public final int a;
    public final SettingMusicAlarmListFragment b;
    public final SettingAlarmListViewModel c;
    public final int d;

    public i(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, SettingAlarmListViewModel settingAlarmListViewModel0, int v, int v1) {
        this.a = v1;
        this.b = settingMusicAlarmListFragment0;
        this.c = settingAlarmListViewModel0;
        this.d = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        return this.a == 0 ? SettingMusicAlarmListFragment.T(this.b, this.c, this.d, ((l)object0), v) : SettingMusicAlarmListFragment.SelectAll$lambda$16(this.b, this.c, this.d, ((l)object0), v);
    }
}

