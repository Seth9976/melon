package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes;

public class GenreLabelDetailReq extends RequestV5Req {
    public GenreLabelDetailReq(Context context0, String s) {
        super(context0, 0, GenreLabelDetailRes.class, true);
        this.addParam("labelSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/label/detail.json";
    }
}

