package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.InfoCommerceAndBtnRes;

public class InfoCommerceAndBtnReq extends RequestV4Req {
    public InfoCommerceAndBtnReq(Context context0) {
        super(context0, 0, InfoCommerceAndBtnRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/personal/infoCommerceAndBtn.json";
    }
}

