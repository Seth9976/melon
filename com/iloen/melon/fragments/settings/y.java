package com.iloen.melon.fragments.settings;

import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.fragments.FetcherBaseFragment;
import we.a;

public final class y implements a {
    public final int a;
    public final boolean b;
    public final SettingItemView c;
    public final FetcherBaseFragment d;

    public y(SettingItemView settingItemView0, SettingLaboratoryFragment settingLaboratoryFragment0, boolean z) {
        this.a = 0;
        super();
        this.c = settingItemView0;
        this.b = z;
        this.d = settingLaboratoryFragment0;
    }

    public y(SettingMainFragment settingMainFragment0, SettingItemView settingItemView0, boolean z) {
        this.a = 1;
        super();
        this.d = settingMainFragment0;
        this.b = z;
        this.c = settingItemView0;
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? SettingLaboratoryFragment.L(this.c, ((SettingLaboratoryFragment)this.d), this.b) : SettingMainFragment.n0(((SettingMainFragment)this.d), this.c, this.b);
    }
}

