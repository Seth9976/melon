package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.PostSongKakaoBadgeRes;

public class PostSongKakaoBadgeReq extends RequestV4Req {
    public PostSongKakaoBadgeReq(Context context0, String s, String s1, String s2) {
        super(context0, 1, PostSongKakaoBadgeRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParam("contsTypeCode", s);
        this.addParam("contsId", s1);
        this.addParam("menuId", s2);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/kakao/postKakaoBadge.json";
    }
}

