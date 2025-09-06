package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes;
import e1.u;
import va.e0;
import va.o;

public class SettingGnrListExcGnrReq extends RequestV4Req {
    public SettingGnrListExcGnrReq(Context context0) {
        super(context0, 0, SettingGnrListExcGnrRes.class, true);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/gnr/listExcGnr.json";
    }
}

