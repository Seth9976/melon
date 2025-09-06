package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForUMixPlayRes;

public class ForUMixPlayReq extends RequestV6_2Req {
    public static class Params {
        public String contsId;
        public String menuId;
        public String seedContsId;
        public String seedContsTypeCode;

    }

    public ForUMixPlayReq(Context context0, Params forUMixPlayReq$Params0) {
        super(context0, 0, ForUMixPlayRes.class);
        this.addMemberKey();
        this.addParams(forUMixPlayReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/mix/play.json";
    }
}

