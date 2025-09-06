package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjThemeListPlystSearchRes;

public class DjThemeListPlystSearchReq extends RequestV4Req {
    public static class Params {
        public String keyword;
        public String lastIndexKey;
        public String orderBy;
        public String pageSize;
        public String searchType;

    }

    public DjThemeListPlystSearchReq(Context context0, Params djThemeListPlystSearchReq$Params0) {
        super(context0, 0, DjThemeListPlystSearchRes.class, false);
        this.addParams(djThemeListPlystSearchReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/theme/listPlylstSearch.json";
    }
}

