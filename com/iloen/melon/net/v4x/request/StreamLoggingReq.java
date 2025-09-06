package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.response.StreamLoggingRes;

public class StreamLoggingReq extends PlayBaseReq {
    public static class ParamInfo {
        public String bitrate;
        public String cId;
        public String cType;
        public int currentVolume;
        public boolean isLiveContent;
        public String locPl;
        public String loggingToken;
        public String menuId;
        public String metaType;
        public String mwYn;
        public String networkType;
        public int rt;

    }

    public StreamLoggingReq(Context context0, ParamInfo streamLoggingReq$ParamInfo0) {
        super(context0, 0, StreamLoggingRes.class);
        this.setup(streamLoggingReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/delivery/android/streaming_logging.json";
    }

    private void setup(ParamInfo streamLoggingReq$ParamInfo0) {
        this.addParam("cId", streamLoggingReq$ParamInfo0.cId);
        this.addParam("cType", streamLoggingReq$ParamInfo0.cType);
        this.addParam("menuId", streamLoggingReq$ParamInfo0.menuId);
        this.addParam("bitrate", streamLoggingReq$ParamInfo0.bitrate);
        this.addParam("metaType", streamLoggingReq$ParamInfo0.metaType);
        this.addParam("locPl", streamLoggingReq$ParamInfo0.locPl);
        this.addParam("loggingToken", streamLoggingReq$ParamInfo0.loggingToken);
        this.addParam("networkType", streamLoggingReq$ParamInfo0.networkType);
        this.addParam("volume", String.valueOf(streamLoggingReq$ParamInfo0.currentVolume));
        if(!TextUtils.isEmpty(streamLoggingReq$ParamInfo0.mwYn)) {
            this.addParam("mwYn", streamLoggingReq$ParamInfo0.mwYn);
        }
        int v = streamLoggingReq$ParamInfo0.rt;
        if(v > 0) {
            this.addParam("rt", String.valueOf(v));
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

