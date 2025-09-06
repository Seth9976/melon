package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvVdoInformRes;

public class MelonTvVdoInformReq extends RequestV4Req {
    public static class Params {
        public boolean isLive;
        public String mvId;

    }

    private boolean isLive;

    public MelonTvVdoInformReq(Context context0, Params melonTvVdoInformReq$Params0) {
        super(context0, 0, MelonTvVdoInformRes.class);
        this.isLive = melonTvVdoInformReq$Params0.isLive;
        this.addParams(melonTvVdoInformReq$Params0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return this.isLive ? M.h : M.g;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/vdo/inform.json";
    }
}

