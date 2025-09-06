package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.BotExampleKeywordsRes;

public class BotExampleKeywordsReq extends RequestV4Req {
    public BotExampleKeywordsReq(Context context0) {
        super(context0, 1, BotExampleKeywordsRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/bot/exampleKeywords.json";
    }
}

