package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicLikeInformContentsLikeRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("CONTSID")
        public String contsid;
        @b("LIKEYN")
        public String likeyn;
        private static final long serialVersionUID = 0xA5A0C0A9B26E626L;
        @b("SUMMCNT")
        public String summcnt;

        public RESPONSE() {
            this.contsid = "";
            this.likeyn = "";
            this.summcnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x9E059F0D13C2431EL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

