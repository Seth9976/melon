package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class PhotoCountInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("LIKECNT")
        public String likecnt;
        private static final long serialVersionUID = 0x8BF44D2EDFFF1B29L;
        @b("VIEWCNT")
        public String viewcnt;

        public RESPONSE() {
            this.viewcnt = "";
            this.likecnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5A47F1F7A826F625L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

