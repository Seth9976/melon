package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjTagInformV5Res;

public class DjTagInformV5Req extends RequestV5Req {
    public DjTagInformV5Req(Context context0, String s) {
        super(context0, 0, DjTagInformV5Res.class, false);
        this.addParam("tagSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/tag/inform.json";
    }
}

