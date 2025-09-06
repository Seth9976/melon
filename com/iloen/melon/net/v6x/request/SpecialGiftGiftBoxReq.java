package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SpecialGiftGiftBoxRes;

public class SpecialGiftGiftBoxReq extends RequestV6_1Req {
    public SpecialGiftGiftBoxReq(Context context0) {
        super(context0, 0, SpecialGiftGiftBoxRes.class, true);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/specialgift/giftbox.json";
    }
}

