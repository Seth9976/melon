package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreMoreIntroRes;

public class GenreMoreIntroReq extends RequestV5Req {
    public GenreMoreIntroReq(Context context0, String s) {
        super(context0, 0, GenreMoreIntroRes.class, true);
        this.addParam("gnrCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/more/intro.json";
    }
}

