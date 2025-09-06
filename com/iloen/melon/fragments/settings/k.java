package com.iloen.melon.fragments.settings;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.SettingGnrMenuRes;
import com.iloen.melon.net.v6x.response.BanListBannedSongRes;
import v9.i;

public final class k implements Listener {
    public final int a;
    public final SettingBannedContentsFragment b;
    public final i c;

    public k(SettingBannedContentsFragment settingBannedContentsFragment0, i i0, int v) {
        this.a = v;
        this.b = settingBannedContentsFragment0;
        this.c = i0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            SettingBannedContentsFragment.requestGnrMenu$lambda$32(this.b, this.c, ((SettingGnrMenuRes)object0));
            return;
        }
        SettingBannedContentsFragment.requesBannedSongList$lambda$25(this.b, this.c, ((BanListBannedSongRes)object0));
    }
}

