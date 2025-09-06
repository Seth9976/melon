package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastMemberDetailRes;

public class CastMemberDetailReq extends RequestV5Req {
    public static class Params {
        public String creatorId;

    }

    public CastMemberDetailReq(Context context0, Params castMemberDetailReq$Params0) {
        super(context0, 0, CastMemberDetailRes.class);
        this.addParams(castMemberDetailReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/member/detail.json";
    }
}

