package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsMvRes;

public class ArtistContentsVideoListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String filterBy;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public static final String FILTER_ALL = "A";
    public static final String FILTER_BO = "BO";
    public static final String FILTER_MV = "M";
    public static final String ORDER_NEW = "NEW";
    public static final String ORDER_POP = "POP";

    public ArtistContentsVideoListReq(Context context0, Params artistContentsVideoListReq$Params0) {
        super(context0, 0, DetailContentsMvRes.class);
        this.addParams(artistContentsVideoListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/videoList.json";
    }
}

