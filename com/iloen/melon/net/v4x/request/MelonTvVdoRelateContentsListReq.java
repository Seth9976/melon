package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateContentsListRes;

public class MelonTvVdoRelateContentsListReq extends RequestV4Req {
    private boolean isLive;

    public MelonTvVdoRelateContentsListReq(Context context0, String s, boolean z) {
        super(context0, 0, MelonTvVdoRelateContentsListRes.class);
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
        return "/melontv/vdo/relateContentsList.json";
    }
}

