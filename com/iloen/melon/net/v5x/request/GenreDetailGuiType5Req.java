package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res;

public class GenreDetailGuiType5Req extends RequestV5Req {
    public GenreDetailGuiType5Req(Context context0, String s) {
        super(context0, 0, GenreDetailGuiType5Res.class, true);
        this.addParam("gnrCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/detail/guitype5.json";
    }
}

