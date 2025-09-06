package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.PurchaseButtonRes;
import e1.u;
import va.e0;
import va.o;

public class PurchaseButtonReq extends RequestV4Req {
    public PurchaseButtonReq(Context context0) {
        super(context0, 0, PurchaseButtonRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()));
        this.addParam("tab", "ANDGNBICON");
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return "https://nullcommerce.melon.com";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/protocol/m6/banner/icon";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

