package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjApplyInsertRes;

public class DjApplyInsertReq extends RequestV4Req {
    public DjApplyInsertReq(Context context0) {
        super(context0, 1, DjApplyInsertRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/apply/insert.json";
    }
}

