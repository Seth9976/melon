package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes;

public class CastProgramDetailReq extends RequestV5Req {
    public CastProgramDetailReq(Context context0, String s) {
        super(context0, 0, CastProgramDetailRes.class);
        this.addParam("progSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/program/detail.json";
    }
}

