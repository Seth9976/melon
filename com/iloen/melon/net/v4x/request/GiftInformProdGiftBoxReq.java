package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftInformProdGiftBoxRes;

public class GiftInformProdGiftBoxReq extends RequestV4Req {
    public GiftInformProdGiftBoxReq(Context context0, String s) {
        super(context0, 0, GiftInformProdGiftBoxRes.class);
        this.addMemberKey();
        this.addParam("prodId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/informProdGiftBox.json";
    }
}

