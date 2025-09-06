package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class SongLyricUpdtMsgCheckRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x714300ECB2713605L;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7142FD48ABDB6B05L;

    public SongLyricUpdtMsgCheckRes() {
        this.response = null;
    }
}

