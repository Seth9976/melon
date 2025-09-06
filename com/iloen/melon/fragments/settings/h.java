package com.iloen.melon.fragments.settings;

import a9.d;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.G;
import com.iloen.melon.net.v4x.response.MyMusicDeleteBanSongRes;

public final class h implements d, ErrorListener, Listener, G {
    public final SettingBannedContentsFragment a;

    public h(SettingBannedContentsFragment settingBannedContentsFragment0) {
        this.a = settingBannedContentsFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.G
    public void onClick(FilterDropDownView filterDropDownView0) {
        SettingBannedContentsFragment.onViewCreated$lambda$10$lambda$9(this.a, filterDropDownView0);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        SettingBannedContentsFragment.requesBannedSongList$lambda$26(this.a, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        SettingBannedContentsFragment.deleteBanSongList$lambda$34(this.a, ((MyMusicDeleteBanSongRes)object0));
    }

    @Override  // a9.d
    public void onSelected(int v) {
        SettingBannedContentsFragment.onViewCreated$lambda$4$lambda$3(this.a, v);
    }
}

