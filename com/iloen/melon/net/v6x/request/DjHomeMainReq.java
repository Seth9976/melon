package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjHomeMainRes;

public class DjHomeMainReq extends RequestV6_2Req {
    public DjHomeMainReq(Context context0) {
        super(context0, 0, DjHomeMainRes.class, true);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/home/main.json";
    }
}

