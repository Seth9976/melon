package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ProgramHomeRes;

public class ProgramHomeReq extends RequestV6Req {
    public ProgramHomeReq(Context context0, String s) {
        super(context0, 0, ProgramHomeRes.class);
        this.addParam("progSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/program/detail.json";
    }
}

