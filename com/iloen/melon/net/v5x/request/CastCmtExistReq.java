package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastCmtExistRes;

@Deprecated
public class CastCmtExistReq extends RequestV5Req {
    private static final String TAG = "CastCmtExistReq";

    public CastCmtExistReq(Context context0, String s) {
        super(context0, 0, CastCmtExistRes.class);
        this.addParam("castSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/cmt/exist.json";
    }
}

