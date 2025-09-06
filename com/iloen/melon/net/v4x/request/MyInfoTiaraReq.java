package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.response.MyInfoTiaraRes;
import e1.u;
import va.e0;
import va.o;

public class MyInfoTiaraReq extends HttpRequest {
    public MyInfoTiaraReq(Context context0) {
        super(context0, 0, MyInfoTiaraRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()));
        this.addParam("pocId", MelonAppBase.instance.getMelonCpId());
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.k;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/protocol/m6/my/info/tiara";
    }
}

