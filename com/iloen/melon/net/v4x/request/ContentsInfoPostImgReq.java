package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ContentsInfoPostImgRes;

public class ContentsInfoPostImgReq extends RequestV4Req {
    public ContentsInfoPostImgReq(Context context0, String s, String s1) {
        super(context0, 0, ContentsInfoPostImgRes.class, false);
        this.addParam("contsId", s);
        this.addParam("contsTypeCode", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/contents/infoPostImg.json";
    }
}

