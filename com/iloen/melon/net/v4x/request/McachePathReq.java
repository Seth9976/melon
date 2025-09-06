package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.McachePathRes;

public class McachePathReq extends PlayBaseReq {
    public static class Params {
        public String bitrate;
        public String cType;
        public String cid;
        public String metaType;

    }

    public McachePathReq(Context context0, Params mcachePathReq$Params0) {
        super(context0, 0, McachePathRes.class);
        this.addParams(mcachePathReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/delivery/android/mcache_path.json";
    }
}

