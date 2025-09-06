package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicLikeDeleteLikeRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0xDED08A21467E3EEDL;
        @b("SUMMCNT")
        public String summcnt;

        public RESPONSE() {
            this.summcnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1F8743B2667AECF1L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

