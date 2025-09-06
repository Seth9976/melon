package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartThemeListRes;

public class ChartThemeListReq extends RequestV6Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
        }
    }

    public ChartThemeListReq(Context context0, Params chartThemeListReq$Params0) {
        super(context0, 0, ChartThemeListRes.class, true);
        this.addParams(chartThemeListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/theme/list.json";
    }
}

