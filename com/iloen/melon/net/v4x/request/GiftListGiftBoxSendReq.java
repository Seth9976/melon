package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxSendRes;
import com.iloen.melon.net.v5x.request.RequestV5Req;

public class GiftListGiftBoxSendReq extends RequestV5Req {
    public GiftListGiftBoxSendReq(Context context0, String s, String s1) {
        super(context0, 0, GiftListGiftBoxSendRes.class);
        this.addMemberKey();
        this.addParam("lastIndexKey", s);
        this.addParam("pageSize", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/listGiftBoxSend.json";
    }
}

