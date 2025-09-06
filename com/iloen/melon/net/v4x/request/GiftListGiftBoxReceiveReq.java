package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftListGiftBoxReceiveRes;
import com.iloen.melon.net.v5x.request.RequestV5Req;

public class GiftListGiftBoxReceiveReq extends RequestV5Req {
    public GiftListGiftBoxReceiveReq(Context context0, String s, String s1) {
        super(context0, 0, GiftListGiftBoxReceiveRes.class);
        this.addMemberKey();
        this.addParam("lastIndexKey", s);
        this.addParam("pageSize", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/listGiftBoxReceive.json";
    }
}

