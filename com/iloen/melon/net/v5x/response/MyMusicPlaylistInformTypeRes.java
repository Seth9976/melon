package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicPlaylistInformTypeRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("ISDJ")
        public Boolean isDj;
        @b("PLYLSTTYPECODE")
        public String plylstTypeCode;
        private static final long serialVersionUID = 0x52686E14DDBE8816L;

        public RESPONSE() {
            this.isDj = Boolean.FALSE;
            this.plylstTypeCode = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7E06C83EBAF436ADL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

