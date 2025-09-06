package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ResponseV6Res;

public class DolbyAtmosSettingStatusReq extends RequestV6Req {
    private static final String OFF = "off";
    private static final String ON = "on";

    public DolbyAtmosSettingStatusReq(Context context0, boolean z) {
        super(context0, 0, ResponseV6Res.class);
        this.addMemberKey();
        this.addParam("status", (z ? "on" : "off"));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dolbyAtmos/settingStatus.json";
    }
}

