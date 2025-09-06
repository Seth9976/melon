package com.iloen.melon.fragments.settings.alarm;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.fragments.settings.SettingBaseFragment;
import com.iloen.melon.net.v3x.comments.ListMusicRes;
import com.iloen.melon.net.v6x.response.SongInfoRes;

public final class m implements ErrorListener, Listener {
    public final int a;
    public final SettingBaseFragment b;

    public m(SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = settingBaseFragment0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        SettingMusicAlarmSongFragment.searchMusic$lambda$4(((SettingMusicAlarmSongFragment)this.b), volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 0) {
            SettingMusicAlarmFragment.updateMusicInfo$lambda$37(((SettingMusicAlarmFragment)this.b), ((SongInfoRes)object0));
            return;
        }
        SettingMusicAlarmSongFragment.searchMusic$lambda$3(((SettingMusicAlarmSongFragment)this.b), ((ListMusicRes)object0));
    }
}

