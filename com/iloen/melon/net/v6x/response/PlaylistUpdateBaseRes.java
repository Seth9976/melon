package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class PlaylistUpdateBaseRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x96E1B1415A683706L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 1546642477821090086L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

