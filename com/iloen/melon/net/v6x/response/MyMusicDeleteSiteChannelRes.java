package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class MyMusicDeleteSiteChannelRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 6835833670030509064L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x786F350D0499E12EL;

    public MyMusicDeleteSiteChannelRes() {
        this.response = null;
    }
}

