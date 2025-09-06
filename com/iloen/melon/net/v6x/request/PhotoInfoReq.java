package com.iloen.melon.net.v6x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v6x.response.PhotoInfoRes;

public class PhotoInfoReq extends RequestV6_1Req {
    public PhotoInfoReq(Context context0, String s, String s1, int v) {
        super(context0, 0, PhotoInfoRes.class, false);
        this.addParam("photoId", s);
        if(!TextUtils.isEmpty(s1)) {
            this.addParam("artistId", s1);
        }
        if(v > 0) {
            this.addParam("idCount", String.valueOf(v));
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/photo/info.json";
    }
}

