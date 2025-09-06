package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SettingGnrBaseRes;

public class SettingGnrDeleteExcGnrReq extends RequestV4Req {
    public SettingGnrDeleteExcGnrReq(Context context0, String s) {
        super(context0, 0, SettingGnrBaseRes.class, true);
        this.addMemberKey();
        this.addParam("gnrCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/gnr/deleteExcGnr.json";
    }
}

