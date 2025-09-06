package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.TvProgramSimpleListRes;

public class TvProgramSimpleListReq extends RequestV6Req {
    public TvProgramSimpleListReq(Context context0, String s) {
        super(context0, 0, TvProgramSimpleListRes.class);
        this.addParam("menuSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/program/simple/list.json";
    }
}

