package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ForUListWelcomePickCodeRes;

public class ForUListWelcomePickCodeReq extends RequestV5_1Req {
    public ForUListWelcomePickCodeReq(Context context0) {
        super(context0, 0, ForUListWelcomePickCodeRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/listWelcomePickCode.json";
    }
}

