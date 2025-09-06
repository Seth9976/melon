package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.UserInfoAgreeRes;

public class UserInfoAgreeReq extends PersonalBaseReq {
    public UserInfoAgreeReq(Context context0) {
        super(context0, 0, UserInfoAgreeRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/v2/user/info/agree.json";
    }
}

