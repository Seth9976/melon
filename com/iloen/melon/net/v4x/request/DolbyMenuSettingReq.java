package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DolbyMenuSettingRes;

public class DolbyMenuSettingReq extends RequestV4Req {
    public DolbyMenuSettingReq(Context context0) {
        super(context0, 0, DolbyMenuSettingRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dolbymenu/setting.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

