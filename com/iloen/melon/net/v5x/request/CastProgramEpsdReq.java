package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes;

public class CastProgramEpsdReq extends RequestV5Req {
    public static class Params {
        public int pageSize;
        public String progSeq;
        public int startIndex;

    }

    public CastProgramEpsdReq(Context context0, Params castProgramEpsdReq$Params0) {
        super(context0, 0, CastProgramEpsdRes.class);
        this.addParams(castProgramEpsdReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/program/epsd.json";
    }
}

