package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjBrandDetailDjplaylistListRes;

public class DjBrandDetailDjplaylistListReq extends RequestV6_1Req {
    public static class ParamInfo {
        public int pageSize;
        public int startIndex;

    }

    public DjBrandDetailDjplaylistListReq(Context context0, ParamInfo djBrandDetailDjplaylistListReq$ParamInfo0, String s) {
        super(context0, 0, DjBrandDetailDjplaylistListRes.class, false);
        this.addParams(djBrandDetailDjplaylistListReq$ParamInfo0);
        this.addParam("brandDjKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brandDetail/djplaylist/list.json";
    }
}

