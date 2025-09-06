package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.TwitterDisConnectRes;

public class TwitterDisconnectReq extends MemberBaseReq {
    public TwitterDisconnectReq(Context context0) {
        super(context0, 1, TwitterDisConnectRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/muid/mobile/sns/twitter_disconnect.json";
    }
}

