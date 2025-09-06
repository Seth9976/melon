package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;

public final class m implements View.OnClickListener {
    public final SettingBannedContentsFragment a;
    public final int b;

    public m(SettingBannedContentsFragment settingBannedContentsFragment0, int v) {
        this.a = settingBannedContentsFragment0;
        this.b = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        BannedContentsAdapter.onBindViewImpl$lambda$6$lambda$5$lambda$4(this.a, this.b, view0);
    }
}

