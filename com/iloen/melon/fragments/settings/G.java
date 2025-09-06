package com.iloen.melon.fragments.settings;

import com.iloen.melon.custom.b1;

public final class g implements b1 {
    public final int a;
    public final SettingBackgroundAutoPlayFragment b;

    public g(SettingBackgroundAutoPlayFragment settingBackgroundAutoPlayFragment0, int v) {
        this.a = v;
        this.b = settingBackgroundAutoPlayFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.b1
    public final void onRadioBtnClick(boolean z) {
        if(this.a != 0) {
            SettingBackgroundAutoPlayFragment.initViews$lambda$1(this.b, z);
            return;
        }
        SettingBackgroundAutoPlayFragment.initViews$lambda$0(this.b, z);
    }
}

