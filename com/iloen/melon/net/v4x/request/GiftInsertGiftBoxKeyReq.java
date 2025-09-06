package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftInsertGiftBoxKeyRes;

public class GiftInsertGiftBoxKeyReq extends RequestV4Req {
    public GiftInsertGiftBoxKeyReq(Context context0, String s) {
        super(context0, 0, GiftInsertGiftBoxKeyRes.class);
        this.addMemberKey();
        this.addParam("giftAuthKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/insertGiftBoxKey.json";
    }
}

