package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreDetailRes;

public class GenreDetailReq extends RequestV5Req {
    public GenreDetailReq(Context context0, String s) {
        super(context0, 0, GenreDetailRes.class, true);
        this.addParam("gnrCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/detail.json";
    }
}

