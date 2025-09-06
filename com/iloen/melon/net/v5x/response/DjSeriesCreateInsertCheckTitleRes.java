package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DjSeriesCreateInsertCheckTitleRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("PLYLSTTITLE")
        public String playlistTitle;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E90836ADL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

