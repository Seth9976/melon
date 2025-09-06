package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.net.RequestBuilder.Params;
import com.iloen.melon.net.v4x.response.OffPlayLoggingRes;
import com.iloen.melon.utils.cipher.MelonCryptoManager;

public class OffPlayLoggingReq extends RequestV4Req {
    public static class ParamInfo {
        public String bInfo;
        public String bitrate;
        public String cId;
        public String cType;
        public String freeYn;
        public String hwkey;
        public String memberKey;
        public String metaType;
        public String pstime;
        public String sendTime;

    }

    private static final String ENCRYPTION_KEY = "p";
    private static final String TAG = "OffPlayLoggingReq";
    private int loggingCount;

    public OffPlayLoggingReq(Context context0, ParamInfo offPlayLoggingReq$ParamInfo0, int v) {
        super(context0, 1, OffPlayLoggingRes.class);
        this.loggingCount = v;
        this.addParams(offPlayLoggingReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.f;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/delivery/offplay_logging.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public Params params() {
        String s1;
        Params requestBuilder$Params0 = super.params();
        String s = new n().k(requestBuilder$Params0);
        new Params();
        Params requestBuilder$Params1 = Params.newInstance();
        try {
            s1 = null;
            s1 = MelonCryptoManager.encodeBuyInfo(s);
        }
        catch(Exception unused_ex) {
        }
        requestBuilder$Params1.put("p", s1);
        return requestBuilder$Params1;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String url() {
        String s = super.url();
        return s + (s.contains("?") ? "&" : "?") + "_c=" + this.loggingCount;
    }
}

