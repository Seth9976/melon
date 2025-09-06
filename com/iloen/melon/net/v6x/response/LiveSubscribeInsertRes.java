package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import org.jetbrains.annotations.NotNull;

public class LiveSubscribeInsertRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0x920AB8A51F8F73EDL;
        @b("SUBSCRIBEYN")
        public String subscribeYN;

        public RESPONSE() {
            this.subscribeYN = "N";
            this.message = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xAAE298AEAA8340EDL;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

