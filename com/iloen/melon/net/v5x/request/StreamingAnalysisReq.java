package com.iloen.melon.net.v5x.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.iloen.melon.net.v5x.response.StreamingAnalysisRes;
import java.lang.reflect.Type;
import java.util.Map;

public class StreamingAnalysisReq extends PlayBaseReq {
    public static class ParamInfo {
        public String bitrate;
        public String cId;
        public String cType;
        public int currentVolume;
        public String freeYn;
        public String initDate;
        public String locPl;
        public String loggingToken;
        public String menuId;
        public String metaType;
        public String networkType;
        public String orgMenuId;
        public String statsElement;

    }

    private static final String TAG = "StreamingAnalysisReq";

    public StreamingAnalysisReq(Context context0, ParamInfo streamingAnalysisReq$ParamInfo0) {
        super(context0, 1, StreamingAnalysisRes.class);
        this.setup(streamingAnalysisReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/delivery/analysis/streaming_analysis.json";
    }

    private void setup(ParamInfo streamingAnalysisReq$ParamInfo0) {
        Map map0;
        this.addParam("cId", streamingAnalysisReq$ParamInfo0.cId);
        this.addParam("cType", streamingAnalysisReq$ParamInfo0.cType);
        this.addParam("menuId", streamingAnalysisReq$ParamInfo0.menuId);
        this.addParam("orgMenuId", streamingAnalysisReq$ParamInfo0.orgMenuId);
        this.addParam("bitrate", streamingAnalysisReq$ParamInfo0.bitrate);
        this.addParam("metaType", streamingAnalysisReq$ParamInfo0.metaType);
        this.addParam("loggingToken", streamingAnalysisReq$ParamInfo0.loggingToken);
        this.addParam("locPl", streamingAnalysisReq$ParamInfo0.locPl);
        this.addParam("initDate", streamingAnalysisReq$ParamInfo0.initDate);
        this.addParam("freeYn", streamingAnalysisReq$ParamInfo0.freeYn);
        this.addParam("networkType", streamingAnalysisReq$ParamInfo0.networkType);
        this.addParam("volume", String.valueOf(streamingAnalysisReq$ParamInfo0.currentVolume));
        if(TextUtils.isEmpty(streamingAnalysisReq$ParamInfo0.statsElement)) {
            map0 = null;
        }
        else {
            n n0 = new n();
            Type type0 = new TypeToken() {
            }.getType();
            map0 = (Map)n0.f(streamingAnalysisReq$ParamInfo0.statsElement, type0);
        }
        if(map0 != null && !map0.isEmpty()) {
            for(Object object0: map0.keySet()) {
                String s = (String)object0;
                String s1 = (String)map0.get(s);
                if(!TextUtils.isEmpty(s1)) {
                    this.addParam(s, s1);
                }
            }
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

