package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import org.jetbrains.annotations.NotNull;

public class LiveSubscribeRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0xAF094F0917A0E561L;
        @b("SUBSCRIBEYN")
        public String subscribeYN;

        public RESPONSE() {
            this.subscribeYN = "N";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -2209502233583949131L;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

