package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SideMenuListRes;

public class SideMenuListReq extends RequestV6Req {
    public SideMenuListReq(Context context0) {
        super(context0, 0, SideMenuListRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/sidemenu/list.json";
    }
}

