package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ForUTorosBanFeedbackRes;

public class ForUTorosBanFeedbackReq extends RequestV5Req {
    public static class Params {
        public String impressionId;
        public String menuId;
        public String songId;

    }

    public ForUTorosBanFeedbackReq(Context context0, Params forUTorosBanFeedbackReq$Params0) {
        super(context0, 0, ForUTorosBanFeedbackRes.class);
        this.addMemberKey();
        this.addParams(forUTorosBanFeedbackReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/torosBanFeedback.json";
    }
}

