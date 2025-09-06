package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.OauthUserMeRes;

public class OauthUserMeReq extends MemberBaseReq {
    public OauthUserMeReq(Context context0) {
        super(context0, 0, OauthUserMeRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/s/oauth/user/me";
    }
}

