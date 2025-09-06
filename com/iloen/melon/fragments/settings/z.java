package com.iloen.melon.fragments.settings;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;

public final class z implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final SettingMainFragment a;

    public z(SettingMainFragment settingMainFragment0) {
        this.a = settingMainFragment0;
    }

    @Override  // android.content.SharedPreferences$OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences0, String s) {
        SettingMainFragment.mPrefListener$lambda$31(this.a, sharedPreferences0, s);
    }
}

