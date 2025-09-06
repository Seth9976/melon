package com.iloen.melon.fragments.settings.alarm;

import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import o8.d;

public final class f implements CompoundButton.OnCheckedChangeListener {
    public final d a;
    public final SettingMusicAlarmFragment b;

    public f(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0) {
        this.a = d0;
        this.b = settingMusicAlarmFragment0;
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        SettingMusicAlarmFragment.buildDayOfWeekSettingView$lambda$22(this.a, this.b, compoundButton0, z);
    }
}

