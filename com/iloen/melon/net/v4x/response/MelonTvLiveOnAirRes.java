package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MelonTvLiveOnAirRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("ISONAIR")
        public boolean isOnAir;
        private static final long serialVersionUID = 0xE933ADBB096C291CL;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x2D09081065FFEC78L;

}

