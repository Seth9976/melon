package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.PostKakaoBadgeRes;

public class PostKakaoBadgeReq extends RequestV4Req {
    public PostKakaoBadgeReq(Context context0, String s, String s1) {
        super(context0, 1, PostKakaoBadgeRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParam("contsTypeCode", s);
        this.addParam("contsId", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/kakao/postKakaoBadge.json";
    }
}

