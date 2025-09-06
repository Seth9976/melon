package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class SchemeWebViewUrlListRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ALLOWLIST")
        public ArrayList allowList;
        private static final long serialVersionUID = 0xD0F0209F670378FAL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x31054142115BBB03L;

    public SchemeWebViewUrlListRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

