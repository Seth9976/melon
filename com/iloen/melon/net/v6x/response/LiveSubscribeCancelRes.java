package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import org.jetbrains.annotations.NotNull;

public class LiveSubscribeCancelRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0xEBB18FE517E4533L;
        @b("SUBSCRIBEYN")
        public String subscribeYN;

        public RESPONSE() {
            this.subscribeYN = "N";
            this.message = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x33A815871EF676FDL;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

