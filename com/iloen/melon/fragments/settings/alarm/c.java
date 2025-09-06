package com.iloen.melon.fragments.settings.alarm;

import android.view.View.OnClickListener;
import android.view.View;
import o8.d;

public final class c implements View.OnClickListener {
    public final int a;
    public final d b;
    public final SettingMusicAlarmFragment c;

    public c(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0) {
        this.a = 3;
        super();
        this.c = settingMusicAlarmFragment0;
        this.b = d0;
    }

    public c(d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, int v) {
        this.a = v;
        this.b = d0;
        this.c = settingMusicAlarmFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SettingMusicAlarmFragment.Q(this.c, this.b, view0);
                return;
            }
            case 1: {
                SettingMusicAlarmFragment.U(this.c, this.b, view0);
                return;
            }
            case 2: {
                SettingMusicAlarmFragment.V(this.c, this.b, view0);
                return;
            }
            case 3: {
                SettingMusicAlarmFragment.buildMusicTypeSettingView$lambda$17$lambda$10(this.c, this.b, view0);
                return;
            }
            default: {
                SettingMusicAlarmFragment.K(this.c, this.b, view0);
            }
        }
    }
}

