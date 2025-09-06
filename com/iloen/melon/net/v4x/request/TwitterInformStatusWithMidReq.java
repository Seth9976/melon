package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.TwitterInformStatusWithMidRes;

public class TwitterInformStatusWithMidReq extends MemberBaseReq {
    public TwitterInformStatusWithMidReq(Context context0) {
        super(context0, 1, TwitterInformStatusWithMidRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/muid/mobile/sns/twitter_informStatusWithMId.json";
    }
}

