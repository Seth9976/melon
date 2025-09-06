package com.iloen.melon.fragments.settings.alarm;

import android.view.View.OnScrollChangeListener;
import android.view.View;

public final class e implements View.OnScrollChangeListener {
    public final SettingMusicAlarmFragment a;

    public e(SettingMusicAlarmFragment settingMusicAlarmFragment0) {
        this.a = settingMusicAlarmFragment0;
    }

    @Override  // android.view.View$OnScrollChangeListener
    public final void onScrollChange(View view0, int v, int v1, int v2, int v3) {
        SettingMusicAlarmFragment.buildUi$lambda$7(this.a, view0, v, v1, v2, v3);
    }
}

