package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForUMixmakerKeywordPredictiveRes;

public class ForUMixmakerKeywordPredictiveReq extends RequestV6Req {
    public ForUMixmakerKeywordPredictiveReq(Context context0, String s) {
        super(context0, 0, ForUMixmakerKeywordPredictiveRes.class, false);
        this.addParamToValueEncoded("searchKeyword", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/mixmaker/keyword/predictive.json";
    }
}

