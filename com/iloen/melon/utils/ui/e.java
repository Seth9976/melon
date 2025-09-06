package com.iloen.melon.utils.ui;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v6x.response.FloatingBannerRes;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class e implements Listener {
    public final MusicBrowserPopupHelper a;
    public final String b;
    public final String c;

    public e(MusicBrowserPopupHelper musicBrowserPopupHelper0, String s, String s1) {
        this.a = musicBrowserPopupHelper0;
        this.b = s;
        this.c = s1;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.a;
        if(musicBrowserPopupHelper0.getActivity() == null) {
            return;
        }
        if(object0 instanceof FloatingBannerRes && ((FloatingBannerRes)object0).isSuccessful(false)) {
            BuildersKt__Builders_commonKt.launch$default(musicBrowserPopupHelper0.g(), null, null, new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1.2.1(object0, musicBrowserPopupHelper0, this.b, this.c, null), 3, null);
            return;
        }
        musicBrowserPopupHelper0.l(false, true);
    }
}

