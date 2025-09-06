package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjThemeListRecmTagRes;

public class DjThemeListRecmTagReq extends RequestV5Req {
    public DjThemeListRecmTagReq(Context context0, String s) {
        super(context0, 0, DjThemeListRecmTagRes.class, false);
        this.addParam("tagCnt", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/theme/listRecmTag.json";
    }
}

