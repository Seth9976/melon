package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class GetWebLyricRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("CID")
        public String cid;
        @b("CTYPE")
        public String ctype;
        @b("LYRIC")
        public String lyric;
        private static final long serialVersionUID = 0xAFEC0F6CC874364FL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3F5D62E37BA39BEBL;

    public GetWebLyricRes() {
        this.response = null;
    }

    public String getLyric() {
        return this.response == null ? null : this.response.lyric;
    }
}

