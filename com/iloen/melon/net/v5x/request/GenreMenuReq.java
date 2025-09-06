package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreMenuRes;

public class GenreMenuReq extends RequestV5Req {
    public GenreMenuReq(Context context0) {
        super(context0, 0, GenreMenuRes.class, true);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/menu.json";
    }
}

