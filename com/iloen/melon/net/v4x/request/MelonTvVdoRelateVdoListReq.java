package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes;

public class MelonTvVdoRelateVdoListReq extends RequestV4Req {
    private boolean isLive;

    public MelonTvVdoRelateVdoListReq(Context context0, String s, boolean z) {
        super(context0, 0, MelonTvVdoRelateVdoListRes.class);
        this.isLive = z;
        this.addParam("mvId", s);
    }

    public MelonTvVdoRelateVdoListReq(String s, boolean z) {
        super(0, MelonTvVdoRelateVdoListRes.class);
        this.isLive = z;
        this.addParam("mvId", s);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return this.isLive ? M.h : M.g;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/vdo/relateVdoList.json";
    }
}

