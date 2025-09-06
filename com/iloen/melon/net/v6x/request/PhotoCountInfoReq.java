package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.PhotoCountInfoRes;

public class PhotoCountInfoReq extends RequestV6_1Req {
    public PhotoCountInfoReq(Context context0, String s) {
        super(context0, 1, PhotoCountInfoRes.class, false);
        this.addMemberKeyAlwaysDeliver();
        this.addParam("photoId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/photo/countInfo.json";
    }
}

