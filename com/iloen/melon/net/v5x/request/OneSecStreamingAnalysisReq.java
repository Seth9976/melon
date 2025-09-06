package com.iloen.melon.net.v5x.request;

import android.content.Context;

public class OneSecStreamingAnalysisReq extends StreamingAnalysisReq {
    private static final String TAG = "OneSecStreamingAnalysisReq";

    public OneSecStreamingAnalysisReq(Context context0, ParamInfo streamingAnalysisReq$ParamInfo0) {
        super(context0, streamingAnalysisReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.v5x.request.StreamingAnalysisReq
    public String getApiPath() {
        return "/cds/delivery/analysis/section/1/streaming_analysis.json";
    }
}

