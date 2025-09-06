package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class AlbumSetGradeRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("PTCPNMPRCO")
        public String ptcPnmPrco;
        private static final long serialVersionUID = 0x489E23787BF2367AL;
        @b("TOTAVRGSCORE")
        public String totAvrgScore;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF424663266A6DA80L;

    public AlbumSetGradeRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

