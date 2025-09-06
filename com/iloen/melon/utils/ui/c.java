package com.iloen.melon.utils.ui;

import androidx.fragment.app.l0;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.ui.popup.b;
import ie.H;
import we.a;

public final class c implements a {
    public final int a;
    public final Object b;
    public final MusicBrowserPopupHelper c;

    public c(MusicBrowserActivity musicBrowserActivity0, MusicBrowserPopupHelper musicBrowserPopupHelper0, int v) {
        this.a = v;
        this.b = musicBrowserActivity0;
        this.c = musicBrowserPopupHelper0;
        super();
    }

    public c(MusicBrowserPopupHelper musicBrowserPopupHelper0, BANNER floatingBannerRes$RESPONSE$BANNER0) {
        this.a = 2;
        super();
        this.c = musicBrowserPopupHelper0;
        this.b = floatingBannerRes$RESPONSE$BANNER0;
    }

    @Override  // we.a
    public final Object invoke() {
        l0 l00 = null;
        H h0 = H.a;
        Object object0 = this.b;
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.c;
        switch(this.a) {
            case 0: {
                MelonSettingInfo.setUseMarketingPushAlert(false);
                MelonPrefs.getInstance().setBoolean("MarketingAcceptShown", true);
                if(((MusicBrowserActivity)object0) != null) {
                    l00 = ((MusicBrowserActivity)object0).getSupportFragmentManager();
                }
                b.p(((MusicBrowserActivity)object0), l00, false, new f(musicBrowserPopupHelper0, 1));
                return h0;
            }
            case 1: {
                MelonSettingInfo.setUsePushAndMarketingPushAlert(true);
                Td.b.a(((MusicBrowserActivity)object0));
                MelonPrefs.getInstance().setBoolean("MarketingAcceptShown", true);
                if(((MusicBrowserActivity)object0) != null) {
                    l00 = ((MusicBrowserActivity)object0).getSupportFragmentManager();
                }
                b.p(((MusicBrowserActivity)object0), l00, true, new f(musicBrowserPopupHelper0, 2));
                return h0;
            }
            default: {
                musicBrowserPopupHelper0.j(((BANNER)object0));
                Navigator.openLoginView(r8.f.f);
                musicBrowserPopupHelper0.b(((BANNER)object0));
                return h0;
            }
        }
    }
}

