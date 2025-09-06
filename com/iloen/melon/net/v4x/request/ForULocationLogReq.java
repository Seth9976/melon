package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v4x.response.ForULocationLogRes;

public class ForULocationLogReq extends RequestV4Req {
    public ForULocationLogReq(Context context0, String s, String s1) {
        super(context0, 0, ForULocationLogRes.class, true);
        this.addMemberKey();
        this.addParam("latitude", s);
        this.addParam("longitude", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.a;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/foru/locationLog.json";
    }
}

