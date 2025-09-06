package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.PowerDjListRes;

public class PowerDjListReq extends RequestV6_1Req {
    public static class Params {
        public String mode;
        public int pageSize;
        public String sortBy;
        public int startIndex;

    }

    public static int PAGE_SIZE = 100;

    public PowerDjListReq(Context context0, Params powerDjListReq$Params0) {
        super(context0, 0, PowerDjListRes.class);
        this.addMemberKey();
        this.addParams(powerDjListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/powerdj/list.json";
    }
}

