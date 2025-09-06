package com.iloen.melon.fragments.settings;

import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;

public final class d implements N0 {
    public final int a;
    public final SettingAddPositionFragment b;

    public d(SettingAddPositionFragment settingAddPositionFragment0, int v) {
        this.a = v;
        this.b = settingAddPositionFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.N0
    public final void onCheckedChanged(RadioGroup radioGroup0, int v) {
        switch(this.a) {
            case 0: {
                SettingAddPositionFragment.initViews$lambda$1(this.b, radioGroup0, v);
                return;
            }
            case 1: {
                SettingAddPositionFragment.initViews$lambda$2(this.b, radioGroup0, v);
                return;
            }
            default: {
                SettingAddPositionFragment.initViews$lambda$3(this.b, radioGroup0, v);
            }
        }
    }
}

