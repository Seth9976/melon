package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjBrandRecommendArtistRes;

public class DjBrandRecommendArtistReq extends RequestV6_1Req {
    public static class Params {
        public String brandDjKey;
        public int pageSize;
        public int startIndex;

    }

    public DjBrandRecommendArtistReq(Context context0, Params djBrandRecommendArtistReq$Params0) {
        super(context0, 0, DjBrandRecommendArtistRes.class);
        this.addMemberKey();
        this.addParams(djBrandRecommendArtistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brandDetail/recmArtist/list.json";
    }
}

