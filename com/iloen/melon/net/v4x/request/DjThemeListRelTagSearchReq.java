package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjThemeListRelTagSearchRes;

public class DjThemeListRelTagSearchReq extends RequestV4Req {
    public static class Params {
        public String keyword;

    }

    public DjThemeListRelTagSearchReq(Context context0, Params djThemeListRelTagSearchReq$Params0) {
        super(context0, 0, DjThemeListRelTagSearchRes.class, false);
        this.addParams(djThemeListRelTagSearchReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/theme/listRelTagSearch.json";
    }
}

