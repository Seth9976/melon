package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjApplyMainRes;

public class DjApplyMainReq extends RequestV4Req {
    public static final String PAGE_TYPE_MAIN = "main";
    public static final String PAGE_TYPE_TERMS = "terms";
    private static final String PARAM_KEY_PAGE_TYPE = "pageType";

    public DjApplyMainReq(Context context0, String s, String s1) {
        super(context0, 0, DjApplyMainRes.class);
        this.addParam("pageType", s1);
        this.addMemberKey(s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/apply/main.json";
    }
}

