package com.iloen.melon.fragments.settings.alarm;

import androidx.compose.runtime.l;
import we.n;

public final class h implements n {
    public final int a;
    public final SettingMusicAlarmListFragment b;
    public final int c;

    public h(SettingMusicAlarmListFragment settingMusicAlarmListFragment0, int v, int v1) {
        this.a = v1;
        this.b = settingMusicAlarmListFragment0;
        this.c = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        switch(this.a) {
            case 0: {
                return SettingMusicAlarmListFragment.b0(this.b, this.c, ((l)object0), v);
            }
            case 1: {
                return SettingMusicAlarmListFragment.V(this.b, this.c, ((l)object0), v);
            }
            case 2: {
                return SettingMusicAlarmListFragment.X(this.b, this.c, ((l)object0), v);
            }
            default: {
                return SettingMusicAlarmListFragment.W(this.b, this.c, ((l)object0), v);
            }
        }
    }
}

