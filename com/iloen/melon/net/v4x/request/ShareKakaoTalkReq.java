package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ShareKakaoTalkRes;

public class ShareKakaoTalkReq extends RequestV4Req {
    public ShareKakaoTalkReq(Context context0, String s, String s1, String s2) {
        super(context0, 0, ShareKakaoTalkRes.class);
        this.addMemberKey();
        this.addParam("type", s);
        this.addParam("contsId", s1);
        this.addParam("phase", s2);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/sns/shareKakaoTalk.json";
    }
}

