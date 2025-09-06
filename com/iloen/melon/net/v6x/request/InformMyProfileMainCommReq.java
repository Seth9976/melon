package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.InformMyProfileRes;

public class InformMyProfileMainCommReq extends RequestV6_1Req {
    public InformMyProfileMainCommReq(Context context0) {
        super(context0, 0, InformMyProfileRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/main/comm/informMyProfile.json";
    }
}

