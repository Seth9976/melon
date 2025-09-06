package com.iloen.melon.fragments.settings.alarm;

import we.n;

public final class l implements n {
    public final int a;
    public final SettingMusicAlarmSongFragment b;
    public final int c;

    public l(SettingMusicAlarmSongFragment settingMusicAlarmSongFragment0, int v, int v1) {
        this.a = v1;
        this.b = settingMusicAlarmSongFragment0;
        this.c = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        switch(this.a) {
            case 0: {
                return SettingMusicAlarmSongFragment.Body$lambda$10(this.b, this.c, ((androidx.compose.runtime.l)object0), v);
            }
            case 1: {
                return SettingMusicAlarmSongFragment.MusicList$lambda$20(this.b, this.c, ((androidx.compose.runtime.l)object0), v);
            }
            default: {
                return SettingMusicAlarmSongFragment.EmptyBody$lambda$29(this.b, this.c, ((androidx.compose.runtime.l)object0), v);
            }
        }
    }
}

