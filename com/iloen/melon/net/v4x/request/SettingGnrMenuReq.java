package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SettingGnrMenuRes;

public class SettingGnrMenuReq extends RequestV4Req {
    public SettingGnrMenuReq(Context context0) {
        super(context0, 0, SettingGnrMenuRes.class, true);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/gnr/menu.json";
    }
}

