package com.iloen.melon.fragments.settings;

import we.a;

public final class f implements a {
    public final int a;
    public final SettingBaseFragment b;

    public f(SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = settingBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return ((SettingAdvancedFragment)this.b).lambda$requestOverlayPermission$4();
            }
            case 1: {
                return ((SettingAdvancedFragment)this.b).lambda$requestOverlayPermission$5();
            }
            default: {
                return SettingStopTimerFragment.onResume$lambda$3(((SettingStopTimerFragment)this.b));
            }
        }
    }
}

