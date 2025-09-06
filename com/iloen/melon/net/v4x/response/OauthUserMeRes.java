package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public class OauthUserMeRes extends ResponseV4Res {
    @b("id")
    public String id;
    @b("nickname")
    public String nickname;
    private static final long serialVersionUID = 0x48255463CD92A689L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

