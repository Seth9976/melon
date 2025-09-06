package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DolbyMenuSettingRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("isDolbyMenu")
        public String isDolbyMenu;
        private static final long serialVersionUID = 0x6257498129F110F0L;

        public RESPONSE() {
            this.isDolbyMenu = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2AD28B64B51324CFL;

    public DolbyMenuSettingRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

