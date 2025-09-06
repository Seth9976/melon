package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequestV6;
import com.iloen.melon.net.v6x.response.ChartStreamingCardUploadRes;

public class ChartStreamingCardUploadReq extends MultipartHttpRequestV6 {
    public static class Params {
        public String artistName;
        public String ref;
        public String sId;
        public String songName;
        public String type;

    }

    public ChartStreamingCardUploadReq(Context context0, Params chartStreamingCardUploadReq$Params0) {
        super(context0, ChartStreamingCardUploadRes.class);
        this.addMemberKey();
        this.addParams(chartStreamingCardUploadReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/streaming/card/upload.json";
    }
}

