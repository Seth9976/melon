package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastDetailRes;

@Deprecated
public class CastDetailReq extends RequestV5Req {
    public CastDetailReq(Context context0, String s) {
        super(context0, 0, CastDetailRes.class);
        this.addParam("castSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/detail.json";
    }
}

