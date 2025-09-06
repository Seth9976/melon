package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import com.melon.net.res.common.ResponseBase;

public class MyMusicLikeInsertLikeRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0xF2708FEDA7C95A0BL;
        @b("SUMMCNT")
        public String summcnt;

        public RESPONSE() {
            this.summcnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5BCE02C778940C07L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

