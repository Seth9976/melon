package com.iloen.melon.fragments.settings;

import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.custom.b1;

public final class x implements b1 {
    public final int a;
    public final SettingItemView b;
    public final SettingLaboratoryFragment c;

    public x(SettingItemView settingItemView0, SettingLaboratoryFragment settingLaboratoryFragment0, int v) {
        this.a = v;
        this.b = settingItemView0;
        this.c = settingLaboratoryFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.b1
    public final void onRadioBtnClick(boolean z) {
        if(this.a != 0) {
            SettingLaboratoryFragment.initLowMemoryMode$lambda$1(this.b, this.c, z);
            return;
        }
        SettingLaboratoryFragment.initUseAutoPlayByExternal$lambda$8(this.b, this.c, z);
    }
}

