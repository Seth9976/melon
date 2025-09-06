package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class CheckConnectKakaoByAccessTokenRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
    }

    @b("response")
    public RESPONSE response;

    public CheckConnectKakaoByAccessTokenRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

