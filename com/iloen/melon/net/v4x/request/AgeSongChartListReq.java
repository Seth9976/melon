package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.AgeSongChartListRes;

public class AgeSongChartListReq extends RequestV4Req {
    public static class Params {
        public String genre;
        public String isRecom;
        public int pageSize;
        public int startIndex;
        public String type;
        public String year;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
            this.isRecom = "Y";
            this.genre = "KPOP";
            this.year = "";
            this.type = "";
        }
    }

    public static final String GENRE_KPOP = "KPOP";
    public static final String GENRE_POP = "POP";
    public static final String TYPE_AG = "AG";
    public static final String TYPE_YE = "YE";

    public AgeSongChartListReq(Context context0, Params ageSongChartListReq$Params0) {
        super(context0, 0, AgeSongChartListRes.class, false);
        this.addParams(ageSongChartListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/age/songChartList.json";
    }
}

