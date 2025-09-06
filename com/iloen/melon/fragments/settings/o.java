package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;

public final class o implements View.OnClickListener {
    public final boolean a;
    public final BannedContentsAdapter b;
    public final GenreInfo c;

    public o(boolean z, BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0, GenreInfo settingBannedContentsFragment$GenreInfo0) {
        this.a = z;
        this.b = settingBannedContentsFragment$BannedContentsAdapter0;
        this.c = settingBannedContentsFragment$GenreInfo0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.7.1.1.invokeSuspend$lambda$0(this.a, this.b, this.c, view0);
    }
}

