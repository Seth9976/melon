package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ResponseV5Res;

public class LaboratoryPreListenEditStatusReq extends RequestV5Req {
    private static final String OFF = "off";
    private static final String ON = "on";

    public LaboratoryPreListenEditStatusReq(Context context0, boolean z) {
        super(context0, 0, ResponseV5Res.class);
        this.addParam("status", (z ? "on" : "off"));
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/laboratory/preListenEditStatus.json";
    }
}

