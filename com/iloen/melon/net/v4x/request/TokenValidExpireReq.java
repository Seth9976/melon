package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.TokenValidExpireRes;

public class TokenValidExpireReq extends MemberBaseReq {
    public TokenValidExpireReq(Context context0, String s, String s1) {
        super(context0, 1, TokenValidExpireRes.class);
        this.addParam("memberId", s);
        this.addParam("token", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/muid/mobile/common/tokenvalid_expire.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

