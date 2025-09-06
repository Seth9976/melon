package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftUseProdGiftRes;

public class GiftUseProdGiftReq extends RequestV4Req {
    public GiftUseProdGiftReq(Context context0, String s) {
        super(context0, 0, GiftUseProdGiftRes.class);
        this.addMemberKey();
        this.addParam("giftNo", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/useProdGift.json";
    }
}

