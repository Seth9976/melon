package com.iloen.melon.utils.ui;

import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON;
import ie.H;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class f implements a {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((MusicBrowserPopupHelper)object0).k(null);
                ((MusicBrowserPopupHelper)object0).l(false, true);
                BANON floatingBannerRes$RESPONSE$BANNER$BANON0 = new BANON();
                floatingBannerRes$RESPONSE$BANNER$BANON0.setSeq("FLOATING_SIMPLE_LOGIN");
                floatingBannerRes$RESPONSE$BANNER$BANON0.setExpiration(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                BuildersKt__Builders_commonKt.launch$default(((MusicBrowserPopupHelper)object0).g(), null, null, new MusicBrowserPopupHelper.closeFloatingSimpleLoginPopup.1(((MusicBrowserPopupHelper)object0), floatingBannerRes$RESPONSE$BANNER$BANON0, null), 3, null);
                return h0;
            }
            case 1: {
                ((MusicBrowserPopupHelper)object0).k = true;
                ((MusicBrowserPopupHelper)object0).i();
                return h0;
            }
            case 2: {
                ((MusicBrowserPopupHelper)object0).k = true;
                ((MusicBrowserPopupHelper)object0).i();
                return h0;
            }
            case 3: {
                MusicBrowserPopupHelper.access$loginViewableLog(((MusicBrowserPopupHelper)object0));
                return h0;
            }
            case 4: {
                ((MusicBrowserPopupHelper)object0).j(null);
                MusicBrowserPopupHelper.access$handleSimpleLogin(((MusicBrowserPopupHelper)object0));
                return h0;
            }
            case 5: {
                ((MusicBrowserPopupHelper)object0).j(null);
                MusicBrowserPopupHelper.access$handleSimpleLogin(((MusicBrowserPopupHelper)object0));
                return h0;
            }
            default: {
                if(((a)object0) != null) {
                    ((a)object0).invoke();
                }
                return h0;
            }
        }
    }
}

