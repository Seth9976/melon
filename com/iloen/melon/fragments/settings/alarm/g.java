package com.iloen.melon.fragments.settings.alarm;

import o8.d;
import p8.f;
import we.k;

public final class g implements k {
    public final int a;
    public final Object b;

    public g(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.invokeSuspend$lambda$0(((SettingMusicAlarmFragment)this.b), ((Boolean)object0).booleanValue());
            }
            case 1: {
                return MusicAlarmViewModel.sendSaveClickLog$lambda$6$lambda$5(((d)this.b), ((f)object0));
            }
            default: {
                return SettingMusicAlarmListFragment.a0(((SettingAlarmListViewModel)this.b), ((int)(((Integer)object0))));
            }
        }
    }
}

