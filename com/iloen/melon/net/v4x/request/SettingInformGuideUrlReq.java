package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SettingInformGuideUrlRes;

public class SettingInformGuideUrlReq extends RequestV4Req {
    public SettingInformGuideUrlReq(Context context0) {
        super(context0, 0, SettingInformGuideUrlRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/informGuideUrl.json";
    }
}

