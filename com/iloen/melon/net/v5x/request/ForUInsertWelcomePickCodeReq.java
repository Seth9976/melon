package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ForUInsertWelcomePickCodeRes;

public class ForUInsertWelcomePickCodeReq extends RequestV5_1Req {
    public static class Params {
        public String welcomePickCode1;
        public String welcomePickCode2;
        public String welcomePickCode3;

    }

    public ForUInsertWelcomePickCodeReq(Context context0, Params forUInsertWelcomePickCodeReq$Params0) {
        super(context0, 0, ForUInsertWelcomePickCodeRes.class);
        this.addMemberKey();
        this.addParams(forUInsertWelcomePickCodeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/insertWelcomePickCode.json";
    }
}

