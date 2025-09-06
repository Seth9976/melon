package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;

public final class l implements View.OnClickListener {
    public final int a;
    public final SettingBannedContentsFragment b;

    public l(SettingBannedContentsFragment settingBannedContentsFragment0, int v) {
        this.a = v;
        this.b = settingBannedContentsFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            SettingBannedContentsFragment.onViewCreated$lambda$12$lambda$11(this.b, view0);
            return;
        }
        BannedContentsAdapter.onBindViewImpl$lambda$3(this.b, view0);
    }
}

