package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.BotInsertFeedbackRes;

public class BotInsertFeedbackReq extends RequestV4Req {
    public static class Params {
        public String contsTypeCode;
        public String entity;
        public String feedbackId;
        public String indexKey;
        public String liked;
        public String memberKey;

    }

    public BotInsertFeedbackReq(Context context0, Params botInsertFeedbackReq$Params0) {
        super(context0, 1, BotInsertFeedbackRes.class);
        this.addParams(botInsertFeedbackReq$Params0);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/bot/insertFeedback.json";
    }
}

