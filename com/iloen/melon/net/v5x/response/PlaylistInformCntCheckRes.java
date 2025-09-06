package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class PlaylistInformCntCheckRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("CNTOVERYN")
        public String cntOverYn;
        private static final long serialVersionUID = 0xE0293F603454DBACL;

        public RESPONSE() {
            this.cntOverYn = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2F8682F69466DBD3L;

    public PlaylistInformCntCheckRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

