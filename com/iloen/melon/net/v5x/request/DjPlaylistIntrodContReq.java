package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjPlaylistIntrodContRes;

public class DjPlaylistIntrodContReq extends RequestV5Req {
    public static class Params {
        public String mode;
        public String plylstSeq;
        public String plylstTypeCode;

    }

    public DjPlaylistIntrodContReq(Context context0, Params djPlaylistIntrodContReq$Params0) {
        super(context0, 0, DjPlaylistIntrodContRes.class, false);
        this.addParams(djPlaylistIntrodContReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/introdCont.json";
    }
}

