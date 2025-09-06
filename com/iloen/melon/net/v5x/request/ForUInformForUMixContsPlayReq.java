package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ForUInformForUMixContsPlayRes;

public class ForUInformForUMixContsPlayReq extends RequestV5Req {
    public static class Params {
        public String contsId;
        public String menuId;
        public String seedContsId;
        public String seedContsTypeCode;

    }

    public ForUInformForUMixContsPlayReq(Context context0, Params forUInformForUMixContsPlayReq$Params0) {
        super(context0, 0, ForUInformForUMixContsPlayRes.class);
        this.addMemberKey();
        this.addParams(forUInformForUMixContsPlayReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/informForUMixContsPlay.json";
    }
}

