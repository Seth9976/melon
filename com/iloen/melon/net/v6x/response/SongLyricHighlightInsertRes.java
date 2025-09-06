package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class SongLyricHighlightInsertRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x6D7E8CF5204E74A1L;
        @b("STATUS")
        public String status;

        public RESPONSE() {
            this.status = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x87D36DB4F7CFF82L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

