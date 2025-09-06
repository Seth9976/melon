package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreLabelIntroRes;

public class GenreLabelIntroReq extends RequestV5Req {
    public GenreLabelIntroReq(Context context0, String s) {
        super(context0, 0, GenreLabelIntroRes.class, true);
        this.addParam("labelSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/label/intro.json";
    }
}

