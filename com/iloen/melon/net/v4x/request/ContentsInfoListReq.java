package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ContentsInfoListRes;

public class ContentsInfoListReq extends RequestV4Req {
    public ContentsInfoListReq(Context context0, String s, String s1) {
        super(context0, 1, ContentsInfoListRes.class);
        this.addMemberKey();
        this.addParam("contsIds", s1);
        this.addParam("contsType", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/contents/infoList.json";
    }
}

