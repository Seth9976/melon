package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.AuthMsgContentRes;

public class AuthMsgContentReq extends RequestV4Req {
    public AuthMsgContentReq(Context context0, String s) {
        super(context0, 1, AuthMsgContentRes.class);
        this.addParam("messageCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/support/authMsgContent.json";
    }
}

