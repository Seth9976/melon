package com.iloen.melon.fragments.settings.alarm;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.settings.SettingBaseFragment;

public final class d implements View.OnClickListener {
    public final int a;
    public final SettingBaseFragment b;

    public d(SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = settingBaseFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            SettingMusicAlarmListFragment.R(((SettingMusicAlarmListFragment)this.b), view0);
            return;
        }
        SettingMusicAlarmFragment.buildUi$lambda$6$lambda$5$lambda$4(((SettingMusicAlarmFragment)this.b), view0);
    }
}

