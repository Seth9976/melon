package com.iloen.melon.utils.ui;

import com.android.volley.Response.Listener;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class i implements Listener {
    public final MusicBrowserPopupHelper a;
    public final MusicBrowserActivity b;
    public final String c;
    public final String d;

    public i(MusicBrowserPopupHelper musicBrowserPopupHelper0, MusicBrowserActivity musicBrowserActivity0, String s, String s1) {
        this.a = musicBrowserPopupHelper0;
        this.b = musicBrowserActivity0;
        this.c = s;
        this.d = s1;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.a;
        musicBrowserPopupHelper0.n.setValue(Boolean.FALSE);
        if(((MainLayerPopupRes)object0).isSuccessful(false) && musicBrowserPopupHelper0.getActivity() != null) {
            BuildersKt__Builders_commonKt.launch$default(musicBrowserPopupHelper0.g(), null, null, new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowLayerPopup.1.1.1(((MainLayerPopupRes)object0), musicBrowserPopupHelper0, this.b, this.c, this.d, null), 3, null);
        }
    }
}

