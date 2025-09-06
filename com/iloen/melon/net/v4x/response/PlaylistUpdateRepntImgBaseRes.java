package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class PlaylistUpdateRepntImgBaseRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("REPNTIMG")
        public String repntImg;
        private static final long serialVersionUID = 0x52BC44553EC9FE38L;
        @b("SLEEPTIME")
        public int sleepTime;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xAA5AAE914BF00930L;

    public PlaylistUpdateRepntImgBaseRes() {
        this.response = null;
    }
}

