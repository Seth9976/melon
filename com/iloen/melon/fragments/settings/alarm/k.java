package com.iloen.melon.fragments.settings.alarm;

import O.w;

public final class k implements we.k {
    public final int a;
    public final SettingMusicAlarmSongFragment b;

    public k(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, int v) {
        this.a = v;
        this.b = settingMusicAlarmSongFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return SettingMusicAlarmSongFragment.Body$lambda$9$lambda$6$lambda$5(this.b, ((String)object0));
            }
            case 1: {
                return SettingMusicAlarmSongFragment.Body$lambda$9$lambda$8$lambda$7(this.b, ((int)(((Integer)object0))));
            }
            default: {
                return SettingMusicAlarmSongFragment.MusicList$lambda$17$lambda$16(this.b, ((w)object0));
            }
        }
    }
}

