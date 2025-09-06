package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;

public class DjApplyRejectReq extends RequestV4Req {
    public static class Params {
        public String nomalChngYn;
        public String plylstSeq;

        public Params() {
            this.plylstSeq = "";
            this.nomalChngYn = "";
        }
    }

    public DjApplyRejectReq(Context context0, Params djApplyRejectReq$Params0) {
        super(context0, 1, HttpResponse.class);
        this.addMemberKey();
        this.addParams(djApplyRejectReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/apply/reject.json";
    }
}

