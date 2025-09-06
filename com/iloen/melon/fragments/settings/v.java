package com.iloen.melon.fragments.settings;

import com.iloen.melon.custom.b1;

public final class v implements b1 {
    public final int a;
    public final SettingLaboratoryFragment b;

    public v(SettingLaboratoryFragment settingLaboratoryFragment0, int v) {
        this.a = v;
        this.b = settingLaboratoryFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.b1
    public final void onRadioBtnClick(boolean z) {
        if(this.a != 0) {
            SettingLaboratoryFragment.initInstantPlay$lambda$4(this.b, z);
            return;
        }
        SettingLaboratoryFragment.initErrorReport$lambda$5(this.b, z);
    }
}

