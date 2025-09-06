package com.iloen.melon.fragments.settings.alarm;

import android.os.Bundle;
import androidx.compose.runtime.l;
import com.iloen.melon.fragments.settings.SettingBaseFragment;
import we.n;

public final class a implements n {
    public final int a;
    public final SettingBaseFragment b;

    public a(SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = settingBaseFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return SettingMusicAlarmFragment.onCreate$lambda$1(((SettingMusicAlarmFragment)this.b), ((String)object0), ((Bundle)object1));
            }
            case 1: {
                return SettingMusicAlarmListFragment.L(((SettingMusicAlarmListFragment)this.b), ((l)object0), ((int)(((Integer)object1))));
            }
            default: {
                return SettingMusicAlarmSongFragment.S(((SettingMusicAlarmSongFragment)this.b), ((l)object0), ((int)(((Integer)object1))));
            }
        }
    }
}

