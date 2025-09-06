package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DcfExtensionLoggingRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        @b("DEDUCTFAILCNT")
        public int deductfailcnt;
        @b("DEDUCTSUCCNT")
        public int deductsuccnt;
        @b("DEDUCTTOTCNT")
        public int deducttotcnt;
        @b("DLCO")
        public int dlco;
        @b("DLLIMITCNT")
        public int dllimitcnt;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

