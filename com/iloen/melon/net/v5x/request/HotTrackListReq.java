package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.HotTrackListRes;

public class HotTrackListReq extends RequestV5Req {
    public static class Params {
        public String genreCode;
        public String hotTrackCode;
        public String tagSeq;

        public Params() {
            this.hotTrackCode = "";
            this.genreCode = "";
            this.tagSeq = "";
        }
    }

    public HotTrackListReq(Context context0, Params hotTrackListReq$Params0) {
        super(context0, 0, HotTrackListRes.class);
        this.addParams(hotTrackListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/hottrack/list.json";
    }
}

