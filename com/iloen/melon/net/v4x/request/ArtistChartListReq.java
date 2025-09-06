package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ArtistChartListRes;

public class ArtistChartListReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public String searchType;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 50;
            this.searchType = "";
        }
    }

    public ArtistChartListReq(Context context0, Params artistChartListReq$Params0) {
        super(context0, 0, ArtistChartListRes.class);
        this.addParams(artistChartListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/artist/artistChartList.json";
    }
}

