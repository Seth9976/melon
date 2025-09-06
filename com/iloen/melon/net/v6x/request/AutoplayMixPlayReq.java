package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AutoplayMixPlayRes;
import e1.u;
import va.e0;
import va.o;

public class AutoplayMixPlayReq extends RequestV6Req {
    public static class Params {
        public String contsId;
        public String menuId;
        public String seedContsId;
        public String seedContsTypeCode;

        public Params(String s, String s1, String s2, String s3) {
            this.contsId = s;
            this.seedContsTypeCode = s1;
            this.seedContsId = s2;
            this.menuId = s3;
        }
    }

    public AutoplayMixPlayReq(Context context0, Params autoplayMixPlayReq$Params0) {
        super(context0, 0, AutoplayMixPlayRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(autoplayMixPlayReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/autoplay/mix/play.json";
    }
}

