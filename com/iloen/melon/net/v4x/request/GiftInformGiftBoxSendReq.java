package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftInformGiftBoxSendRes;
import com.iloen.melon.net.v5x.request.RequestV5Req;

public class GiftInformGiftBoxSendReq extends RequestV5Req {
    public GiftInformGiftBoxSendReq(Context context0, String s, String s1) {
        super(context0, 0, GiftInformGiftBoxSendRes.class);
        this.addMemberKey(s);
        this.addParam("giftNo", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/informGiftBoxSend.json";
    }
}

