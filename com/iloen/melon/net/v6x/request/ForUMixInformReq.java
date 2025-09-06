package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForUMixInformRes;
import com.iloen.melon.utils.system.AppUtils;

public class ForUMixInformReq extends RequestV6_3Req {
    public static class Params {
        public String contsId;
        public String seedContsId;
        public String seedContsTypeCode;

    }

    public ForUMixInformReq(Context context0, Params forUMixInformReq$Params0) {
        super(context0, 0, ForUMixInformRes.class);
        this.addMemberKey();
        this.addParams(forUMixInformReq$Params0);
        this.addParam("appVer", AppUtils.getVersionName(context0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/mix/inform.json";
    }
}

