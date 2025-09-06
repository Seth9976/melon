package com.iloen.melon.utils.ui;

import H0.e;
import J8.h1;
import androidx.viewpager.widget.ViewPager;
import co.ab180.airbridge.Airbridge;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import ie.H;
import ie.m;
import je.D;
import td.b0;
import we.a;

public final class h implements a {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;

    public h(b0 b00, h1 h10, boolean z) {
        this.a = 3;
        super();
        this.c = b00;
        this.d = h10;
        this.b = z;
    }

    public h(boolean z, MusicBrowserPopupHelper musicBrowserPopupHelper0, BANNER floatingBannerRes$RESPONSE$BANNER0, int v) {
        this.a = v;
        this.b = z;
        this.c = musicBrowserPopupHelper0;
        this.d = floatingBannerRes$RESPONSE$BANNER0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                MusicBrowserPopupHelper musicBrowserPopupHelper0 = (MusicBrowserPopupHelper)this.c;
                BANNER floatingBannerRes$RESPONSE$BANNER0 = (BANNER)this.d;
                if(this.b) {
                    MusicBrowserPopupHelper.access$loginViewableLog(musicBrowserPopupHelper0);
                    return H.a;
                }
                MusicBrowserPopupHelper.access$bannerViewableLog(musicBrowserPopupHelper0, floatingBannerRes$RESPONSE$BANNER0);
                return H.a;
            }
            case 1: {
                MusicBrowserPopupHelper musicBrowserPopupHelper1 = (MusicBrowserPopupHelper)this.c;
                BANNER floatingBannerRes$RESPONSE$BANNER1 = (BANNER)this.d;
                if(this.b) {
                    musicBrowserPopupHelper1.j(floatingBannerRes$RESPONSE$BANNER1);
                }
                else {
                    MusicBrowserPopupHelper.access$trackFloatingBannerItemClick(musicBrowserPopupHelper1, floatingBannerRes$RESPONSE$BANNER1);
                }
                MelonLinkExecutor.open(MelonLinkInfo.b(floatingBannerRes$RESPONSE$BANNER1));
                String s = floatingBannerRes$RESPONSE$BANNER1.getBannerSeq();
                if(s == null) {
                    s = "";
                }
                Airbridge.trackEvent("", D.O(new m("action", s)), D.O(new m("", s)));
                musicBrowserPopupHelper1.b(floatingBannerRes$RESPONSE$BANNER1);
                return H.a;
            }
            case 2: {
                MusicBrowserPopupHelper musicBrowserPopupHelper2 = (MusicBrowserPopupHelper)this.c;
                BANNER floatingBannerRes$RESPONSE$BANNER2 = (BANNER)this.d;
                if(this.b) {
                    musicBrowserPopupHelper2.k(floatingBannerRes$RESPONSE$BANNER2);
                }
                else {
                    MusicBrowserPopupHelper.access$trackFloatingBannerCloseClick(musicBrowserPopupHelper2, floatingBannerRes$RESPONSE$BANNER2);
                }
                musicBrowserPopupHelper2.b(floatingBannerRes$RESPONSE$BANNER2);
                return H.a;
            }
            default: {
                h1 h10 = (h1)this.d;
                if(e.N(((b0)this.c))) {
                    int v = 0;
                    h10.c.setVisibility(0);
                    ViewPager viewPager0 = h10.d;
                    if(!this.b) {
                        v = 4;
                    }
                    viewPager0.setVisibility(v);
                }
                return H.a;
            }
        }
    }
}

