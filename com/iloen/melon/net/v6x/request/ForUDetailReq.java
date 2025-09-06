package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.ForUDetailRes;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import va.e0;
import va.o;

public class ForUDetailReq extends RequestV6_2Req {
    public static class Params {
        public String contsId;
        public String seedContsId;
        public String songIds;

    }

    public ForUDetailReq(Context context0, Params forUDetailReq$Params0) {
        super(context0, 0, ForUDetailRes.class);
        this.addParams(forUDetailReq$Params0);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParam("appVer", AppUtils.getVersionName(MelonAppBase.instance.getContext()));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/detail.json";
    }
}

