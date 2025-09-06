package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DownloadInfoRes;

public class DownloadInfoReq extends PlayBaseReq {
    public static class ParamInfo {
        public String bitrate;
        public String cType;
        public String cid;
        public String drm;
        public String product;

    }

    public DownloadInfoReq(Context context0, ParamInfo downloadInfoReq$ParamInfo0) {
        super(context0, 1, DownloadInfoRes.class);
        this.addParam("cId", downloadInfoReq$ParamInfo0.cid);
        this.addParam("cType", downloadInfoReq$ParamInfo0.cType);
        this.addParam("bitrate", downloadInfoReq$ParamInfo0.bitrate);
        this.addParam("product", downloadInfoReq$ParamInfo0.product);
        this.addParam("drm", downloadInfoReq$ParamInfo0.drm);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/delivery/android/download_info.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

