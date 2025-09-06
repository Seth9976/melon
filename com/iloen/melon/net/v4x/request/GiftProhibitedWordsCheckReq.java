package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftProhibitedWordsCheckRes;

public class GiftProhibitedWordsCheckReq extends RequestV4Req {
    public GiftProhibitedWordsCheckReq(Context context0, String s) {
        super(context0, 1, GiftProhibitedWordsCheckRes.class);
        this.addMemberKey();
        this.addParam("checkMsg", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/prohibitedWordsCheck.json";
    }
}

