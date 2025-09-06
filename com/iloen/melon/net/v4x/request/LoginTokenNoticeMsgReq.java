package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.LoginTokenNoticeMsgRes;

public class LoginTokenNoticeMsgReq extends MemberBaseReq {
    public LoginTokenNoticeMsgReq(Context context0) {
        super(context0, 0, LoginTokenNoticeMsgRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/muid/mobile/login/login_tokenNoticeMsg.json";
    }
}

