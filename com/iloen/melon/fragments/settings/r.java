package com.iloen.melon.fragments.settings;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.ListArtistRes;
import v9.i;

public final class r implements Listener {
    public final SettingExcludedArtistSearchFragment a;
    public final boolean b;
    public final i c;

    public r(SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, boolean z, i i0) {
        this.a = settingExcludedArtistSearchFragment0;
        this.b = z;
        this.c = i0;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        SettingExcludedArtistSearchFragment.requestListArtist$lambda$1(this.a, this.b, this.c, ((ListArtistRes)object0));
    }
}

