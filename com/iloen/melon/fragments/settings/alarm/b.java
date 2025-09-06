package com.iloen.melon.fragments.settings.alarm;

import android.content.Context;
import we.a;

public final class b implements a {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return SettingMusicAlarmFragment.viewModel_delegate$lambda$0(((SettingMusicAlarmFragment)this.b));
            }
            case 1: {
                return SettingMusicAlarmListFragment.M(((SettingMusicAlarmListFragment)this.b));
            }
            case 2: {
                return com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment.broadcastReceiver.2.1.onReceive$lambda$1(((Context)this.b));
            }
            default: {
                return SettingMusicAlarmSongFragment.V(((SettingMusicAlarmSongFragment)this.b));
            }
        }
    }
}

